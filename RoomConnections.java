import com.google.common.graph.ImmutableValueGraph;
import com.google.common.graph.ValueGraphBuilder;

public class RoomConnections {
  public static void main(String[] args) {

    // Example ImmutableGraph with Strings as Node data
    ImmutableValueGraph<String, String> myGraph = ValueGraphBuilder.undirected()
      .<String, String>immutable()
      .putEdgeValue("Rainforest", "Aquatic", "East")
      .putEdgeValue("Aquatic", "Rainforest", "West")
      .putEdgeValue("Rainforest", "Desert", "South")
      .putEdgeValue("Rainforest", "Lab", "Lab")
      // .putEdge("Aquatic", "Tundra")
      // .putEdge("Aquatic","Lab")
      // .putEdge("Desert","Tundra")
      // .putEdge("Desert", "Lab")
      // .putEdge("Tundra", "Lab")
      .build();

    System.out.println(myGraph);
  }

}