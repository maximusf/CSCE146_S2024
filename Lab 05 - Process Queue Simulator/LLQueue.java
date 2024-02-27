/*
 * Written by Maximus Fernandez
 * Process Queue Simulator
 * Due 03/01/2024 by 11:55pm
 */

public class LLQueue<T> {
	// Node class to represent each element in the queue
	private class Node {
		T data;
		Node next;

		Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node head; // Pointer to the front of the queue
	private Node tail; // Pointer to the end of the queue

	// Constructor to initialize an empty queue
	public LLQueue() {
		head = null;
		tail = null;
	}

	// Method to add an element to the end of the queue
	public void Enqueue(T data) {
		Node newNode = new Node(data);
		if (tail == null) {
			// If the queue is empty, set both head and tail to the new node
			head = tail = newNode;
		} else {
			// Otherwise, add the new node after the current tail and update the tail
			tail.next = newNode;
			tail = newNode;
		}
	}

	// Method to remove and return the first element's data of the queue
	public T Dequeue() {
		if (head == null) {
			// If the queue is empty, return null
			return null;
		} else {
			// Remove the node at the head and update the head pointer
			T data = head.data;
			head = head.next;
			if (head == null) {
				// If the queue becomes empty, update the tail pointer as well
				tail = null;
			}
			return data;
		}
	}

	// Method to peek at the first element's data without removing it
	public T Peek() {
		return head != null ? head.data : null;
	}

	// Method to print out the entire queue
	public void Print() {
	    if (head == null) {
	        // If the queue is empty, just print an empty line
	        return;
	    }

	    // Print the elements in the queue
	    Node current = head;
	    while (current != null) {
	        System.out.println(current.data);
	        current = current.next;
	    }
	}
}
