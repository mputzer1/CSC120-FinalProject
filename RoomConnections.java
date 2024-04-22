
import com.google.common.graph.ImmutableValueGraph;
import com.google.common.graph.ValueGraphBuilder;

public class RoomConnections {
  private ImmutableValueGraph<String, String> Graph;

  public RoomConnections() {
    this.Graph = ValueGraphBuilder.directed()
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
  }

  public ImmutableValueGraph<String, String> getGraph() {
    return this.Graph;
  }
}