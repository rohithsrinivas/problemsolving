package com.problem.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MaxPathSumInBinaryTree {

	Node root;

	class Node {
		int data;
		Node leftChild;
		Node rightChild;
		int level;

		public Node(int data) {
			this.data = data;
			this.leftChild = null;
			this.rightChild = null;
			this.level = 0;
		}
	}

	private void addNode(int data) {
		root = addRecursively(root, data);
	}

	private void traverseTreeInOrder(Node currentNode) {
		if (currentNode != null) {
			traverseTreeInOrder(currentNode.leftChild);
			System.out.println(currentNode.data);
			traverseTreeInOrder(currentNode.rightChild);
		}
	}

	private void traverseTreePreOrder(Node currentNode) {
		if (currentNode != null) {
			System.out.println(currentNode.data);
			traverseTreePreOrder(currentNode.leftChild);
			traverseTreePreOrder(currentNode.rightChild);
		}
	}

	private void traverseTreePostOrder(Node currentNode) {
		if (currentNode != null) {
			traverseTreePostOrder(currentNode.leftChild);
			traverseTreePostOrder(currentNode.rightChild);
			System.out.println(currentNode.data);
		}
	}

	private Node addRecursively(Node currentNode, int value) {
		if (currentNode == null) {
			return new Node(value);
		}
		if (value < currentNode.data) {
			currentNode.leftChild = addRecursively(currentNode.leftChild, value);
		} else if (value > currentNode.data) {
			currentNode.rightChild = addRecursively(currentNode.rightChild, value);
		}
		return currentNode;
	}

	private int findHeight() {
		return calculateHeight(root);
	}

	private int calculateHeight(Node root) {
		if (root == null) {
			return 0;
		} else {
			int leftSubTreeHeight = calculateHeight(root.leftChild);
			int rightSubTreeHeight = calculateHeight(root.rightChild);

			return leftSubTreeHeight >= rightSubTreeHeight ? leftSubTreeHeight + 1 : rightSubTreeHeight + 1;
		}
	}

	private void printTreeInLevels(Node root) {
		if (root == null)
			return;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (queue.size() > 0) {
			int nodeCount = queue.size();
			if (nodeCount == 0) {
				break;
			}

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

	private int findMaxSum() {
		return calculateMaxPathSum(root, Integer.MIN_VALUE);
	}

	/*
	 * for a node to be a part of the max path, there are four possibilities, 1.
	 * Node only, without any children 2. Node along with max path through right
	 * child 3. Node along with max path through left child 4. Left child and Node
	 * and the Max path through right child, we need to find the max among these
	 * given paths
	 */
	private int calculateMaxPathSum(Node root, int result) {
		if (root == null)
			return 0;

		/* first calculate the max paths for the left and right sub trees */
		int leftPathSum = calculateMaxPathSum(root.leftChild, result);
		int rightPathSum = calculateMaxPathSum(root.rightChild, result);

		/*
		 * this will pick the max among left and right child nodes with root.data and
		 * then compare it with the nodes data itself and pick the max, this will pick
		 * the max for the single level scenario i.e with atmost one level
		 */
		int maxSingleLevel = max(max(leftPathSum, rightPathSum) + root.data, root.data);

		/*
		 * this case will be handled when node is the root of the maxsum path and there
		 * are no ancestors of root in the path i.e there are no nodes in the higher
		 * levels above this
		 */
		int maxTop = max(maxSingleLevel,leftPathSum+rightPathSum+root.data);
		
		result = max(maxTop,result);
		
		return result;

	}

	private int max(int first, int second) {
		return first > second ? first : second;
	}

	public static void main(String[] args) {
		MaxPathSumInBinaryTree binaryTree = new MaxPathSumInBinaryTree();
		binaryTree.addNode(10);
		binaryTree.addNode(20);
		binaryTree.addNode(2);
		binaryTree.addNode(39);
		binaryTree.addNode(122);
		System.out.println("in order traversal ____");
		binaryTree.traverseTreeInOrder(binaryTree.root);
		System.out.println("pre order traversal_____");
		binaryTree.traverseTreePreOrder(binaryTree.root);
		System.out.println("post order traversal _____");
		binaryTree.traverseTreePostOrder(binaryTree.root);
		System.out.println("the height of the tree is " + binaryTree.findHeight());
		binaryTree.printTreeInLevels(binaryTree.root);
		System.out.println("\n max sum is " + binaryTree.findMaxSum());
	}

}
