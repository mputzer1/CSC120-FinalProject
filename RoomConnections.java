
import com.google.common.graph.ImmutableValueGraph;
import com.google.common.graph.ValueGraphBuilder;

public class RoomConnections {
  private ImmutableValueGraph<String, String> Graph;

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

  public ImmutableValueGraph<String, String> getGraph() {
    return this.Graph;
  }
}