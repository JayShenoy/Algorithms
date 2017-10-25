public class Edge implements Comparable{
	private Node n1;
	private Node n2;
	private int weight;

	public Edge(Node n1, Node n2) {
		this.n1 = n1;
		this.n2 = n2;
		this.weight = 1;
	}

	public Edge(Node n1, Node n2, int weight) {
		this.n1 = n1;
		this.n2 = n2;
		this.weight = weight;
	}

	public Node start() {
		return n1;
	}

	public Node end() {
		return n2;
	}

	public int getWeight() {
		return weight;
	}

	public int compareTo(Edge e) {
		return this.getWeight() - n.getWeight();
	}
}