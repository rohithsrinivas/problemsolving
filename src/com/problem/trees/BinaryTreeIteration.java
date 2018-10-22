package com.problem.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeIteration {
	
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
		root = addNode(root, data);
	}
	
	private Node addNode(Node root,int data) {
		if(root == null)
			return new Node(data);
		if(data < root.data) {
			root.leftChild = addNode(root.leftChild,data);
		}
		if(data > root.data) {
			root.rightChild = addNode(root.rightChild, data);
		}
		
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
		if(data < root.data) {
			root.leftChild = deleteNode(root.leftChild, data);
		}
		else if(data > root.data) {
			root.rightChild = deleteNode(root.rightChild, data);
		}
		else {
			if(root.leftChild == null && root.rightChild == null) {
				root = null;
			}
			else if(root.leftChild != null && root.rightChild !=  null) {
				int highestValue = findHighestValue(root.leftChild);
				root.data = highestValue;
				root.leftChild = deleteNode(root.leftChild, highestValue);
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
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while(queue.size() > 0) {
			int nodeCount = queue.size();
			if(nodeCount == 0)
				break;
			
			while(nodeCount > 0) {
				Node currentNode = queue.poll();
				System.out.print(currentNode.data + "  ");
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
	
	/* for pre order we directly start from root, so direct insert root to stack, and then insert right child and left child if they exist,
	 * because we use a stack, LIFO, so left will come out first when we pop, so hence pre order root,left and right childs*/
	private void printPreOrder(Node root) {
		if(root == null)
			return;
		Stack<Node> nodeStack = new Stack<>();
		nodeStack.push(root);
		System.out.println("printing pre order traversal");
		while(nodeStack.size() > 0) {
			Node currentNode = nodeStack.pop();
			System.out.print(currentNode.data +" ");
			if(currentNode.rightChild != null)
				nodeStack.push(currentNode.rightChild);
			if(currentNode.leftChild != null)
				nodeStack.push(currentNode.leftChild);
		}
	}
	
	private void printInOrder(Node root) {
		if(root == null)
			return;
		Stack<Node> nodeStack = new Stack<>();
		Node currentNode = root;
		System.out.println("printing in order traversal");
		while(currentNode != null || nodeStack.size() > 0) {
			while(currentNode != null) {
				nodeStack.push(currentNode);
				currentNode = currentNode.leftChild;
			}
			
			currentNode = nodeStack.pop();
			
			System.out.print(currentNode.data +"  ");
			
			currentNode = currentNode.rightChild;
		}
	}
	
	private void printPostOrder(Node root) {
		if(root == null)
			return;
		Stack<Node> nodeStack = new Stack<>();
		Node currentNode = root;
		System.out.println("printing post order traversal");
		while(true) {
			while(currentNode != null) {
				nodeStack.add(currentNode);
				nodeStack.add(currentNode);
				currentNode = currentNode.leftChild;
			}
			
			if(nodeStack.isEmpty())
				return;
			
			currentNode = nodeStack.pop();
			
			if(!nodeStack.isEmpty() && nodeStack.peek() == currentNode) {
				currentNode = currentNode.rightChild;
			}
			else {
				System.out.print(currentNode.data + " ");
				currentNode = null;
			}
		}
	}
	
	
	public static void main(String[] args) {
		BinaryTreeIteration binaryTree = new BinaryTreeIteration();
		binaryTree.addNode(35);
		binaryTree.addNode(23);
		binaryTree.addNode(12);
		binaryTree.addNode(67);
		binaryTree.printTreeInLevels(binaryTree.root);
		binaryTree.printPreOrder(binaryTree.root);
		binaryTree.printInOrder(binaryTree.root);
		binaryTree.printPostOrder(binaryTree.root);
		
	}

}
