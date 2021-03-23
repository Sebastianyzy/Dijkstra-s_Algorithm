/**
 * Name: ZhaoYuan Yu ID: 250919971
 */

public class Edge {

	// Components of an Edge
	public int u;
	public int v;
	public int weight;

	/*
	 * Edge Constructor
	 */
	public Edge(int s, int f, int weight) {
		this.u = s;
		this.v = f;
		this.weight = weight;
	}

	/*
	 * return edge source
	 */
	public int getFirstEndPoint() {
		return this.u;
	}

	/*
	 * return edge destination
	 */
	public int getLastEndPoint() {
		return this.v;
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
	public String Print_Edge() {
		return "U = " + this.u + " V = " + this.v + " Weight = " + this.weight + "\n";
	}
}