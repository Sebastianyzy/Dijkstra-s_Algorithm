/**
 * Name: ZhaoYuan Yu ID: 250919971
 */

public interface HeapADT {

	// initializes a heap with the array keys of n elements.
	void heap(Node[] keys, int n);

	// returns true if the element whose id is id is in the heap;
	boolean in_heap(int id);

	// returns the minimum key of the heap;
	Node min_key();

	// returns the id of the element with minimum key in the heap;
	int min_id();

	// returns the key of the element whose id is id in the heap;
	Node key(int id);

	// deletes the element with minimum key from the heap;
	Node delete_min();

	// sets the key of the element whose id is id to new key if its current key is
	// greater than new key.
	void decrease_key(int id, int new_key);
}