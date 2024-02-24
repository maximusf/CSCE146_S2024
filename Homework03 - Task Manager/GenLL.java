/*
 * Written by Maximus Fernandez
 * Homework 02
 * Video Game Database!
 * Due 02/15/2024 by 11:55PM
 */

public class GenLL<T> {
	private class ListNode {
		T data;
		ListNode link;

		public ListNode(T aData, ListNode aLink) {
			data = aData;
			link = aLink;
		}
	}

	private ListNode head; // First element of the list
	private ListNode current; // Movable iterator / current node of interest
	private ListNode previous; // One node behind current / previous.link == current

	public GenLL() {
		head = current = previous = null;
	}

	public void add(T aData) // Adds to the END of the list
	{
		// Create a new node with the data
		ListNode newNode = new ListNode(aData, null);
		// Add the node to the list
		if (head == null) // empty list
		{
			head = current = newNode;
			return;
		}
		ListNode temp = head; // just a memory address pointed to the head
		while (temp.link != null) // start at the head reference
			temp = temp.link; // points temporary reference to its neighbor
		temp.link = newNode; // once temp.link is null, points to a newNode
	}

	// helps to debug
	public void print() // processes all the data
	{
		ListNode temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.link;
		}
	}

	public T getCurrent() {
		if (current == null)
			return null;
		return current.data;
	}

	public void setCurrent(T aData) {
		if (current == null)
			return;
		current.data = aData;
	}

	public void gotoNext() // moves current forward (hence "movable")
	{
		if (current == null)
			return;
		previous = current;
		current = current.link;
	}

	// if I want to go backwards, much more difficult to gotoPrevious
	public void reset() // sets current to the head
	{
		current = head;
		previous = null;
	}

	public boolean hasMore() {
		return current != null;
	}

	public void removeCurrent() {
		if (head == current) {
			head = head.link;
			current = head;
		} else {
			previous.link = current.link; // skips one past it
			current = current.link; // successfully removed a node
		}
	}

}