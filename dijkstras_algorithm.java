import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Name: ZhaoYuan Yu ID: 250919971
 */
public class dijkstras_algorithm {

	static int num_of_vertex;
	public static void main(String[] args) {

	}

	public static void dijkstras(ArrayList<LinkedList<Edge>> Graph, int root) {
		Edge[] keys = new Edge[num_of_vertex + 1];
		int[] parent = new int[num_of_vertex + 1];

		for (int i = 0; i <= num_of_vertex; i++) {
			Edge eg = new Edge(0, 0, Integer.MAX_VALUE);
			keys[i] = eg;
			parent[i] = -1;

		}

		keys[root].weight = 0;
		keys[root].u = root;
		keys[root].v = root;
		parent[root] = root;

	}
}