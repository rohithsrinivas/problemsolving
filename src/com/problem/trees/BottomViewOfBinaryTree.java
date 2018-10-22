package com.problem.trees;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomViewOfBinaryTree {
	
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
			this.hd = Integer.MAX_VALUE;
		}
	}
	
	private void addNode(int data) {
		root = addRecursively(root,data);
	}

	private Node addRecursively(Node root, int data) {
		if(root == null)
			return new Node(data,0);
		if(data < root.data)
			root.leftChild = addRecursively(root.leftChild, data);
		if(data > root.data)
			root.rightChild = addRecursively(root.rightChild, data);
		return root;
	}
	
	private Node findHighestValue(Node root) {
		return root.rightChild != null ? findHighestValue(root.rightChild) : root;
	}
	
	private Node findLowestValue(Node root) {
		return root.leftChild != null ? findLowestValue(root.leftChild) : root;
	}
	
	private void removeNode(int data) {
		root = deleteNode(root,data);
	}

	private Node deleteNode(Node root, int data) {
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
			else if(root.rightChild != null && root.leftChild != null) {
				int highestValue = findHighestValue(root.leftChild).data;
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
				System.out.print(currentNode.data + " ");
				
				if(currentNode.leftChild != null)
					queue.add(currentNode.leftChild);
				if(currentNode.rightChild != null)
					queue.add(currentNode.rightChild);
				
				nodeCount--;
			}
			
			System.out.println();
		}
		
	}
	
	private void printLeafNodes(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while(queue.size() > 0) {
			int nodeCount = queue.size();
			
			if(nodeCount == 0)
				break;
			
			while(nodeCount > 0) {
				Node currentNode = queue.poll();
				
				if(currentNode.leftChild == null && currentNode.rightChild == null) {
					System.out.println(currentNode.data);
				}
				
				if(currentNode.leftChild != null)
					queue.add(currentNode.leftChild);
				
				if(currentNode.rightChild != null)
					queue.add(currentNode.rightChild);
				
				nodeCount--;
			}
		}
	}
	
	/* we need a concept called horizontal distance for this, horizontal distance for x is n, and for its left child
	 * its x-1 and right child its x+1, for root it is 0 and so on, the nodes for a particular horizontal distance 
	 * at the lowest level should be part of the bottom view*/
	private void printBottomView(Node root) {
		
		if(root == null)
			return;
		
		/* this map is used to map the horizontal distances with its corresponding nodes, now if there are multiple nodes with the same horizontal
		 * distance, we need to print the lowest node i.e with highest level, now in case we find a node with same distance in level 1 and another node
		 * at level 4, the second will replace the first in the map, in favor of higher level in the tree, so keep on adding values to the maps directly
		 * , we will have the sorted distances at the end and their corresponding nodes to be printed*/
		Map<Integer, Integer> distances = new TreeMap<>();
		int hd = 0;
		root.hd = hd;
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		while(queue.size() > 0) {
			Node currentNode = queue.poll();
			
			distances.put(currentNode.hd, currentNode.data);
			
			if(currentNode.leftChild != null) {
				currentNode.leftChild.hd = currentNode.hd - 1;
				queue.add(currentNode.leftChild);
			}
			
			if(currentNode.rightChild != null) {
				currentNode.rightChild.hd = currentNode.hd + 1;
				queue.add(currentNode.rightChild);
			}
		}
		
		Iterator<Map.Entry<Integer, Integer>> mapIterator = distances.entrySet().iterator();
		while(mapIterator.hasNext()) {
			Map.Entry<Integer, Integer> entry = mapIterator.next();
			System.out.println( entry.getValue()+" ");
		}
	}

	public static void main(String[] args) {
		BottomViewOfBinaryTree binaryTree = new BottomViewOfBinaryTree();
		binaryTree.addNode(2);
		binaryTree.addNode(1);
		binaryTree.addNode(3);
//		binaryTree.addNode(5);
//		binaryTree.addNode(3);
		binaryTree.addNode(4);
//		binaryTree.addNode(25);
//		binaryTree.addNode(10);
		binaryTree.addNode(14);
		binaryTree.printTreeInLevels(binaryTree.root);
		System.out.println("bottom view of binary tree is ");
		binaryTree.printLeafNodes(binaryTree.root);
		System.out.println("bottom view of binary tree is ");
		binaryTree.printBottomView(binaryTree.root);
	}

}
