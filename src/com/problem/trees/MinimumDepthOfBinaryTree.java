package com.problem.trees;

import java.awt.geom.CubicCurve2D;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class MinimumDepthOfBinaryTree {

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

	private Node addRecursively(Node currentNode, int value) {
		if (currentNode == null) {
			return new Node(value);
		}

		if (value < currentNode.data) {
			currentNode.leftChild = addRecursively(currentNode.leftChild, value);
		}

		else if (value > currentNode.data) {
			currentNode.rightChild = addRecursively(currentNode.rightChild, value);
		}

		return currentNode;
	}

	private int findMimimumDepth() {
		return minimumDepthIteration(root);
	}

	/*
	 * this algorithm may end up doing extra recursions even when there may be a
	 * leaf node at the top, after the root
	 */
	private int minimumDepth(Node root) {
		if (root == null) {
			return 0;
		}
		if (root.leftChild == null && root.rightChild == null) {
			return 1;
		}
		if (root.leftChild == null) {
			return minimumDepth(root.rightChild) + 1;
		}
		if (root.rightChild == null) {
			return minimumDepth(root.leftChild) + 1;
		}

		int leftDepth = minimumDepth(root.leftChild);
		int rightDepth = minimumDepth(root.rightChild);
		return leftDepth < rightDepth ? (++leftDepth) : (++rightDepth);
	}

	private int minimumDepthIteration(Node root) {
		if (root == null)
			return 0;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		int depth = 1;
		while (queue.size() > 0) {
			Node currentNode = queue.poll();
			if (currentNode.leftChild == null && currentNode.rightChild == null)
				return depth;
			if (currentNode.leftChild != null) {
				depth++;
				queue.add(currentNode.leftChild);
			}
			if (currentNode.rightChild != null) {
				depth++;
				queue.add(currentNode.rightChild);
			}
		}
		return depth;
	}

	private void printLeftViewOfTree() {
		leftViewPrinter(root, 1);
	}

	private static int maxLevel = 0;

	private void leftViewPrinter(Node root, int level) {
		if (root == null)
			return;
		if (maxLevel < level) {
			System.out.println(root.data);
			maxLevel = level;
		}

		leftViewPrinter(root.leftChild, ++level);
		leftViewPrinter(root.rightChild, ++level);

	}

	private static int maxLevel2 = 0;

	private void rightViewPrinter(Node root, int level) {
		if (root == null)
			return;
		if (maxLevel2 < level) {
			System.out.println(root.data);
			maxLevel2 = level;
		}
		rightViewPrinter(root.rightChild, level + 1);
		rightViewPrinter(root.leftChild, level + 1);
	}

	private int maximumDepth(Node root) {
		if (root == null)
			return 0;
		int leftSubTreeHeight = maximumDepth(root.leftChild);
		int rightSubTreeHeight = maximumDepth(root.rightChild);
		return leftSubTreeHeight > rightSubTreeHeight ? leftSubTreeHeight + 1 : rightSubTreeHeight + 1;
	}

	private void printTreeInLevels(Node root) {
		if (root == null)
			return;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (queue.size() > 0) {
			int nodeCount = queue.size();
			if (nodeCount == 0)
				break;

			while (nodeCount > 0) {
				Node currentNode = queue.poll();
				System.out.print(currentNode.data + " ");
				if (currentNode.leftChild != null)
					queue.add(currentNode.leftChild);
				if (currentNode.rightChild != null)
					queue.add(currentNode.rightChild);
				nodeCount--;
			}

			System.out.println("\n");
		}
	}

	public static void main(String[] args) {
		MinimumDepthOfBinaryTree binaryTree = new MinimumDepthOfBinaryTree();
		binaryTree.addNode(10);
		binaryTree.addNode(20);
		binaryTree.addNode(40);
		binaryTree.addNode(15);
		binaryTree.addNode(100);
		binaryTree.addNode(299);
		binaryTree.addNode(14);
		binaryTree.addNode(678);
		System.out.println("printing tree in levels");
		binaryTree.printTreeInLevels(binaryTree.root);
		System.out.println("minimum depth is " + binaryTree.findMimimumDepth());
		;
		System.out.println("maximum depth is " + binaryTree.maximumDepth(binaryTree.root));
		System.out.println("left view of binary tree is ");
		binaryTree.printLeftViewOfTree();
		System.out.println("printing tree in levels");
		binaryTree.printTreeInLevels(binaryTree.root);
		System.out.println("right view of binary tree is ");
		binaryTree.rightViewPrinter(binaryTree.root, 1);
	}

}
