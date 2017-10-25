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
      if(n.getValue() == value) return true;
      visited.add(n);

      for(Edge i : n.getEdges()) {
        Node adjacent = i.end();
        if(!visited.contains(adjacent)) toVisit.add(adjacent);
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
      if(n.getValue() == value) return true;
      visited.add(n);

      for(Edge i : n.getEdges()) {
        Node adjacent = i.end();
        if(!visited.contains(adjacent)) toVisit.push(adjacent);
      }
    }

    return false;
  }

  private Set<Node> allNodes() {
    Set<Node> allNodes = new HashSet<>();
    Stack<Node> toVisit = new Stack<>();
    toVisit.add(root);

    while(!toVisit.isEmpty()) {
      Node n = toVisit.pop();
      allNodes.add(n);

      for(Edge i : n.getEdges()) {
        Node adjacent = i.end();
        if(!allNodes.contains(adjacent)) toVisit.push(adjacent);
      }
    }

    return allNodes;
  }

  public Set<Node> prim() {
    Set<Edge> mst = new HashSet<>();
    Set<Node> visited = new HashSet<>();
    PriorityQueue<Node> pq = new PriorityQueue<>(100, );
    Map<Node, Integer> minWeight = new HashMap<>();
    Map<Node, Node> parent = new HashMap<>();

    for(Node n : allNodes()) {
      minWeight.put(n, Integer.MAX_VALUE);
      pq.add(n);
    }

    minWeight.put(root, 0);

    while(!pq.isEmpty()) {
      Edge e = pq.poll();
      Node n = e.start();
      visited.add(n);
      mst.add(e);

      for(Edge i : n.getEdges()) {
        Node adj = i.end();
        if(!visited.contains(adj)) pq.add(new Edge(n, adj. i.getWeight()))
      }
    }

    return mst;
  }

  public static void main(String[] args) {
    Node n = new Node(1);
    Node second = new Node(2);
    Node third = new Node(3);
    Graph g = new Graph(third);
    n.connectTo(second);
    second.connectTo(third);
    System.out.println(g.dfs(1));
  }
}