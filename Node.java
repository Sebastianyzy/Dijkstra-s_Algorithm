public class Node implements Comparable<Node> {
	private final int vertex;
	private int distance;

	public Node(int vertex, int distance) {
		this.vertex = vertex;
		this.distance = distance;
	}

	public int getVertex() {
		return vertex;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int compareTo(Node that) {
		return this.distance - that.distance;
	}

	public String toString() {
		return "key = " + this.vertex + ", weight = " + this.distance + "." + "\n";
	}
}