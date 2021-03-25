public class Heap implements HeapADT {
	// global variables
	public int capacity, current_size;
	public int[] index;
	public Node[] heap;

	public Heap() {
	}

	// initializes a heap with the array keys of n elements.
	public void heap(Node[] keys, int n) {
		this.capacity = n;
		heap = new Node[capacity + 1];
		index = new int[capacity];
		heap[0] = new Node(-1, Integer.MIN_VALUE);
		current_size = 0;
		for (Node key : keys) {
			insert(key);
		}
	}

	// returns true if the element whose id is id is in the heap;
	public boolean in_heap(int id) {
		for (Node node : heap) {
			if (node.getVertex() == id) {
				return true;
			}
		}
		return false;
	}

	// returns the minimum key of the heap;
	public Node min_key() {
		return heap[1];
	}

	// returns the id of the element with minimum key in the heap;
	public int min_id() {
		return index[heap[1].getVertex()];
	}

	// returns the key of the element whose id is id in the heap;
	public Node key(int id) {
		return heap[id];
	}

	// deletes the element with minimum key from the heap;
	public Node delete_min() {
		Node min = heap[1];
		Node last = heap[current_size];
		index[last.getVertex()] = 1;
		heap[1] = last;
		heap[current_size] = null;
		sinkDown(1);
		current_size--;
		return min;
	}

	// sets the key of the element whose id is id to new key if its current key is
	// greater than new key.
	public void decrease_key(int id, int new_key) {
		int i = index[id];
		heap[i].setDistance(new_key);
		bubbleUp(i);
	}

	public boolean isEmpty() {
		return current_size == 0;
	}

	private void sinkDown(int k) {
		int smallest = k;
		int leftChildIdx = 2 * k;
		int rightChildIdx = 2 * k + 1;
		if (leftChildIdx < Heap_Size() && heap[smallest].getDistance() > heap[leftChildIdx].getDistance()) {
			smallest = leftChildIdx;
		}
		if (rightChildIdx < Heap_Size() && heap[smallest].getDistance() > heap[rightChildIdx].getDistance()) {
			smallest = rightChildIdx;
		}
		if (smallest != k) {
			Node smallestNode = heap[smallest];
			Node kNode = heap[k];
			// swap the positions
			index[smallestNode.getVertex()] = k;
			index[kNode.getVertex()] = smallest;
			swap(k, smallest);
			sinkDown(smallest);
		}
	}

	private void swap(int cur_id, int parent_id) {
		Node temp = heap[cur_id];
		heap[cur_id] = heap[parent_id];
		heap[parent_id] = temp;
	}

	private void insert(Node key) {
		current_size += 1;
		int id = current_size;
		heap[id] = key;
		index[key.getVertex()] = id;
		bubbleUp(id);
	}

	private void bubbleUp(int id) {
		int parent_id = id / 2;
		int cur_id = id;
		while (cur_id > 0 && heap[parent_id].getDistance() > heap[cur_id].getDistance()) {
			Node current_node = heap[cur_id];
			Node parent_node = heap[parent_id];
			// swap position
			index[current_node.getVertex()] = parent_id;
			index[parent_node.getVertex()] = cur_id;
			swap(cur_id, parent_id);
			cur_id = parent_id;
			parent_id /= 2;
		}
	}

	private int Heap_Size() {
		return current_size;
	}

}
