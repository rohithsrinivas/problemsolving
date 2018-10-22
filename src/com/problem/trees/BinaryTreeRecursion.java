package com.problem.trees;

import com.problem.trees.MirrorBinaryTree.Node;

public class BinaryTreeRecursion {

	Node root;
	
	ListNode head;

	class ListNode{
		int data;
		ListNode next;
		
		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
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

	
	private void insertInLastPlace(int data) {
		if(head == null) {
			insertInFirstPlace(data);
			return;
		}
		ListNode temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		ListNode newNode = new ListNode(data);
		temp.next = newNode;
		newNode.next = null;
	}
	
	private void insertInFirstPlace(int data) {
		ListNode newNode = new ListNode(data);
		newNode.next = head;
		head = newNode;
	}
	/*
	 * for deletion also, we need to search for the node, so the algorithm is the
	 * same till searching, this continues until we find a match, now the node which
	 * matches the given value needs to be deleted
	 */

	private Node deleteElement(Node root, int value) {
		if (root == null)
			return null;

		/* if the value is less than the root data, then search on the left sub tree */
		if (value < root.data) {
			root.leftChild = deleteElement(root.leftChild, value);
			return root;
		}
		/* if the value is greater than the root data, search on the right sub tree */
		else if (value > root.data) {
			root.rightChild = deleteElement(root.rightChild, value);
			return root;
		}

		/* now the key is found */
		else {
			/*
			 * we have found the node here..now we need to delete it if the node has no
			 * children, we need to replace this node as null for its parent node if the
			 * node has one child, we need to point the parent of this node to the only
			 * child of this node if the node has two children, this would require the
			 * reorganization of the tree
			 */

			// the node has no children, i.e it is a leaf node, simply return null, as we
			// can directly delete it
			if (root.leftChild == null && root.rightChild == null) {
				root = null;
				return root;
			}

			/*
			 * this is the case when the node has two children, now since it is binary
			 * search tree, we need to find the largest value in the left subtree to replace
			 * the node which need to be deleted, in other words, the in-order traversal
			 * returns sorted elements, we need to the find the in order predecessor of the
			 * current, which will be the highest value less than the current node, and
			 * replace it , and after replacement we need to delete the node which was used
			 * for replacing as well
			 */
			if (root.leftChild != null && root.rightChild != null) {
				/* find the largest value in the left subtree of the node to be deleted */
				int largestValue = findLargestValue(root.leftChild);
				/* copy the largest value to the node to be deleted */
				root.data = largestValue;
				/*
				 * now delete the node which was used for replacement, using the same function
				 * recursively, this will end up in case of leaf node with no children
				 */
				return deleteElement(root.leftChild, largestValue);
			}

			/*
			 * this is the case when the node to be deleted has only one child, in this case
			 * we simply need to replace the node's data with the child, i.e the left child
			 * or the right child
			 */
			else {
				Node validChild = root.leftChild != null ? root.leftChild : root.rightChild;
				root = validChild;
				return root;
			}

		}

	}

	private int findSmallestValue() {
		return smallestValue(root);
	}

	private int findLargestValue() {
		return largestValue(root);
	}

	private int findLargestValue(Node node) {
		return largestValue(node);
	}

	private int smallestValue(Node root) {
		return root.leftChild != null ? smallestValue(root.leftChild) : root.data;
	}

	private int largestValue(Node root) {
		return root.rightChild != null ? largestValue(root.rightChild) : root.data;
	}

	private void removeElement(int value) {
		root = deleteElement(root, value);
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
	private Node addRecursively(Node root, int value) {
		if (root == null)
			return new Node(value);
		if (value < root.data)
			root.leftChild = addRecursively(root.leftChild, value);
		else if (value > root.data)
			root.rightChild = addRecursively(root.rightChild, value);
		return root;

	}
	
	private void printList() {
		ListNode temp = head;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	/*
	 * this function will find the height of the tree, the height will the number of
	 * levels starting from the root to the farthest leaf node
	 */
	private int findHeightOfTheTree() {
		return calculateHeightOfTree(root);
	}

	/*
	 * this is a recursive function which will start from root and calculate the
	 * heights of left subtree and right subtree for each node and then terminate at
	 * the farthest leaf node since root will be null then
	 */
	private int calculateHeightOfTree(Node root) {
		if (root == null) {
			return 0;
		} else {
			/* calculate the heights of left subtree and right subtree */
			int leftSubTreeHeight = calculateHeightOfTree(root.leftChild);
			int rightSubTreeHeight = calculateHeightOfTree(root.rightChild);

			/*
			 * we increment the values before returning because we need to count the level
			 * containing only the root as well
			 */
			return leftSubTreeHeight >= rightSubTreeHeight ? (leftSubTreeHeight + 1) : (rightSubTreeHeight + 1);
		}
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
	
	private Node findTheMirror(Node root) {
		if (root == null)
			return null;
		Node leftSubTreeMirror = findTheMirror(root.leftChild);
		Node rightSubTreeMirror = findTheMirror(root.rightChild);

		root.leftChild = rightSubTreeMirror;
		root.rightChild = leftSubTreeMirror;

		return root;
	}
	
	private void mirrorBinaryTree() {
		root = findTheMirror(root);
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
		// System.out.println("printing tree...____________ pre-order");
		// traverTreePreOrder(root);
		// System.out.println("printing tree...____________ post-order");
		// traverseTreePostOrder(root);
	}
	
	private void convertToDLL(Node root) {
		if(root != null) {
			convertToDLL(root.leftChild);
			insertInFirstPlace(root.data);
			convertToDLL(root.rightChild);
		}
	}


	public static void main(String[] args) {
		BinaryTreeRecursion binaryTree = new BinaryTreeRecursion();
		binaryTree.insertNewNode(10);
		binaryTree.insertNewNode(20);
		binaryTree.insertNewNode(15);
		binaryTree.insertNewNode(12);
		binaryTree.printTree();
		if (binaryTree.performSearch(15))
			System.out.println("element found!");
		else
			System.out.println("element does not exist");

		System.out.println("smallest value in the tree is :" + binaryTree.findSmallestValue());
		System.out.println("largest value in the tree is :" + binaryTree.findLargestValue());
		// binaryTree.removeElement(12);
		binaryTree.printTree();
		System.out.println("the height of the binary tree is " + binaryTree.findHeightOfTheTree());
		//binaryTree.removeElement(15);
		System.out.println("printing after removal");
		binaryTree.printTree();
		System.out.println(binaryTree.root.data+"::");
		binaryTree.mirrorBinaryTree();
		binaryTree.printTree();
		System.out.println(binaryTree.root.data+"--");
		binaryTree.convertToDLL();
	}

	private void convertToDLL() {
		// TODO Auto-generated method stub
		convertToDLL(root);
		System.out.println("printing the list generated from binary tree");
		printList();
		
	}


}
