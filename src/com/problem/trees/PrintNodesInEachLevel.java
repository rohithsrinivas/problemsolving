package com.problem.trees;

import java.util.LinkedList;
import java.util.Queue;

public class PrintNodesInEachLevel {
	
	Node root;
	
	class Node{
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
		root = addNode(root,data);
	}

	private Node addNode(Node root, int data) {
		if(root == null)
			return new Node(data);
		if(data < root.data)
			root.leftChild = addNode(root.leftChild, data);
		else if(data > root.data)
			root.rightChild = addNode(root.rightChild, data);
		return root;
	}
	
	private void deleteNode(int data) {
		root = deleteNode(root,data);
	}
	
	private int findHighestValue(Node root) {
		return root.rightChild != null ? findHighestValue(root.rightChild) : root.data;
	}

	private Node deleteNode(Node root, int data) {
		if(root == null)
			return null;
		if(data < root.data)
			root.leftChild = deleteNode(root.leftChild,data);
		else if(data > root.data)
			root.rightChild = deleteNode(root.rightChild, data);
		else {
			if(root.leftChild == null && root.rightChild == null)
				root = null;
			else if(root.leftChild != null && root.rightChild != null) {
				int highestValueInLeftSubTree = findHighestValue(root.leftChild);
				root.data = highestValueInLeftSubTree;
				deleteNode(root.leftChild, highestValueInLeftSubTree);
			}
			else {
				root = root.leftChild != null ? root.leftChild : root.rightChild;
			}
		}
		return root;
	}
	
	private void printTreeInLevels(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while(queue.size() > 0) {
			int nodeCount = queue.size();
			if(nodeCount == 0)
				break;
			while(nodeCount > 0) {
				Node currentNode = queue.poll();
				System.out.print(currentNode.data +"  ");
				if(currentNode.leftChild != null)
					queue.add(currentNode.leftChild);
				if(currentNode.rightChild != null)
					queue.add(currentNode.rightChild);
				nodeCount--;
			}
			System.out.println();
		}
	}
	
	private void printTreeInLevel(Node root,int level) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		int currentLevel = 1;
		while(queue.size() > 0) {
			int nodeCount = queue.size();
			if(nodeCount == 0)
				break;
			while(nodeCount > 0) {
				Node currentNode = queue.poll();
				if(currentLevel == level)
					System.out.print(currentNode.data +" ");
				if(currentNode.leftChild != null)
					queue.add(currentNode.leftChild);
				if(currentNode.rightChild != null)
					queue.add(currentNode.rightChild);
				nodeCount--;
			}
			currentLevel++;
		}
		
	}

	public static void main(String[] args) {
		PrintNodesInEachLevel binaryTree = new PrintNodesInEachLevel();
		binaryTree.addNode(10);
		binaryTree.addNode(23);
		binaryTree.addNode(6);
		binaryTree.addNode(90);
		binaryTree.addNode(35);
		binaryTree.deleteNode(35);
		binaryTree.printTreeInLevels(binaryTree.root);
		binaryTree.printTreeInLevel(binaryTree.root, 2);
	}

}
