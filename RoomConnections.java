import com.google.common.graph.*;

public class RoomConnections {
  public static void main(String[] args) {

    // Example ImmutableGraph with Strings as Node data
    ImmutableGraph<String> myGraph = GraphBuilder.undirected()
      .<String>immutable()
      .putEdge("Rainforest", "Aquatic")
      .putEdge("Rainforest", "Desert")
      .putEdge("Rainforest", "Lab")
      .putEdge("Aquatic", "Tundra")
      .putEdge("Aquatic","Lab")
      .putEdge("Desert","Tundra")
      .putEdge("Desert", "Lab")
      .putEdge("Tundra", "Lab")
      .build();

    System.out.println(myGraph);
  }

}