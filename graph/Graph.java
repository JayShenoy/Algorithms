import java.util.*;

public class Graph {
  private Node root;

  public Graph(Node n) {
    this.root = n;
  }

  public boolean bfs(int value) {
    Set<Node> visited = new HashSet<>();
    Queue<Node> toVisit = new LinkedList<>();
    toVisit.add(root);

    while(!toVisit.isEmpty()) {
      Node n = toVisit.remove();
      if(n.value == value) return true;
      visited.add(n);

      for(Node i : n.adjacent) {
        if(!visited.contains(i)) toVisit.add(i);
      }
    }

    return false;
  }

  public boolean dfs(int value) {
    Set<Node> visited = new HashSet<>();
    Stack<Node> toVisit = new Stack<>();
    toVisit.add(root);

    while(!toVisit.isEmpty()) {
      Node n = toVisit.pop();
      if(n.value == value) return true;
      visited.add(n);

      for(Node i : n.adjacent) {
        if(!visited.contains(i)) toVisit.push(i);
      }
    }

    return false;
  }

  public static void main(String[] args) {
    Node n = new Node(1);
    Graph g = new Graph(n);
    Node second = new Node(2);
    n.adjacent.add(second);
    System.out.println(g.dfs(1));
  }
}