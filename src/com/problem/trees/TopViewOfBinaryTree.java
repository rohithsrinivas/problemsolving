package com.problem.trees;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewOfBinaryTree {
	
	Node root;
	
	class Node{
		int data;
		Node leftChild;
		Node rightChild;
		int hd;
		
		public Node(int data,int hd) {
			this.data = data;
			this.leftChild = null;
			this.rightChild = null;
			this.hd = 0;
		}
	}
	
	private void addNode(int data) {
		root = addNode(root,data);
	}
	
	private void deleteNode(int data) {
		root = deleteNode(root,data);
	}
	
	private Node addNode(Node root,int data) {
		if(root == null)
			return new Node(data,0);
		if(data < root.data)
			root.leftChild = addNode(root.leftChild, data);
		if(data > root.data)
			root.rightChild = addNode(root.rightChild, data);
		return root;
	}
	
	private int getHighestValue(Node root) {
		return root.rightChild != null ? getHighestValue(root.rightChild) : root.data;
	}
	
	private int getSmallestValue(Node root) {
		return root.leftChild != null ? getSmallestValue(root.leftChild) : root.data;
	}
	
	private Node deleteNode(Node root,int data) {
		if(root == null)
			return null;
		if(data < root.data)
			root.leftChild = deleteNode(root.leftChild, data);
		if(data > root.data)
			root.rightChild = deleteNode(root.rightChild, data);
		else {
			if(root.leftChild == null && root.rightChild == null) {
				root = null;
			}
			if(root.leftChild != null && root.rightChild != null) {
				int highestValue = getHighestValue(root.leftChild);
				root.data = highestValue;
				deleteNode(root.leftChild, highestValue);
			}
			else {
				Node validChild = root.leftChild != null ? root.leftChild : root.rightChild;
				root = validChild;
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
				System.out.print(currentNode.data + "  ");
				
				if(currentNode.leftChild != null) 
					queue.add(currentNode.leftChild);
				if(currentNode.rightChild != null)
					queue.add(currentNode.rightChild);
				
				nodeCount--;
			}
			
			System.out.println();
		}
	}
	
	private void printTreeInOrder(Node root) {
		if(root != null) {
			printTreeInOrder(root.leftChild);
			System.out.print(root.data +" ");
			printTreeInOrder(root.rightChild);
		}
	}
	
	private int getHeightOfTree(Node root) {
		if(root == null)
			return 0;
		if(root.leftChild == null && root.rightChild == null)
			return 1;
		int leftSubTreeHeight = getHeightOfTree(root.leftChild);
		int rightSubTreeHeight = getHeightOfTree(root.rightChild);
		
		return leftSubTreeHeight > rightSubTreeHeight ? leftSubTreeHeight+1 : rightSubTreeHeight+1;
	}
	
	/* this also follows the same idea of horizontal distance, just like bottom view of tree , in the bottom view of tree we want the nodes which have 
	 * the same horizontal distance at the lowest levels of the tree, in the top view we want the nodes which have the same horizontal distance at the
	 * top most levels of the binary tree*/
	private void printTopViewOfTree(Node root) {
		if(root == null)
			return;
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		root.hd = 0;
		Map<Integer, Node> distances = new TreeMap<>();
		while(queue.size() > 0) {
			Node currentNode = queue.poll();
			/* since we want the top most nodes for a given horizontal distance, we put only once, to avoid overwriting them with nodes in the lower 
			 * levels with the same horizontal distance*/
			if(!distances.containsKey(currentNode.hd)) {
				distances.put(currentNode.hd, currentNode);
			}
			
			if(currentNode.leftChild != null) {
				currentNode.leftChild.hd = currentNode.hd - 1;
				queue.add(currentNode.leftChild);
			}
			
			if(currentNode.rightChild != null) {
				currentNode.rightChild.hd = currentNode.hd + 1;
				queue.add(currentNode.rightChild);
			}
		}
		
		Iterator<Map.Entry<Integer, Node>> mapIterator = distances.entrySet().iterator();
		while(mapIterator.hasNext()) {
			Entry<Integer, Node> entry = mapIterator.next();
			System.out.print(entry.getValue().data+ "  ");
		}
		
	}
	
	private static int maxLevel = 0;
	private void printLeftView(Node root,int level) {
		if(root == null)
			return;
		
		if(maxLevel < level) {
			System.out.print(root.data +" ");
			maxLevel = level;
		}
		
		printLeftView(root.leftChild, ++level);
		printLeftView(root.rightChild, ++level);
	}

	private static int maxLevel2 = 0;
	private void printRightView(Node root,int level) {
		if(root == null)
			return;
		
		if(maxLevel2 < level)
		{
			System.out.print(root.data+"  ");
			maxLevel2 = level;
		}
		
		printRightView(root.rightChild, ++level);
		printRightView(root.leftChild, ++level);
	}
	public static void main(String[] args) {
		TopViewOfBinaryTree binaryTree = new TopViewOfBinaryTree();
		binaryTree.addNode(10);
		binaryTree.addNode(3);
		binaryTree.addNode(25);
		binaryTree.addNode(8);
		binaryTree.addNode(32);
		binaryTree.addNode(23);
		binaryTree.addNode(90);
		binaryTree.addNode(21);
		System.out.println("printing tree in order");
		binaryTree.printTreeInOrder(binaryTree.root);
		System.out.println("printing tree in levels");
		binaryTree.printTreeInLevels(binaryTree.root);
		System.out.println("height of the tree is "+binaryTree.getHeightOfTree(binaryTree.root));
		binaryTree.printTopViewOfTree(binaryTree.root);
		System.out.println("left view of tree is ");
		binaryTree.printLeftView(binaryTree.root, 1);
		System.out.println("the right view of binary tree is ");
		binaryTree.printRightView(binaryTree.root, 1);
	}

}
