package com.problem.trees;

import java.util.LinkedList;
import java.util.Queue;

public class KthLargestNodeInBinaryTree {

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

	private void removeNode(int data) {
		root = removeNode(root, data);
	}

	private Node removeNode(Node root, int data) {
		if (root == null)
			return null;
		if (data < root.data)
			root.leftChild = removeNode(root.leftChild, data);
		else if (data > root.data)
			root.rightChild = removeNode(root.rightChild, data);
		else {
			if (root.leftChild == null && root.rightChild == null) {
				root = null;
			} else if (root.leftChild != null && root.rightChild != null) {
				int highestValue = findHighestValue(root.leftChild);
				root.data = highestValue;
				removeNode(root.leftChild, highestValue);
			} else {
				root = root.leftChild != null ? root.leftChild : root.rightChild;
			}
		}
		return null;
	}

	private int findHighestValue(Node root) {
		return root.rightChild != null ? findHighestValue(root.rightChild) : root.data;
	}

	private void findKthLargestNode(Node root, int k) {
		if(k == 0)
			System.out.println("kth largest node is "+root.data);
		if (root == null)
			return;
		if (root.rightChild != null)
			findKthLargestNode(root.rightChild, k);
		findKthLargestNode(root,--k);
		System.out.println(root.data);

	}
	
	private void printTreeInLevels(Node root) {
		if(root == null)
			return;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while(queue.size() > 0) {
			int nodeCount = queue.size();
			if(nodeCount == 0)
				break;
			while(nodeCount > 0) {
				Node currentNode = queue.poll();
				System.out.print(currentNode.data+" ");
				if(currentNode.leftChild != null)
					queue.add(currentNode.leftChild);
				if(currentNode.rightChild != null)
					queue.add(currentNode.rightChild);
				nodeCount--;
			}
			
			System.out.println();
		}
	}

	private void findKthLargestNode(int k) {
		findKthLargestNode(root, k);
	}

	public static void main(String[] args) {
		KthLargestNodeInBinaryTree binaryTree = new KthLargestNodeInBinaryTree();
		binaryTree.addNode(30);
		binaryTree.addNode(40);
		binaryTree.addNode(10);
		binaryTree.addNode(20);
		binaryTree.addNode(28);
		binaryTree.addNode(12);
		binaryTree.addNode(80);
		binaryTree.addNode(30);
		binaryTree.addNode(40);
		binaryTree.printTreeInLevels(binaryTree.root);
		binaryTree.findKthLargestNode(2);
	}

}
