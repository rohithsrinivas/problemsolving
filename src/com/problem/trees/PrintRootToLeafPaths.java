package com.problem.trees;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

public class PrintRootToLeafPaths {

	Node root;

	class Node {
		int data;
		Node leftChild;
		Node rightChild;
		int hd;

		public Node(int data, int hd) {
			this.data = data;
			this.leftChild = null;
			this.rightChild = null;
			this.hd = 0;
		}
	}

	private void addNode(int data) {
		root = addNode(root, data);
	}

	private Node addNode(Node root, int data) {
		if (root == null)
			return new Node(data, 0);
		if (data < root.data)
			root.leftChild = addNode(root.leftChild, data);
		if (data > root.data)
			root.rightChild = addNode(root.rightChild, data);
		return root;
	}

	private void deleteNode(int data) {
		root = deleteNode(root, data);
	}

	private int getHighestValue(Node root) {
		return root.rightChild != null ? getHighestValue(root.rightChild) : root.data;
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
		} else {
			if (root.leftChild == null && root.rightChild == null) {
				root = null;
				return root;
			}
			if (root.leftChild != null && root.rightChild != null) {
				int highestValue = getHighestValue(root.leftChild);
				root.data = highestValue;
				root.leftChild = deleteNode(root.leftChild, highestValue);
				return root;
			} else {
				Node validChild = root.leftChild != null ? root.leftChild : root.rightChild;
				root = validChild;
				return root;
			}
		}

	}

	private static int maxLevel = 0;

	private void printLeftViewOfTree(Node root, int level) {
		if (root == null) {
			return;
		}
		if (maxLevel < level) {
			System.out.println(root.data + " ");
			maxLevel = level;
		}

		printLeftViewOfTree(root.leftChild, ++level);
		printLeftViewOfTree(root.rightChild, ++level);

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

				if (currentNode.leftChild != null) {
					queue.add(currentNode.leftChild);
				}

				if (currentNode.rightChild != null) {
					queue.add(currentNode.rightChild);
				}

				nodeCount--;
			}

			System.out.println();
		}
	}

	private void printTopView(Node root) {
		if (root == null)
			return;
		Queue<Node> queue = new LinkedList<>();
		root.hd = 0;
		queue.add(root);
		Map<Integer, Node> distances = new TreeMap<>();
		while (queue.size() > 0) {
			Node currentNode = queue.poll();
			if (!distances.containsKey(currentNode.hd))
				distances.put(currentNode.hd, currentNode);

			if (currentNode.leftChild != null) {
				currentNode.leftChild.hd = currentNode.hd - 1;
				queue.add(currentNode.leftChild);
			}

			if (currentNode.rightChild != null) {
				currentNode.rightChild.hd = currentNode.hd + 1;
				queue.add(currentNode.rightChild);
			}
		}

		Iterator<Map.Entry<Integer, Node>> mapIterator = distances.entrySet().iterator();
		while (mapIterator.hasNext()) {
			Entry<Integer, Node> entry = mapIterator.next();
			System.out.println(entry.getValue().data);
		}

	}

	private void printAllRootToLeafPaths(Node root) {
		int[] paths = new int[10];
		printAllRootToLeafPaths(root, paths, 0);
	}

	private void printAllRootToLeafPathsRequiredSum(Node root, int requiredSum) {
		int[] paths = new int[10];
		printRootToLeafPathsForRequiredSum(root, paths, 0, requiredSum);
	}

	private void printArray(int[] paths, int length) {
		for (int i = 0; i < length; i++) {
			System.out.print(paths[i] + " --> ");
		}
		System.out.print("NULL");
		System.out.println();
	}

	private void checkSumAndPrint(int[] paths, int length, int requiredSum) {
		int sum = 0;
		for (int i = 0; i < length; i++) {
			sum += paths[i];
		}
		if (requiredSum == sum) {
			for (int i = 0; i < length; i++) {
				System.out.print(paths[i] + " --> ");
			}
			System.out.print("NULL");
			System.out.println();
		}
	}

	private void printRootToLeafPathsForRequiredSum(Node root, int[] nodesInPath, int pathIndex, int requiredSum) {
		if (root == null)
			return;
		nodesInPath[pathIndex] = root.data;
		pathIndex++;

		if (root.leftChild == null && root.rightChild == null) {
			checkSumAndPrint(nodesInPath, pathIndex, requiredSum);
		} else {
			printRootToLeafPathsForRequiredSum(root.leftChild, nodesInPath, pathIndex, requiredSum);
			printRootToLeafPathsForRequiredSum(root.rightChild, nodesInPath, pathIndex, requiredSum);
		}

	}

	private void printAllRootToLeafPaths(Node root, int[] nodesInPath, int pathIndex) {
		if (root == null)
			return;
		nodesInPath[pathIndex] = root.data;
		pathIndex++;

		if (root.leftChild == null && root.rightChild == null) {
			printArray(nodesInPath, pathIndex);
		}

		else {
			printAllRootToLeafPaths(root.leftChild, nodesInPath, pathIndex);
			printAllRootToLeafPaths(root.rightChild, nodesInPath, pathIndex);
		}
	}

	public static void main(String[] args) {
		PrintRootToLeafPaths binaryTree = new PrintRootToLeafPaths();
		binaryTree.addNode(15);
		binaryTree.addNode(13);
		binaryTree.addNode(89);
		binaryTree.addNode(65);
		binaryTree.addNode(78);
		binaryTree.addNode(24);
		binaryTree.addNode(9);
		binaryTree.printTreeInLevels(binaryTree.root);
		System.out.println("top view");
		binaryTree.printTopView(binaryTree.root);
		System.out.println("left view");
		binaryTree.printLeftViewOfTree(binaryTree.root, 1);
		System.out.println("printing root to leaf paths");
		binaryTree.printAllRootToLeafPaths(binaryTree.root);
		System.out.println("printing root to leaf paths for required sum");
		binaryTree.printAllRootToLeafPathsRequiredSum(binaryTree.root, 37);
	}

}
