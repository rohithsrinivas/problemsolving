package com.problem.trees;

public class LeftViewOfBinaryTree {

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

	private void addNode(int data) {
		root = addRecursively(root, data);
	}

	private Node addRecursively(Node root, int data) {
		if (root == null) {
			root = new Node(data);
			return root;
		}
		if (data < root.data) {
			root.leftChild = addRecursively(root.leftChild, data);
		} else if (data > root.data) {
			root.rightChild = addRecursively(root.rightChild, data);
		}
		return root;
	}

	private void printRightView() {
		int tempLevel = 0;
		rightViewPrinter(root, 1, tempLevel);
	}

	/*
	 * this is the same as leftview printer, the only difference is that we need to
	 * the print the last node of each level rather than the first node, so instead
	 * of traversing from left to right in a conventional way, we traverse from
	 * right to left, in order to do that, we first recurse with the right child of
	 * the root instead of the left child
	 */
	private void rightViewPrinter(Node root, int level, int tempLevel) {
		if (root == null)
			return;
		if (tempLevel < level) {
			System.out.print(root.data + " ");
			tempLevel = level;
		}

		rightViewPrinter(root.rightChild, ++level, tempLevel);
		rightViewPrinter(root.leftChild, ++level, tempLevel);
	}

	private void printLeftView() {
		int tempLevel = 0;
		leftViewPrinter(root, 1, tempLevel);
	}

	/*
	 * the idea is to traverse each level and print only the first node of each
	 * level and skip the remaining, so we maintain a tempLevel to decide we need to
	 * print or not, once the printing is done, we increment the level and pass, so
	 * that the condition won't be true for the next node in the same level
	 */
	private void leftViewPrinter(Node root, int level, int tempLevel) {
		if (root == null) {
			return;
		}

		/* this will only be true for the first node in each level */
		if (tempLevel < level) {
			System.out.println(root.data);
			tempLevel = level;
		}

		/*
		 * we increment level value because we dont want to print the other nodes in the
		 * same level
		 */
		leftViewPrinter(root.leftChild, ++level, tempLevel);
		leftViewPrinter(root.rightChild, ++level, tempLevel);
	}

	private void printTreeInOrder(Node root) {
		if (root != null) {
			printTreeInOrder(root.leftChild);
			System.out.println(root.data);
			printTreeInOrder(root.rightChild);
		}
	}

	private void prettyPrintTree(Node root,int indent) {
		if(root != null) {
			if(indent > 0) {
				for(int i =0 ;i<indent;i++) {
					System.out.println(" ");
				}
			}
			System.out.println(root.data);
			if(root.leftChild != null) {
				prettyPrintTree(root.leftChild, indent + 4);
			}
			if(root.rightChild != null) {
				prettyPrintTree(root.rightChild, indent + 4);
			}
			
		}
	}

	public static void main(String[] args) {
		LeftViewOfBinaryTree binaryTree = new LeftViewOfBinaryTree();
		binaryTree.addNode(80);
		binaryTree.addNode(30);
		binaryTree.addNode(20);
		binaryTree.addNode(40);
		binaryTree.addNode(70);
		binaryTree.addNode(50);
		binaryTree.addNode(60);
		binaryTree.addNode(80);
		//System.out.println("pretty printed output");
		//binaryTree.prettyPrintTree(binaryTree.root, 0);
		// binaryTree.addNode(8);
		binaryTree.printTreeInOrder(binaryTree.root);
		System.out.println("__________");
		binaryTree.printLeftView();
		System.out.println("right view ");
		binaryTree.printRightView();
		System.out.println(" root is "+binaryTree.root.data);
	}

}
