import java.util.*;

public class Node {
  private int value;
  private List<Edge> edges;

  public Node(int value) {
    this.value = value;
    this.edges = new ArrayList<>();
  }

  public int getValue() {
  	return value;
  }

  public List<Edge> getEdges() {
  	return edges;
  }

  public void connectTo(Node n) {
    Edge e = new Edge(this, n);
  	edges.add(e);
    e = new Edge(n, this);
  	n.getEdges().add(e);
  }

  public void connectTo(Node n, int weight) {
    Edge e = new Edge(this, n, weight);
    edges.add(e);
    e = new Edge(n, this, weight);
    n.getEdges().add(e);
  }
}