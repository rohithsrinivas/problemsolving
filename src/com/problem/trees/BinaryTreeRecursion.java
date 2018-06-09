package com.problem.trees;

public class BinaryTreeRecursion {

	Node root;

	class Node {
		int data;
		Node leftChild;
		Node rightChild;

		public Node(int data) {
			this.data = data;
			this.leftChild = null;
			this.rightChild = null;
		}
	}

	/*
	 * for deletion also, we need to search for the node, so the algorithm is the
	 * same till searching, this continues until we find a match, now the node which
	 * matches the given value needs to be deleted
	 */

	private Node deleteElement(Node current, int value) {
		if (current == null)
			return null;
		if (value == current.data) {
			/*
			 * we have found the node here..now we need to delete it if the node has no
			 * children, we need to replace this node as null for its parent node if the
			 * node has one child, we need to point the parent of this node to the only
			 * child of this node if the node has two children, this would require the
			 * reorganization of the tree
			 */

			// the node has no children, i.e it is a leaf node
			if (current.leftChild == null && current.rightChild == null)
				return null;

			// the node has one child (left or right)
			/* when left is null, the parent should point to right */
			if (current.leftChild == null)
				return current.rightChild;
			/* when right is null, the parent should point to the left */
			if (current.rightChild == null)
				return current.leftChild;
			
			int smallestValue = findSmallestValue();
			current.data = smallestValue;
			current.rightChild = deleteElement(current.rightChild, smallestValue);
			return current;

		}
		if (value < current.data) {
			current.leftChild = deleteElement(current.leftChild, value);
			return current;
		} else {
			current.rightChild = deleteElement(current.rightChild, value);
			return current;
		}
	}

	private int findSmallestValue() {
		return smallestValue(root);
	}

	private int findLargestValue() {
		return largestValue(root);
	}

	private int smallestValue(Node root) {
		return root.leftChild != null ? smallestValue(root.leftChild) : root.data;
	}

	private int largestValue(Node root) {
		return root.rightChild != null ? largestValue(root.rightChild) : root.data;
	}

	private void removeElement(int value) {
		deleteElement(root, 20);
	}

	private void insertNewNode(int value) {
		root = addRecursively(root, value);
	}

	/*
	 * we start from root, and check if the new nodes data is less than the current
	 * node, if yes, then we move the pointer to the left child and continue the
	 * same process, if it is greater than the current node, then we move to the
	 * right child and continue the same process... initially for the first element
	 * root will be null , so if current is null, then we directly return the value
	 * which was inserted as it is the first node and we need no checking
	 */
	private Node addRecursively(Node current, int value) {
		if (current == null)
			return new Node(value);
		if (value < current.data)
			current.leftChild = addRecursively(current.leftChild, value);
		else if (value > current.data)
			current.rightChild = addRecursively(current.rightChild, value);
		else
			return current;

		return current;

	}

	/*
	 * first check if it is empty.. then check if its present in the root.. then if
	 * the given value is greater than the current value, then perform the search on
	 * the right subtree starting with the right child of the current node, if it is
	 * lesser, then perform the search on the left subtree starting with the left
	 * child..
	 */
	private boolean searchForElement(Node current, int value) {
		if (current == null)
			return false;
		if (value == current.data)
			return true;
		return value > current.data ? searchForElement(current.rightChild, value)
				: searchForElement(current.leftChild, value);
	}

	private boolean performSearch(int value) {
		return searchForElement(root, value);
	}

	/*
	 * the tree traversal using "in-order" technique will return a sorted collection
	 * of elements.. this is mostly used with Depth First Search
	 */
	private void traverseTreeInorder(Node node) {
		if (node != null) {
			traverseTreeInorder(node.leftChild);
			System.out.println(node.data);
			traverseTreeInorder(node.rightChild);
		}
	}

	private void traverTreePreOrder(Node node) {
		if (node != null) {
			System.out.println(node.data);
			traverTreePreOrder(node.leftChild);
			traverTreePreOrder(node.rightChild);
		}
	}

	private void traverseTreePostOrder(Node node) {
		if (node != null) {
			traverseTreePostOrder(node.leftChild);
			traverseTreePostOrder(node.rightChild);
			System.out.println(node.data);
		}
	}

	private void printTree() {
		System.out.println("printing tree...____________ in-order");
		traverseTreeInorder(root);
		System.out.println("printing tree...____________ pre-order");
		traverTreePreOrder(root);
		System.out.println("printing tree...____________ post-order");
		traverseTreePostOrder(root);
	}

	public static void main(String[] args) {
		BinaryTreeRecursion binaryTree = new BinaryTreeRecursion();
		binaryTree.insertNewNode(10);
		binaryTree.insertNewNode(20);
		binaryTree.insertNewNode(15);
		binaryTree.insertNewNode(12);
		binaryTree.printTree();
		if (binaryTree.performSearch(29))
			System.out.println("element found!");
		else
			System.out.println("element does not exist");

		System.out.println("smallest value in the tree is :" + binaryTree.findSmallestValue());
		System.out.println("largest value in the tree is :" + binaryTree.findLargestValue());
		binaryTree.removeElement(12);
		binaryTree.printTree();
	}

}
