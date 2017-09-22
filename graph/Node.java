import java.util.*;

public class Node {
  public int value;
  public List<Node> adjacent;

  public Node(int value) {
    this.value = value;
    this.adjacent = new ArrayList<>();
  }
}