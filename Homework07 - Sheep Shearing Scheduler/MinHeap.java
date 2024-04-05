
/*
 * Written by Maximus Fernandez
 * Sheep Shearing Scheduler
 * Due 04/05/2024 by 11:55pm
 */

//Notes about heaps:

//Heap is also called a Priority Queue
//Heap is First in First Out
//Min heap: children must be greater than or equal to the parent (smaller values at top) [most commonly used]
//Max heap: children must be less than or equal to the parent (bigger values at top)
//a queue is meant to process waiting data, in order to process data, it must arrive first


// Generic Min Heap implementation
public class MinHeap<T extends Comparable<T>> {
    private T[] heap; //heap is stored in an array
    public static final int DEF_SIZE = 128; //default size
    //64, 512, 1024, 16 (powers of 2 / base 2 value guarantees a left/right child) <-- these are all good options
    private int size; // Index of the first null element = same thing as taco manager and queue

    // Default constructor initializes with default size
    public MinHeap() {
        init(DEF_SIZE);
    }

    // Constructor with custom size
    public MinHeap(int size) {
        init(size);
    }

    // Initialize the heap with the specified size
    private void init(int size) {
    	
    	this.size=0;
    	if(size >= 1)
    		//creates an array of type Comparable (necessary for creating this generic-type structure)
        	//typecasted to an array
    		heap = (T[]) (new Comparable[size]); 
    	else
    		heap = (T[]) (new Comparable[DEF_SIZE]); // If size is not positive, use default size
    }

    // Add an element to the heap
    public void add(T aData) {
        if (size >= heap.length)
            return; // Heap is full, cannot add more elements
        heap[size] = aData;
        bubbleUp();
        size++;
    }

    // Bubble up the last element added to maintain the heap property
    private void bubbleUp() {
        int index = size;
        while (index > 0 && heap[pI(index)].compareTo(heap[index]) > 0) {
            T temp = heap[pI(index)];
            heap[pI(index)] = heap[index];
            heap[index] = temp;
            index = pI(index);
        }
    }

    //parent index
    private int pI(int index)
    {
    	return (index-1)/2;
    }
    //left index
    private int lI(int index)
    {
    	return index*2+1;
    }
    //right index
    private int rI(int index)
    {
    	return index*2+2;
    }
    // Remove and return the root element of the heap
    public T remove() {
    	if(size <= 0)
    		return null; // Heap is empty
    	T ret = heap[0];
    	heap[0] = heap[size-1];
    	heap[size-1] = null;
    	size--;
    	bubbleDown();
    	return ret;
    }

    // Bubble down the root element to maintain the heap property
    private void bubbleDown() {
    	int index = 0;
    	while(lI(index)<size)
    	{
    		int smallIndex = lI(index);
    		if(rI(index) < size && 
    				heap[lI(index)].compareTo(heap[rI(index)])>0)
    		{
    			smallIndex = rI(index);
    		}
    		if(heap[index].compareTo(heap[smallIndex])>0)
    		{
    			T temp = heap[index];
    			heap[index] = heap[smallIndex];
    			heap[smallIndex] = temp;
    		}
    		else
    			break;
    		index = smallIndex;
    	}
    }

    // Print the elements of the heap
    public void print() {
        for (T h : heap) {
            if (h == null)
                break; // Reached the end of the heap
            System.out.println(h);
        }
    }

    // Sort an array using heap sort 
    /*
     * heap sort: 
     * 1. add all value to the heap
     * 2. remove all values from the heap
     * 3. done
     * (Complexity: O(n(lgn))
     * sorted in descending order (worst case)
     * operations:
     * add all n values
     * restore all n values
     * 
     * 
    */
    public void heapSort(T[] array) {
        if (array == null)
            return; // Array is null, nothing to sort
        MinHeap<T> mHeap = new MinHeap<T>(array.length); //create a heap
        for (int i = 0; i < array.length; i++)
            mHeap.add(array[i]); // Add elements of the array to the heap
        for (int i = 0; i < array.length; i++)
            array[i] = mHeap.remove(); // Remove elements from the heap and assign them back to the array
    }
}
