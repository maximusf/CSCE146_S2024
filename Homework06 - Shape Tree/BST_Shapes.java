/*
 * Written by Maximus Fernandez
 * Shape Tree
 * Due 03/29/2024 by 11:55pm
 */

//This is supposed to be a balanced binary search tree (AVL tree)

public class BST_Shapes <T extends Comparable<T>>{
	private class Node
	{
		T data; 
		Node leftChild;
		Node rightChild;
		int height;
		public Node(T aData)
		{
			data = aData;
			leftChild = rightChild = null;
			height = 0;
		}
	}
	private Node root; //First element / save as the head
	public BST_Shapes()
	{
		root = null;
	}
	
	// Method to update the height of a node based on its children's heights
	private void fixHeight(Node aN)
	{
		aN.height = 1 + Math.max(getHeight(aN.leftChild), getHeight(aN.rightChild));
	}
	
	// Method to get the height of a node
	private int getHeight(Node aNode)
	{
		if(aNode == null)
			return -1;
		else
			return aNode.height;
	}
	
	// Method to calculate the balance factor of a node
	private int getBalance(Node aN)
	{
		if(aN == null)
			return 0;
		return getHeight(aN.rightChild) - getHeight(aN.leftChild);
	}
	
	// Right rotation operation
	private Node rotateRight(Node y)
	{
		Node x = y.leftChild;
		Node z = x.rightChild;
		x.rightChild = y;
		y.leftChild = z;
		fixHeight(y);
		fixHeight(x);
		return x;
	}
	
	// Left rotation operation
	private Node rotateLeft(Node y)
	{
		Node x = y.rightChild;
		Node z = x.leftChild;
		x.leftChild = y;
		y.rightChild = z;
		fixHeight(y);
		fixHeight(x);
		return x;
	}
	
	// Method to rebalance the tree if it becomes unbalanced
	private Node rebalance(Node aNode)
	{
		fixHeight(aNode);
		int balance = getBalance(aNode);
		if(balance > 1)
		{
			if(getHeight(aNode.rightChild.rightChild) > getHeight(aNode.rightChild.leftChild))
			{
				// Right-Right rotation
				aNode = rotateLeft(aNode);
			}
			else
			{
				// Right-Left rotation
				aNode.rightChild = rotateRight(aNode.rightChild);
				aNode = rotateLeft(aNode);
			}
		}
		else if (balance < -1)
		{
			if(getHeight(aNode.leftChild.leftChild) > getHeight(aNode.leftChild.rightChild))
			{
				// Left-Left rotation
				aNode = rotateRight(aNode);
			}
			else
			{
				// Left-Right rotation
				aNode.leftChild = rotateLeft(aNode.leftChild);
				aNode = rotateRight(aNode);
			}
		}
		return aNode;
	}
	
	// Method to add a new node with given data to the tree
	public void add(T aData)
	{
		if (root == null)
			root = new Node(aData);
		else
			add(root,aData);
	}
	
	// Recursive method to add a new node with given data to the tree
	private Node add(Node aNode, T aData)
	{
		if(aNode == null) //Leaf
			aNode = new Node(aData);
		else if(aData.compareTo(aNode.data) < 0) //GO LEFT IF VALUE IS LESS
			aNode.leftChild = add(aNode.leftChild, aData);
		else if (aData.compareTo(aNode.data) > 0) //GO RIGHT
			aNode.rightChild = add(aNode.rightChild, aData);
		
		return rebalance(aNode);
	}
	
	// Method to search for a given data in the tree
	public boolean search(T aData)
	{
		return search(root,aData);
	}
	
	// Recursive method to search for a given data in the tree
	private boolean search(Node aNode, T aData)
	{
		if(aNode == null)
			return false;
		if(aNode.data.equals(aData)) // Check if the current node's data is equal to the target data
			return true;
		else if (aData.compareTo(aNode.data) < 0) //GO LEFT
			return search(aNode.leftChild, aData);
		else //GO RIGHT
			return search(aNode.rightChild, aData);
	}
	
	// Method to print the tree in preorder traversal
	public void printPreorder()
	{
		printPreorder(root);
	}
	
	// Recursive method to print the tree in preorder traversal
	private void printPreorder(Node aNode) 
	{
		if(aNode == null)
			return;
		System.out.println(aNode.data); //print out the value
		printPreorder(aNode.leftChild); //recursive left in
		printPreorder(aNode.rightChild); //recursive right out
	}
	
	// Method to print the tree in inorder traversal
	public void printInorder()
	{
		printInorder(root);
	}
	
	// Recursive method to print the tree in inorder traversal
	private void printInorder(Node aNode) 
	{
		if(aNode == null)
			return;
		printInorder(aNode.leftChild); //recursive left
		System.out.println(aNode.data); //process
		printInorder(aNode.rightChild); //recursive right
	}
	
	// Method to remove a node with given data from the tree
	public void remove (T aData)
	{
		root = remove(root,aData);
	}
	
	// Recursive method to remove a node with given data from the tree
	private Node remove(Node aNode, T aData)
	{
		//Search
		if (aNode == null) //We didn't find it
			return null;
		else if (aData.compareTo(aNode.data) < 0) //GO LEFT
			aNode.leftChild = remove (aNode.leftChild,aData);
		else if (aData.compareTo(aNode.data) > 0) //GO RIGHT
			aNode.rightChild = remove (aNode.rightChild,aData);
		else //WE FOUND IT!
		{
			if(aNode.rightChild == null)
				return aNode.leftChild;
			else if (aNode.leftChild == null)
				return aNode.rightChild;
			//Two children
			Node temp = findMinInTree(aNode.rightChild);
			aNode.data = temp.data;
			aNode.rightChild = remove(aNode.rightChild,temp.data); //Remove duplicate
		}
		return rebalance(aNode);	
	}
	
	// Method to find the minimum node in the subtree rooted at a given node
	private Node findMinInTree(Node aNode)
	{
		if (aNode == null)
			return null;
		else if (aNode.leftChild == null)
			return aNode;
		else
			return findMinInTree(aNode.leftChild);
	}
}

