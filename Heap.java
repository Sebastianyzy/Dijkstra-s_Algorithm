/**
 * Name: ZhaoYuan Yu ID: 250919971
 */

public class Heap implements HeapADT {
	// global variables
	public Edge[] Eg;
	public int[] H;
	private int max;
	private int hMax;

	/*
	 * Constructor
	 */
	public Heap() {

	}

	// initializes a heap with the array keys of n elements.
	public void heap(Edge[] keys, int n) {
		// array of edges
		Eg = keys;
		// Set the max
		max = n - 1;
		// array of 2*max elements
		H = new int[2 * max];
		// hMax
		hMax = 2 * max - 1;

		// organize the heap
		heapify();
	}

	// returns true if the element whose id is id is in the heap;
	public boolean in_heap(Edge id) {
		// Comparison
		Edge check = new Edge(0, 0, 0);
		for (Edge edge : Eg) {
			check = edge;
			if (check.u == id.u && check.v == id.v && check.weight == id.weight) {
				return true;
			} else if (check.u == id.v && check.v == id.u && check.weight == id.weight) {
				return true;
			}
		}
		return false;
	}

	// returns the minimum key of the heap;
	public int min_key() {
		return Eg[H[1]].getWeight();
	}

	// returns the id of the element with minimum key in the heap;
	public int min_id() {
		return H[1];
	}

	// returns the key of the element whose id is id in the heap;
	public int key(int id) {
		return Eg[id].getWeight();
	}

	// deletes the element with minimum key from the heap;
	public Edge delete_min() {
		Edge removed = new Edge(0, 0, Integer.MAX_VALUE);
		Eg[0] = removed;
		H[H[1] + max - 1] = 0;
		Edge v = Eg[H[1]];
		int i = (int) Math.floor((H[1] + max - 1) / 2);
		// reheapify
		while (i >= 1) {
			if (Eg[H[2 * i]].getWeight() < Eg[H[2 * i + 1]].getWeight()) {
				H[i] = H[2 * i];
			} else {
				H[i] = H[2 * i + 1];
			}
			i = (int) Math.floor(i / 2);
		}
		return v;
	}

	// sets the key of the element whose id is id to new key if its current key is
	// greater than new key.
	public void decrease_key(int id, int new_key) {
		Eg[id].weight = new_key;
		int i = (int) Math.floor((id + max - 1) / 2);
		// reheapify
		while (i >= 1) {
			if (Eg[H[2 * i]].weight < Eg[H[2 * i + 1]].weight) {
				H[i] = H[2 * i];
			} else {
				H[i] = H[2 * i + 1];
			}
			i = (int) Math.floor(i / 2);
		}
	}

	/*
	 * heapify method
	 */
	private void heapify() {
		for (int i = max; i <= hMax; i++) {
			H[i] = i - max + 1;
		}
		for (int i = max - 1; i >= 1; i--) {
			if (Eg[H[2 * i]].getWeight() < Eg[H[2 * i + 1]].getWeight()) {
				H[i] = H[2 * i];
			} else {
				H[i] = H[2 * i + 1];
			}
		}
	}

}
