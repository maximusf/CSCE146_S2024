// Generic Max Heap implementation
public class GenMaxHeap<T extends Comparable<T>> {
    private T[] heap;
    public static final int DEF_SIZE = 128;
    private int lastIndex; // Index of the first null element

    // Default constructor initializes with default size
    public GenMaxHeap() {
        init(DEF_SIZE);
    }

    // Constructor with custom size
    public GenMaxHeap(int size) {
        init(size);
    }

    // Initialize the heap with the specified size
    private void init(int size) {
        if (size > 0) {
            heap = (T[]) (new Comparable[size]);
            lastIndex = 0;
        } else
            init(DEF_SIZE); // If size is not positive, use default size
    }

    // Add an element to the heap
    public void add(T aData) {
        if (lastIndex >= heap.length)
            return; // Heap is full, cannot add more elements
        heap[lastIndex] = aData;
        bubbleUp();
        lastIndex++;
    }

    // Bubble up the last element added to maintain the heap property
    private void bubbleUp() {
        int index = lastIndex;
        while (index > 0 && heap[(index - 1) / 2].compareTo(heap[index]) < 0) {
            T temp = heap[(index - 1) / 2];
            heap[(index - 1) / 2] = heap[index];
            heap[index] = temp;
            index = (index - 1) / 2;
        }
    }

    // Remove and return the root element of the heap
    public T remove() {
        if (lastIndex == 0)
            return null; // Heap is empty
        T ret = heap[0];
        heap[0] = heap[lastIndex - 1];
        heap[lastIndex - 1] = null;
        lastIndex--;
        bubbleDown();
        return ret;
    }

    // Bubble down the root element to maintain the heap property
    private void bubbleDown() {
        int index = 0;
        while (index * 2 + 1 < lastIndex) {
            int largeIndex = index * 2 + 1;
            if (index * 2 + 2 < lastIndex && heap[index * 2 + 1].compareTo(heap[index * 2 + 2]) < 0)
                largeIndex = index * 2 + 2;
            if (heap[index].compareTo(heap[largeIndex]) < 0) {
                T temp = heap[index];
                heap[index] = heap[largeIndex];
                heap[largeIndex] = temp;
            } else
                break;
            index = largeIndex;
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
    public void heapSort(T[] array) {
        if (array == null)
            return; // Array is null, nothing to sort
        GenMaxHeap<T> mHeap = new GenMaxHeap<T>(array.length);
        for (int i = 0; i < array.length; i++)
            mHeap.add(array[i]); // Add elements of the array to the heap
        for (int i = 0; i < array.length; i++)
            array[i] = mHeap.remove(); // Remove elements from the heap and assign them back to the array
    }
}
