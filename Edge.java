public class Edge {

	// Components of an Edge
	private final int source;
	private final int destination;
	private final int weight;

	/*
	 * Edge Constructor
	 */
	public Edge(int s, int f, int weight) {
		this.source = s;
		this.destination = f;
		this.weight = weight;
	}

	/*
	 * return edge source
	 */
	public int get_Source() {
		return this.source;
	}

	/*
	 * return edge destination
	 */
	public int get_Destination() {
		return this.destination;
	}

	/*
	 * get the weight of the edge
	 */
	public int getWeight() {
		return this.weight;
	}

	/*
	 * prints out the edge content
	 */
	public String toString() {
		return "source = " + this.source + "  destination = " + this.destination + " weight = " + this.weight + "."
				+ "\n";
	}
}