import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import com.google.common.collect.UnmodifiableIterator;
import com.google.common.graph.EndpointPair;
import com.google.common.graph.ImmutableValueGraph;
import com.google.common.graph.ValueGraphBuilder;

public class RoomConnections {
  public static void main(String[] args) {

    // Example ImmutableGraph with Strings as Node data
    ImmutableValueGraph<String, String> Graph = ValueGraphBuilder.directed()
      .<String, String>immutable()
      .putEdgeValue("rainforest", "aquatic", "boat passage")
      .putEdgeValue("aquatic", "rainforest", "boat passage")
      .putEdgeValue("rainforest", "desert", "oasis trek")
      .putEdgeValue("desert", "rainforest", "oasis trek")
      .putEdgeValue("lab", "rainforest", "mountain climb")
      .putEdgeValue("rainforest", "lab", "mountain climb")
      .putEdgeValue("aquatic", "tundra", "steamboat way")
      .putEdgeValue("tundra", "aquatic", "steamboat way")
      .putEdgeValue("lab","aquatic", "submarine sink")
      .putEdgeValue("aquatic", "lab", "submarine sink")
      .putEdgeValue("desert","tundra", "alaska airlines")
      .putEdgeValue("tundra", "desert", "alaska airlines")
      .putEdgeValue("lab", "desert", "dune hike")
      .putEdgeValue("desert", "lab", "dune hike")
      .putEdgeValue("lab", "tundra", "cave corner")
      .putEdgeValue("tundra", "lab", "cave corner")
      .build();
    
    String userLocation = "lab";

    ArrayList<String> targetArrayList = new ArrayList<>();
    ArrayList<String> sourceArrayList = new ArrayList<>();
    ArrayList<String> edgeArrayList = new ArrayList<>();

    System.out.println("The following paths you may take are listed below:");
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
    System.out.println(Graph.edgeValueOrDefault(source, target, "None"));
    }

    Scanner userInput = new Scanner(System.in);

    String userResponse = "";

    System.out.println("\nChoose a path:");
    userResponse = userInput.nextLine().toLowerCase();
    // if (edgeArrayList.contains(userResponse)) {
    //   System.out.println("Wrong! Enter new answer");
    //   userResponse = userInput.nextLine().toLowerCase();
    for (int i=0; i < sourceArrayList.size(); i++) {
        String source = sourceArrayList.get(i);
        String target = targetArrayList.get(i);
        String nEdges = Graph.edgeValueOrDefault(source, target, "None");
        if (userResponse == nEdges) {
          System.out.println("Welcome to the " + target + " biome!");
    }
  }


    // boolean exit_menu = false;
    // while (!exit_menu) {
    //   //Print message for following paths user can take
    //   //Print following paths for user
    //   userResponse = userInput.nextLine().toUpperCase();
    //   //if (userResponse != one of the available edges) {}
    //   //else: update node based on edge chosen
    //   //Series of if statements based on node of user
    //   if (userLocation == "Lab") {
    //     //Call lab methods
    //   }
    //   if (userLocation == "Rainforest") {
    //     //Call methods
    //   }
    //   if (userLocation == "Desert") {
    //     //Call methods
    //   }
    //   if (userLocation == "Aquatic") {
    //     //Call methods
    //   }
    //   if (userLocation == "Tundra") {
    //     //Call methods
    //   }
    // }

    userInput.close();
    }
  }