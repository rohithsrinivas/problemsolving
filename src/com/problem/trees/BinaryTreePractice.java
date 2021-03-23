package com.problem.trees;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

public class BinaryTreePractice {

	Node root;

	class Node {
		int data;
		Node leftChild;
		Node rightChild;
		int hd;

		public Node(int data) {
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
			return new Node(data);
		if (data < root.data)
			root.leftChild = addNode(root.leftChild, data);
		else if (data > root.data)
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
		if (data < root.data)
			root.leftChild = deleteNode(root.leftChild, data);
		else if (data > root.data)
			root.rightChild = deleteNode(root.rightChild, data);
		else {
			if (root.leftChild == null && root.rightChild == null) {
				root = null;
			} else if (root.leftChild != null && root.rightChild != null) {
				int highestValue = getHighestValue(root.leftChild);
				root.data = highestValue;
				root.leftChild = deleteNode(root.leftChild, highestValue);
			} else {
				Node validChild = root.leftChild != null ? root.leftChild : root.rightChild;
				root = validChild;
				root.leftChild = deleteNode(root.leftChild, root.data);
			}
		}
		return root;
	}

	private boolean search(int data) {
		return search(root, data);
	}

	private boolean search(Node root, int data) {
		if (root == null)
			return false;
		if (data < root.data)
			return search(root.leftChild, data);
		else if (data > root.data)
			return search(root.rightChild, data);
		else
			return true;
	}

	private int findHeightOfTree(Node root) {
		if (root == null)
			return 0;
		int leftSubtreeHeight = findHeightOfTree(root.leftChild);
		int rightSubTreeHeight = findHeightOfTree(root.rightChild);
		return leftSubtreeHeight >= rightSubTreeHeight ? leftSubtreeHeight + 1 : rightSubTreeHeight + 1;
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
			System.out.println();
		}
	}

	private void inOrderTraversal(Node root) {
		if (root != null) {
			inOrderTraversal(root.leftChild);
			System.out.print(root.data + " ");
			inOrderTraversal(root.rightChild);
		}
	}

