import com.google.common.graph.ImmutableValueGraph;
import com.google.common.graph.ValueGraphBuilder;

/**
 * Class for a map of the biomes
 */
public class RoomConnections {
  private ImmutableValueGraph<String, String> Graph;

  /**
   * Creates a graph that maps all the biomes and their named connections
   */
  public RoomConnections() {
    this.Graph = ValueGraphBuilder.directed()
    .<String, String>immutable()
    .putEdgeValue("rainforest", "aquatic", "east")
    .putEdgeValue("aquatic", "rainforest", "west")
    .putEdgeValue("rainforest", "desert", "south")
    .putEdgeValue("desert", "rainforest", "north")
    .putEdgeValue("lab", "rainforest", "northwest")
    .putEdgeValue("rainforest", "lab", "southeast")
    .putEdgeValue("aquatic", "tundra", "south")
    .putEdgeValue("tundra", "aquatic", "north")
    .putEdgeValue("lab","aquatic", "northeast")
    .putEdgeValue("aquatic", "lab", "southwest")
    .putEdgeValue("desert","tundra", "east")
    .putEdgeValue("tundra", "desert", "west")
    .putEdgeValue("lab", "desert", "southwest")
    .putEdgeValue("desert", "lab", "northeast")
    .putEdgeValue("lab", "tundra", "southeast")
    .putEdgeValue("tundra", "lab", "northwest")
    .build();
  }

  /**
   * Getter for the biome map/graph
   * @return the biome graph
   */
  public ImmutableValueGraph<String, String> getGraph() {
    return this.Graph;
  }
}