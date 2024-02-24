/*
 * Written by Maximus Fernandez
 * Lab 04
 * Double Linked List
 * Due 02/23/2024 by 11:55PM
 */

public class DoubleDoubleLL {
	// Internal class to represent a node in the doubly linked list
	private class DoubleListNode {
		double data; // Data stored in the node
		DoubleListNode next; // Reference to the next node
		DoubleListNode prev; // Reference to the previous node

		// Constructor to initialize the node with data and references to next and
		// previous nodes
		public DoubleListNode(double data, DoubleListNode next, DoubleListNode prev) {
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
	}

	// Head reference pointing to the first node in the list
	private DoubleListNode head;

	// Current reference pointing to the current node of interest
	private DoubleListNode current;

	// Constructor to initialize an empty doubly linked list
	public DoubleDoubleLL() {
		head = current = null;
	}

	// Method to add a new node with given data to the end of the list
	public void add(double data) {
		// Create a new node with the data
		DoubleListNode newNode = new DoubleListNode(data, null, null);
		// If the list is empty, set the new node as both head and current
		if (head == null) {
			head = current = newNode;
			return;
		}
		// Traverse the list to find the last node
		DoubleListNode temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		// Add the new node to the end of the list
		temp.next = newNode;
		newNode.prev = temp;
	}

	// Method to add a new node with given data after the current node
	public void addAfterCurrent(double data) {
		// If the current node is null, do nothing
		if (current == null) {
			return;
		}
		// Create a new node with the data and appropriate references
		DoubleListNode newNode = new DoubleListNode(data, current.next, current);
		// Adjust references to insert the new node after the current node
		if (current.next != null) {
			current.next.prev = newNode;
		}
		current.next = newNode;
	}

	// Method to remove the node with given data from the list
	public void remove(double data) {
		// Start from the head of the list
		DoubleListNode temp = head;
		DoubleListNode prev = null;
		// Traverse the list to find the node with the given data
		while (temp != null && temp.data != data) {
			prev = temp;
			temp = temp.next;
		}
		// If the node is not found, do nothing
		if (temp == null) {
			return;
		}
		// Adjust references to remove the node from the list
		if (prev == null) {
			head = temp.next;
		} else {
			prev.next = temp.next;
		}
		if (temp.next != null) {
			temp.next.prev = prev;
		}
	}

	// Method to remove the current node from the list
	public void removeCurrent() {
		// If the current node is null, do nothing
		if (current == null) {
			return;
		}
		// Adjust references to remove the current node from the list
		if (current == head) {
			head = head.next;
			if (head != null) {
				head.prev = null;
			}
		} else {
			current.prev.next = current.next;
			if (current.next != null) {
				current.next.prev = current.prev;
			}
		}
		current = current.next;
	}

	// Method to print all the data in the linked list
	public void print() {
		DoubleListNode temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	// Method to check if the list contains a node with the given data
	public boolean contains(double data) {
		DoubleListNode temp = head;
		while (temp != null) {
			if (temp.data == data) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}

	// Method to get the data of the current node
	public double getCurrent() {
		// If the current node is null, move current to the end of the list
		if (current == null) {
			gotoEnd();
			// If the list is empty, return NaN
			if (current == null) {
				return Double.NaN;
			}
		}
		return current.data;
	}

	// Method to set the data of the current node
	public void setCurrent(double data) {
		// If the current node is not null, set its data to the given value
		if (current != null) {
			current.data = data;
		}
	}

	// Method to move current to the next node
	public void gotoNext() {
		if (current != null) {
			current = current.next;
		}
	}

	// Method to move current to the previous node
	public void gotoPrev() {
		if (current != null) {
			current = current.prev;
		}
	}

	// Method to move current to the head of the list
	public void reset() {
		current = head;
	}

	// Method to move current to the end of the list
	public void gotoEnd() {
		current = head;
		while (current != null && current.next != null) {
			current = current.next;
		}
	}

	// Method to check if there are more nodes after the current node
	public boolean hasMore() {
		return current != null;
	}

}