	private void preOrderTraversal(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preOrderTraversal(root.leftChild);
			preOrderTraversal(root.rightChild);
		}
	}

	private void postOrderTraversal(Node root) {
		if (root != null) {
			postOrderTraversal(root.leftChild);
			postOrderTraversal(root.rightChild);
			System.out.print(root.data + " ");
		}
	}

	private int getMinimumDepthOfBinaryTree(Node root) {
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
				queue.add(currentNode.leftChild);
				depth++;
			}
			if (currentNode.rightChild != null) {
				queue.add(currentNode.rightChild);
				depth++;
			}

		}
		return depth;
	}

	private void printBottomViewOfBinaryTree(Node root) {
		System.out.println("printing bottom view of binary tree");
		Queue<Node> queue = new LinkedList<>();
		root.hd = 0;
		queue.add(root);
		Map<Integer, Node> horizontalDistances = new HashMap<>();
		while (queue.size() > 0) {
			Node currentNode = queue.poll();
			horizontalDistances.put(currentNode.hd, currentNode);
			if (currentNode.leftChild != null) {
				currentNode.leftChild.hd = currentNode.hd - 1;
				queue.add(currentNode.leftChild);
			}
			if (currentNode.rightChild != null) {
				currentNode.rightChild.hd = currentNode.hd + 1;
				queue.add(currentNode.rightChild);
			}
		}

		Iterator<Map.Entry<Integer, Node>> mapIterator = horizontalDistances.entrySet().iterator();
		while (mapIterator.hasNext()) {
			Entry<Integer, Node> entry = mapIterator.next();
			System.out.print(entry.getValue().data + " ");
		}
	}

	private void printTopViewOfBinaryTree(Node root) {
		System.out.println("printing top view of binary tree");
		Queue<Node> queue = new LinkedList<>();
		Map<Integer, Node> distances = new HashMap<>();
		queue.add(root);
		while (queue.size() > 0) {
			Node currentNode = queue.poll();
			if (!distances.containsKey(currentNode.hd)) {
				distances.put(currentNode.hd, currentNode);
			}
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
			System.out.print(entry.getValue().data + " ");
		}

	}

	private Node mirrorBinaryTree(Node root) {
		if (root == null)
			return null;
		Node leftSubTreeMirror = mirrorBinaryTree(root.leftChild);
		Node rightSubTreeMirror = mirrorBinaryTree(root.rightChild);

		root.leftChild = rightSubTreeMirror;
		root.rightChild = leftSubTreeMirror;

		return root;
	}

	private int countNumberOfLeaves(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		int leafCount = 0;
		while (queue.size() > 0) {
			Node currentNode = queue.poll();
			if (currentNode.leftChild == null && currentNode.rightChild == null)
				leafCount++;
			if (currentNode.leftChild != null)
				queue.add(currentNode.leftChild);
			if (currentNode.rightChild != null)
				queue.add(currentNode.rightChild);
		}
		System.out.println("the number of leaves in the binary tree is " + leafCount);
		return leafCount;
	}

	private static int maxLevel = 0;

	private void printLeftViewOfTree(Node root, int tempLevel) {
		if (root == null)
			return;
		if (maxLevel < tempLevel) {
			System.out.print(root.data + " ");
			maxLevel = tempLevel;
		}

		printLeftViewOfTree(root.leftChild, ++tempLevel);
		printLeftViewOfTree(root.rightChild, ++tempLevel);

	}

	private static int maxLevel2 = 0;

	private void printRightViewOfBinaryTree(Node root, int tempLevel) {
		if (root == null)
			return;
		if (maxLevel2 < tempLevel) {
			System.out.print(root.data + " ");
			maxLevel2 = tempLevel;
		}

		printRightViewOfBinaryTree(root.rightChild, ++tempLevel);
		printRightViewOfBinaryTree(root.leftChild, ++tempLevel);
	}

	public static void main(String[] args) {
		BinaryTreePractice binaryTree = new BinaryTreePractice();
		binaryTree.addNode(10);
		binaryTree.addNode(3);
		binaryTree.addNode(4);
		binaryTree.addNode(20);
		binaryTree.addNode(12);
		binaryTree.addNode(76);
		binaryTree.addNode(36);
		binaryTree.addNode(24);
		binaryTree.deleteNode(3);
		System.out.println("###### search results are "+binaryTree.search(125));
		System.out.print(" In order traversal of tree ");
		binaryTree.inOrderTraversal(binaryTree.root);
		System.out.println();
		System.out.print(" pre order traversal of tree ");
		binaryTree.preOrderTraversal(binaryTree.root);
		System.out.println();
		System.out.print(" post order traversal of binary tree ");
		binaryTree.postOrderTraversal(binaryTree.root);
		System.out.println();
		System.out.println("the height of the tree is " + binaryTree.findHeightOfTree(binaryTree.root));
		System.out.println("printing tree in levels");
		binaryTree.printTreeInLevels(binaryTree.root);
		System.out.println(
				"The minimum depth of binary tree is " + binaryTree.getMinimumDepthOfBinaryTree(binaryTree.root));
//		binaryTree.mirrorBinaryTree(binaryTree.root);
//		System.out.println("the mirror of the binary tree is ");
//		binaryTree.printTreeInLevels(binaryTree.root);
		System.out.println("the left view of binary tree is ");
		binaryTree.printLeftViewOfTree(binaryTree.root, 1);
		System.out.println("\n the right view of binary tree is ");
		binaryTree.printRightViewOfBinaryTree(binaryTree.root, 1);
		binaryTree.printBottomViewOfBinaryTree(binaryTree.root);
		binaryTree.printTopViewOfBinaryTree(binaryTree.root);
		binaryTree.countNumberOfLeaves(binaryTree.root);
	}

}
