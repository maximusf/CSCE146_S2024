/*
 * Written by Maximus Fernandez
 * Process Queue Simulator
 * Due 03/01/2024 by 11:55pm
 */

public interface QueueI<T> {
	// Method to enqueue an element
	public void Enqueue(T element);

	// Method to dequeue an element
	public T Dequeue();

	// Method to peek at the front element
	public T Peek();

	// Method to print the queue
	public void Print();
}
