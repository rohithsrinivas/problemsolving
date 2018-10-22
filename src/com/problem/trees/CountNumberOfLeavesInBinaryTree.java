package com.problem.trees;

import java.util.LinkedList;
import java.util.Queue;

public class CountNumberOfLeavesInBinaryTree {

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

	private void addNodeToTree(int data) {
		root = addRecursively(root, data);
	}

	private Node addRecursively(Node root, int data) {
		if (root == null)
			return new Node(data);
		if (data < root.data) {
			root.leftChild = addRecursively(root.leftChild, data);
		} else if (data > root.data) {
			root.rightChild = addRecursively(root.rightChild, data);
		}
		return root;
	}

	private void deleteNode(int data) {
		root = deleteNode(root, data);
	}

	private int findHighestValue(Node root) {
		return root.rightChild != null ? findHighestValue(root.rightChild) : root.data;
	}

	private Node deleteNode(Node root, int data) {
		if (root == null)
			return null;

		if (data < root.data) {
			root.leftChild = deleteNode(root.leftChild, data);
			return root;
		}
		if (data > root.data) {
			root.rightChild = deleteNode(root.rightChild, data);
			return root;
		} else {
			if (root.leftChild != null && root.rightChild != null) {
				int highestValueInLeftSubTree = findHighestValue(root.leftChild);
				root.data = highestValueInLeftSubTree;
				deleteNode(root.leftChild, highestValueInLeftSubTree);
			}
			if (root.leftChild == null && root.rightChild == null) {
				root = null;
				return root;
			}

			else {
				Node validChild = (root.leftChild != null) ? root.leftChild : root.rightChild;
				root = validChild;
				return root;
			}
		}
	}

	private void printTreeInOrder(Node root) {
		if (root != null) {
			printTreeInOrder(root.leftChild);
			System.out.println(root.data + " ");
			printTreeInOrder(root.rightChild);
		}
	}

	private int findHeight() {
		return calculateHeight(root);
	}

	private int calculateHeight(Node root) {
		if (root == null)
			return 0;
		else {
			int leftSubTreeHeight = calculateHeight(root.leftChild);
			int rigthSubTreeHeight = calculateHeight(root.rightChild);

			return leftSubTreeHeight >= rigthSubTreeHeight ? leftSubTreeHeight + 1 : rigthSubTreeHeight + 1;
		}
	}
	
	private int getMinimumDepth(Node root) {
		if(root == null)
			return 0;
		if(root.leftChild == null && root.rightChild == null)
			return 1;
		if(root.leftChild == null)
			return getMinimumDepth(root.rightChild);
		if(root.rightChild == null)
			return getMinimumDepth(root.leftChild);
		
		int leftSubTreeHeight = getMinimumDepth(root.leftChild);
		int rightSubTreeHeight = getMinimumDepth(root.rightChild);
		return leftSubTreeHeight < rightSubTreeHeight ? leftSubTreeHeight+1 : rightSubTreeHeight+1;
	}

	private void printTreeInLevels(Node root) {
		if(root == null)
			return ;
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while(true) {
			int nodeCount = queue.size();
			if(nodeCount == 0)
				break;
			while(nodeCount > 0) {
				Node currentNode = queue.poll();
				System.out.print(currentNode.data +" ");
				if(currentNode.leftChild != null) {
					queue.add(currentNode.leftChild);
				}
				if(currentNode.rightChild != null) {
					queue.add(currentNode.rightChild);
				}
				nodeCount--;
			}
			
			System.out.println("\n");
		}
	}

	private static int leafCount = 0;

	private void countLeaves(Node root) {
		System.out.println(countNumberOfLeaves(root));
	}

	private int countNumberOfLeaves(Node root) {
		if (root == null)
			return 0;

		if (root.leftChild == null && root.rightChild == null) {
			return 1;
		}

		else {
			return countNumberOfLeaves(root.leftChild) + countNumberOfLeaves(root.rightChild);
		}
	}
	
	private int getMaximumDepth(Node root) {
		if(root == null)
			return 0;
		if(root.leftChild == null && root.rightChild == null)
			return 1;
		if(root.leftChild == null)
			return getMaximumDepth(root.rightChild);
		if(root.rightChild == null)
			return getMaximumDepth(root.leftChild);
		int leftSubTreeHeight = getMaximumDepth(root.leftChild);
		int rightSubTreeHeight = getMaximumDepth(root.rightChild);
		return leftSubTreeHeight > rightSubTreeHeight ? leftSubTreeHeight+1 : rightSubTreeHeight+1;
	}

	public static void main(String[] args) {
		CountNumberOfLeavesInBinaryTree binaryTree = new CountNumberOfLeavesInBinaryTree();
		binaryTree.addNodeToTree(15);
		binaryTree.addNodeToTree(10);
		binaryTree.addNodeToTree(3);
		binaryTree.addNodeToTree(89);
		binaryTree.addNodeToTree(32);
		binaryTree.addNodeToTree(46);
		binaryTree.printTreeInOrder(binaryTree.root);
		System.out.println("__________");
		binaryTree.printTreeInLevels(binaryTree.root);
		System.out.println(" \n leaf count is " + binaryTree.countNumberOfLeaves(binaryTree.root));
		System.out.println("height of the tree is " + binaryTree.findHeight());
		System.out.println("the minimum depth of binary tree is "+binaryTree.getMinimumDepth(binaryTree.root));
		System.out.println("the maximum depth of the binary tree is "+binaryTree.getMaximumDepth(binaryTree.root));
	}

}
