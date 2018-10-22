package com.problem.trees;

public class MirrorBinaryTree {

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

	private void addNode(int value) {
		root = addRecursively(root, value);
	}

	private Node addRecursively(Node root, int value) {
		if (root == null)
			return new Node(value);
		if (value < root.data) {
			root.leftChild = addRecursively(root.leftChild, value);
		} else if (value > root.data) {
			root.rightChild = addRecursively(root.rightChild, value);
		}
		return root;
	}

	private void removeNode(int data) {
		root = deleteNode(root, data);
	}

	private int findHighestValue(Node root) {
		return calculateHighestValue(root);
	}

	private int calculateHighestValue(Node root) {
		return root.rightChild != null ? calculateHighestValue(root.rightChild) : root.data;
	}

	private Node deleteNode(Node root, int data) {
		if (root == null)
			return null;
		if (data < root.data) {
			root.leftChild = deleteNode(root.leftChild, data);
			return root;
		} else if (data > root.data) {
			root.rightChild = deleteNode(root.rightChild, data);
			return root;
		}

		else {
			if (root.leftChild == null && root.rightChild == null) {
				root = null;
				return root;
			} else if (root.rightChild != null && root.leftChild != null) {
				int highestValueOnLeftSubTree = findHighestValue(root.leftChild);
				root.data = highestValueOnLeftSubTree;
				deleteNode(root.leftChild, highestValueOnLeftSubTree);
			} else {
				Node validChild = root.leftChild != null ? root.leftChild : root.rightChild;
				root = validChild;
			}
			return root;
		}

	}

	private void printTree() {
		printTreeInOrder(root);
	}

	private void printTreeInOrder(Node root) {
		if (root != null) {
			printTreeInOrder(root.leftChild);
			System.out.println(root.data);
			printTreeInOrder(root.rightChild);
		}
	}

	private void mirrorBinaryTree() {
		root = findTheMirror(root);
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

	private boolean searchForElement(Node root, int key) {
		if (root == null) {
			return false;
		}
		if (key == root.data) {
			return true;
		}
		return key < root.data ? searchForElement(root.leftChild, key) : searchForElement(root.rightChild, key);
	}

	public static void main(String[] args) {
		MirrorBinaryTree binaryTree = new MirrorBinaryTree();
		binaryTree.addNode(1);
		binaryTree.addNode(2);
		binaryTree.addNode(3);
		binaryTree.addNode(4);
		binaryTree.addNode(5);
		binaryTree.printTree();
		// binaryTree.removeNode(2);
		binaryTree.printTree();
		System.out.println("printing mirror image");
		//binaryTree.mirrorBinaryTree();
		binaryTree.printTree();
		System.out.println(binaryTree.searchForElement(3));
	}

	private boolean searchForElement(int key) {
		return searchForElement(root, key);
	}

}
