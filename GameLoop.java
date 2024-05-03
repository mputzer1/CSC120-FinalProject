import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.google.common.graph.EndpointPair;
import com.google.common.graph.ImmutableValueGraph;

/**
 * Runs the commands of the game in order until user wins/loses
 */
public class GameLoop { 

    /**
     * Main method that runs the whole game loop
     */
    public static void main(String[] args) {
        
        //Accesses the guava biome map
        BiomeMap biomeMap = new BiomeMap();
        ImmutableValueGraph<String, String> Graph = biomeMap.getGraph();
        
        //Allows files to be read
        FileClass fileClass = new FileClass();
        
        //Helps for storage of possible locations player can go
        ArrayList<String> targetArrayList = new ArrayList<>();
        ArrayList<String> sourceArrayList = new ArrayList<>(); 
        ArrayList<String> edgeArrayList = new ArrayList<>();
        
        //Creates the biomes the player can visit
        Rainforest rainforest = new Rainforest();
        Desert desert = new Desert();
        Aquatic aquatic = new Aquatic();
        Tundra tundra = new Tundra();
        
        //Creates the lab with the player's inventory
        Lab lab = new Lab();
        ArrayList<FloraFauna> inventory = lab.getInventory();

        //Keeps track of player location
        String userLocation = "lab";

        //Builds the ArrayList that is looped for the if statement that calls riddles and checks player location
        ArrayList<Biome> biomes = new ArrayList<>();
        biomes.add(rainforest);
        biomes.add(desert);
        biomes.add(tundra);
        biomes.add(aquatic);

        //Sets up images
        DisplayImage imageDisplay = new DisplayImage();
        imageDisplay.setVisible(true);

        // This is a "flag" to let us know when the loop should end
        boolean stillPlaying = true;

        // We'll use this to get input from the user.
        Scanner userInput = new Scanner(System.in);

        // Storage for user's responses
        String userResponse = "";

        // Introduction for the game where user inputs their username
        String labImage = Lab.getImagePath();
        imageDisplay.updateImage(labImage);
        fileClass.fileReader("Introduction.txt");
        System.out.println("\nEnter your username:");
        String username = userInput.nextLine().toLowerCase(); 
        while (username.length() > 10 || username.length() < 1) {
            System.out.println("Your username is too long or short. Type another.");
            username = userInput.nextLine().toLowerCase();
        }

        do {

            //Checks user location and shows paths available
            System.out.println("\nThe following paths you may take are listed below:");
            Iterator<EndpointPair<String>> GraphIterator = Graph.incidentEdges(userLocation).iterator();
            while (GraphIterator.hasNext()) {
                EndpointPair<String> edge = GraphIterator.next();
                String targetNode = edge.target();
                if (targetNode != userLocation) {
                    targetArrayList.add(targetNode);
                }
                String sourceNode = edge.source();
                if (sourceNode == userLocation) {
                    sourceArrayList.add(sourceNode);
                }
                }
                for (int i=0; i < sourceArrayList.size(); i++) {
                    String source = sourceArrayList.get(i);
                    String target = targetArrayList.get(i);
                    edgeArrayList.add(Graph.edgeValueOrDefault(source, target, "None"));
                    System.out.println("* " + Graph.edgeValueOrDefault(source, target, "None"));
                }

            //Allows player to choose a path
            System.out.println("\nChoose a path:");
            userResponse = userInput.nextLine().toLowerCase();
            while (!edgeArrayList.contains(userResponse)) {
                System.out.println("Invalid answer. Type new response."); //Class for help commands/inventory check?
                userResponse = userInput.nextLine().toLowerCase();
            }
            for (int i=0; i < sourceArrayList.size(); i++) {
                String source = sourceArrayList.get(i);
                String target = targetArrayList.get(i);
                String nEdges = Graph.edgeValueOrDefault(source, target, "None");
                if (nEdges.equals(userResponse)) {
                    System.out.println("\nWelcome to the " + target + " biome!");
                    userLocation = target;
                    targetArrayList.clear();
                    sourceArrayList.clear();
                    edgeArrayList.clear();
                }
            }

            //Series of if statements to check user location, ask riddles, and update inventory
            for (int i=0; i < biomes.size(); i++) {
                String stringBiome = biomes.get(i).toString();
                if (userLocation.equals(stringBiome)) {
                    Biome classBiome = biomes.get(i);
                    String imagePath = classBiome.getImagePath();
                    imageDisplay.updateImage(imagePath);
                    FloraFauna animal = classBiome.getAnimal();
                    if (!inventory.contains(animal)) {
                        animal = classBiome.animalRiddle(userInput);
                        if (animal == null) {
                            userLocation = lab.resetInventory();
                        } else {
                            inventory.add(animal);
                            FloraFauna plant = classBiome.plantRiddle(userInput);
                            if (plant == null) {
                                userLocation = lab.resetInventory();
                            } else {
                                inventory.add(plant);
                                FloraFauna monster = classBiome.secretLocation(userInput);
                                if (monster != null) {
                                    inventory.add(monster);
                                }
                            }
                        }
                    } else {
                       System.out.println("\nNo more creatures to find in the " + stringBiome + " biome!");
                    }
                }
            }

           // Allows user to check and review inventory in the lab 
            if (userLocation.equals("lab")) {
                imageDisplay.updateImage(labImage);
                lab.checkInventory(userInput);
                stillPlaying = lab.submitInventory(userInput, username, fileClass, stillPlaying);
            }

        } while (stillPlaying);

        userInput.close();
        System.exit(0);

    }
}