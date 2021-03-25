import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class dijkstras_algorithm {
	public static String infile;
	private static int num_of_vertex;
	private static LinkedList[] adj_list;
	private static Node[] distance;

	dijkstras_algorithm(int num_of_vertex) {
		dijkstras_algorithm.num_of_vertex = num_of_vertex;
		adj_list = new LinkedList[num_of_vertex + 1];
		// initialize adjacency list
		for (int i = 1; i <= num_of_vertex; i++) {
			adj_list[i] = new LinkedList<>();
		}
		// initialize distance array
		distance = new Node[num_of_vertex + 1];
	}

	public static void main(String[] args) {
		// Finds file, change path here to change
		infile = args[0];
		File inputGraph = new File(infile);
		try {
			Scanner input = new Scanner(inputGraph);
			int numOfVertices = input.nextInt();
			input.nextLine();
			dijkstras_algorithm graph = new dijkstras_algorithm(numOfVertices);
			while (input.hasNextLine()) {
				int first = input.nextInt();
				int sec = input.nextInt();
				int weight = input.nextInt();
				input.nextLine();
				graph.addEdge(first, sec, weight);
			}
			input.close();

			System.out.println("(1) Print Out Input Graph:" + "\n");
			graph.Print_Matrix();
			System.out.println("*****************************************\n");

			System.out.println("(2) The Shortest Path Tree Edges With Shortest Path Weights: " + "\n");
			for (int i = 1; i <= numOfVertices; i++) {
				graph.dijkstras(i);
				System.out.println("----------------------------------------");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("File Not Found.");
		}
		System.out.println("Finished.");
	}

	public void dijkstras(int source) {
		boolean[] visited = new boolean[num_of_vertex + 1];
		// set each distance to infinity
		for (int i = 0; i < visited.length; i++) {
			distance[i] = new Node(i, Integer.MAX_VALUE);
		}
		// initialize distance
		distance[source].setDistance(0);

		// initialize heap
		Heap minHeap = new Heap();
		minHeap.heap(distance, distance.length);

		while (!minHeap.isEmpty()) {
			// delete the min
			Node u = minHeap.delete_min();
			visited[u.getVertex()] = true;
			if (u.getVertex() == 0) {
				continue;
			}
			LinkedList<Edge> edges = adj_list[u.getVertex()];
			for (Edge e : edges) {
				int destination = e.get_Destination();

				if (!visited[destination]) {
					int currDist = distance[destination].getDistance();
					int newDist = distance[u.getVertex()].getDistance() + e.getWeight();
					if (currDist > newDist) {
						distance[destination].setDistance(newDist);
						minHeap.decrease_key(destination, distance[destination].getDistance());
					}
				}
			}
		}
		Print_Path(distance, source);

	}

	public void Print_Path(Node[] distance, int source) {
		for (int i = 1; i <= num_of_vertex; i++) {
			System.out.println("(" + source + "," + i + ") : " + distance[i].getDistance());
		}
	}

	public void Print_Matrix() {
		for (int i = 1; i < adj_list.length; i++) {
			LinkedList<Edge> edges = adj_list[i];
			System.out.print("vertex " + i + ":" + "\n");
			for (Edge e : edges) {
				System.out.print(e);
			}
			System.out.println("-----------------------------------------");
		}
	}

	public void addEdge(int source, int destination, int weight) {
		Edge edge = new Edge(source, destination, weight);
		adj_list[source].add(edge);
	}
}