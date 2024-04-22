import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.google.common.graph.EndpointPair;
import com.google.common.graph.ImmutableValueGraph;

public class GameLoop {
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
        ArrayList<String> inventory = new ArrayList<>();

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
        System.out.println("\nInsert instructions for game + intro");
        System.out.println("\nEnter your username:");
        String username = userInput.nextLine().toLowerCase(); //Check for invalid and store

        // The do...while structure means we execute the body of the loop once before checking the stopping condition
        do {
            // ************************************************
            // The stuff that happens in your game will go here
            //  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓
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
                if (!edgeArrayList.contains(userResponse)) {
                  System.out.println("Invalid answer. Type new response.");
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

                //Checks user location
                if (userLocation.equals("lab")) {
                    //Fill in with commands
                    System.out.println("Filler for lab");
                }
                if (userLocation.equals("rainforest")) {
                    rainforest.welcome();
                    rainforest.riddle();
                }
                if (userLocation.equals("desert")) {
                    desert.welcome();
                    desert.riddle();
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