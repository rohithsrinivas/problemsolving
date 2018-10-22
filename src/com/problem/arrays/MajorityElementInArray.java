package com.problem.arrays;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MajorityElementInArray {
	
//	Node root;
//	int[] input;
//	
//	class Node{
//		int data;
//		int count;
//		Node leftChild;
//		Node rightChild;
//		
//		public Node(int data) {
//			this.data = data;
//			this.leftChild = null;
//			this.rightChild = null;
//			this.count = 1;
//		}
//	}
//	
//	private Node addNode(int data) {
//		root = addNode(root,data);
//		return root;
//	}
//	
//	private void removeNode(int data) {
//		root = deleteNode(root,data);
//	}
//	
//	private int findHighestValue(Node root) {
//		return root.rightChild != null ? findHighestValue(root.rightChild) : root.data;
//	}
//
//	private Node deleteNode(Node root, int data) {
//		if(root == null)
//			return null;
//		if(data < root.data)
//			root.leftChild = deleteNode(root.leftChild, data);
//		else if(data > root.data)
//			root.rightChild = deleteNode(root.rightChild, data);
//		else {
//			if(root.leftChild == null && root.rightChild == null) {
//				root = null;
//			}
//			else if(root.leftChild != null && root.rightChild != null) {
//				int highestValue = findHighestValue(root.leftChild);
//				root.data = highestValue;
//				root.leftChild = deleteNode(root.leftChild, highestValue);
//			}
//			else {
//				Node validChild = root.leftChild != null ? root.leftChild : root.rightChild;
//				root = validChild;
//			}
//		}
//		return root;
//	}
//
//	private Node addNode(Node root, int data) {
//		if(root == null)
//			return new Node(data);
//		if(data < root.data)
//			root.leftChild = addNode(root.leftChild, data);
//		else if(data > root.data)
//			root.rightChild = addNode(root.rightChild, data);
//		else if(data == root.data) {
//			root.count++;
//			if(root.count > this.input.length-1 / 2)
//				return root;
//		}
//		return root;
//	}
	

	private void printMajorityElementInArray(int[] input) {
		Map<Integer, Integer> counts = new HashMap<>();
		for(int i = 0;i<input.length;i++) {
			if(counts.containsKey(input[i]))
				counts.put(input[i], counts.get(input[i])+1);
			else
				counts.put(input[i], 1);
		}
		Iterator<Map.Entry<Integer, Integer>> mapIterator = counts.entrySet().iterator();
		while(mapIterator.hasNext()) {
			Entry<Integer, Integer> entry = mapIterator.next();
			if(entry.getValue() > input.length/2) {
				System.out.println("the majority element is "+entry.getKey());
				return;
			}
		}
		
		System.out.println("no majority element was found in the given input");
		
	}

	public static void main(String[] args) {
		MajorityElementInArray majorityBinaryTree = new MajorityElementInArray();
		int[] input = { 3, 3, 4, 2, 3, 3, 2, 4, 3 };
		majorityBinaryTree.printMajorityElementInArray(input);
		
	}

}
