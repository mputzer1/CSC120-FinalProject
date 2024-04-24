import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.google.common.graph.EndpointPair;
import com.google.common.graph.ImmutableValueGraph;

public class GameLoop { //Maybe have a class w/ help commands?
    public static void main(String[] args) {
        
        //Attributes
        RoomConnections RoomConnections = new RoomConnections();
        ImmutableValueGraph<String, String> Graph = RoomConnections.getGraph();
        String userLocation = "lab";
        ArrayList<String> targetArrayList = new ArrayList<>();
        ArrayList<String> sourceArrayList = new ArrayList<>(); //Consider consolidating these arraylists into hashtable (dictionary)
        ArrayList<String> edgeArrayList = new ArrayList<>();
        Rainforest rainforest = new Rainforest();
        Desert desert = new Desert();
        Aquatic aquatic = new Aquatic();
        Tundra tundra = new Tundra();
        ArrayList<FloraFauna> inventory = new ArrayList<>();

        // This is a "flag" to let us know when the loop should end
        boolean stillPlaying = true;

        // We'll use this to get input from the user.
        Scanner userInput = new Scanner(System.in);

        // Storage for user's responses
        String userResponse = "";

        // This could be replaced with a more interesting opening
        System.out.println("******************");
        System.out.println("WELCOME TO OUR ANIMAL GAME");
        System.out.println("******************");
        System.out.println("\nInsert instructions for game + intro. You are in a dim room...lab ");
        System.out.println("\nEnter your username:");
        String username = userInput.nextLine().toLowerCase(); //Check for invalid and store in file possibly

        // The do...while structure means we execute the body of the loop once before checking the stopping condition
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

                //Choose a path
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
            if (userLocation.equals("rainforest")) {
                FloraFauna poison_dart_frog = rainforest.getFrog();
                if (!inventory.contains(poison_dart_frog)) {
                    rainforest.welcome();
                    poison_dart_frog = rainforest.frogRiddle(userInput);
                    if (poison_dart_frog == null) {
                        userLocation = "lab";
                        inventory.clear();
                    } else {
                        inventory.add(poison_dart_frog);
                    }  
                if (inventory.contains(poison_dart_frog)) {
                    FloraFauna cacao = rainforest.cacaoRiddle(userInput);
                    if (cacao == null) {
                        userLocation = "lab";
                        inventory.clear();
                    } else {
                        inventory.add(cacao);
                    }
                }
                } else {
                    System.out.println("No more creatures to find in the rainforest!");
                }
            }



            if (userLocation.equals("desert")) { 
                FloraFauna camel = desert.getCamel();
                if (!inventory.contains(camel)) {
                    desert.welcome();
                    camel = desert.camelRiddle(userInput);
                    if (camel == null) {
                        userLocation = "lab";
                        inventory.clear();
                    } else {
                        inventory.add(camel);
                    }  
                if (inventory.contains(camel)) {
                    FloraFauna cactus = desert.cactusRiddle(userInput);
                    if (cactus == null) {
                        userLocation = "lab";
                        inventory.clear();
                    } else {
                        inventory.add(cactus);
                    }
                }
                } else {
                    System.out.println("No more creatures to find in the desert!");
                }
            } 


            if (userLocation.equals("aquatic")) {
                FloraFauna dolphin = aquatic.getDolphin();
                if (!inventory.contains(dolphin)) {
                    aquatic.welcome();
                    dolphin = aquatic.dolphinRiddle(userInput);
                    if (dolphin == null) {
                        userLocation = "lab";
                        inventory.clear();
                    } else {
                        inventory.add(dolphin);
                    }  
                if (inventory.contains(dolphin)) {
                    FloraFauna anemone = aquatic.anemoneRiddle(userInput);
                    if (anemone == null) {
                        userLocation = "lab";
                        inventory.clear();
                    } else {
                        inventory.add(anemone);
                    }
                }
                } else {
                    System.out.println("No more creatures to find in the aquatic biome!");
                }
            }


            if (userLocation.equals("tundra")) {
                if (userLocation.equals("tundra")) {
                    FloraFauna arctic_fox = tundra.getFox();
                    if (!inventory.contains(arctic_fox)) {
                        tundra.welcome();
                        arctic_fox = tundra.foxRiddle(userInput);
                        if (arctic_fox == null) {
                            userLocation = "lab";
                            inventory.clear();
                        } else {
                            inventory.add(arctic_fox);
                        }  
                    if (inventory.contains(arctic_fox)) {
                        FloraFauna fern = tundra.fernRiddle(userInput);
                        if (fern == null) {
                            userLocation = "lab";
                            inventory.clear();
                        } else {
                            inventory.add(fern);
                        }
                    }
                    } else {
                        System.out.println("No more creatures to find in the tundra!");
                    }
                }
            }

            //Allows user to check inventory in the lab
            if (userLocation.equals("lab")) {
                //Move the commands below to the lab class
                System.out.println("\nYou are back to the lab. Would you like to check your inventory?");
                userResponse = userInput.nextLine().toLowerCase();
                while (!userResponse.equals("yes") && !userResponse.equals("no")) {
                    System.out.println("\nI don't recognize " + "'" + userResponse +"'");
                    userResponse = userInput.nextLine().toLowerCase();
                }
                if (userResponse.equals("yes")) {
                    System.out.println("\n==============");
                    System.out.println("YOUR INVENTORY");
                    System.out.println("==============");
                    if (inventory.isEmpty()) {
                        System.out.println("Your inventory is empty.");
                    } else {
                        for (int i = 0; i < inventory.size(); i++) {
                            System.out.println(inventory.get(i));
                        }
                    }
                } else {
                   System.out.println("\nThe game continues!"); 
                }
            }

                //stillPlaying = false;


            // ***********************************************************************
            // And as the player interacts, you'll check to see if the game should end
            //  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓

        } while (stillPlaying);

        // Tidy up
        userInput.close();

    }

}