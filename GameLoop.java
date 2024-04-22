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
        ArrayList<String> sourceArrayList = new ArrayList<>();
        ArrayList<String> edgeArrayList = new ArrayList<>();
        Rainforest rainforest = new Rainforest();
        Desert desert = new Desert();
        Aquatic aquatic = new Aquatic();
        Tundra tundra = new Tundra();
        ArrayList<FloraFauna> inventory = new ArrayList<>();
        boolean hasFrog = false;
        boolean hasCacao = false;
        boolean hasCamel = false;
        boolean hasCactus = false;
        //add other had animals

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

            //Checks user location
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

            if (userLocation.equals("rainforest")) {
                rainforest.welcome(); //Make it so user can't go back to forest after collecting objects!
                if (hasFrog == false) {
                    FloraFauna poison_dart_frog = rainforest.frogriddle(userInput);
                    if (poison_dart_frog == null) {
                        userLocation = "lab";
                        inventory.clear();
                        hasFrog = false;
                        hasCacao = false;
                    } else {
                        inventory.add(poison_dart_frog);
                        hasFrog = true;
                    }  
                if (inventory.contains(poison_dart_frog) && hasCacao == false) {
                    FloraFauna cacao = rainforest.cacaoriddle(userInput);
                    if (cacao == null) {
                        userLocation = "lab";
                        inventory.clear();
                        hasFrog = false;
                        hasCacao = false;
                    } else {
                        inventory.add(cacao);
                        hasCacao = true;
                    }
                }
                } else {
                    System.out.println("No more creatures to find here!");
                }
            }


            if (userLocation.equals("desert")) { //Complete edits to look like rainforest
                desert.welcome();
                FloraFauna camel = desert.camelriddle(userInput);
                if (camel == null) {
                    userLocation = "lab";
                    inventory.clear();
                } else {
                    inventory.add(camel);
                    FloraFauna cactus = desert.cactusriddle(userInput);
                    if (cactus == null) {
                        userLocation = "lab";
                        inventory.clear();
                    } else {
                        inventory.add(cactus);
                    }
                }
            } 


            if (userLocation.equals("aquatic")) {
                //Fill with aquatic
                aquatic.welcome();
                aquatic.riddle();
            }



            if (userLocation.equals("tundra")) {
                tundra.welcome();
                tundra.riddle();
            }



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

        // Once you exit the loop, you may need to deal with various possible stopping conditions
        // if (userLocation.equals("Lab") && userResponse.equals("North")) {
        //     System.out.println("Yay, you won!");
        // } else { // userResponse.equals("LOSE")
        //     System.out.println("Better luck next time.");
        // }

    }

}