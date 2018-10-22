package com.problem.trees;

import java.util.LinkedList;
import java.util.Queue;

public class ConvertDLLToTree {

	Node head;

	TreeNode root;

	 class TreeNode {
	 int data;
	 TreeNode leftChild;
	 TreeNode rightChild;
	
	 public TreeNode(int data) {
	 this.data = data;
	 this.leftChild = null;
	 this.rightChild = null;
	 }
	 }

	class Node {
		int data;
		Node next;
		Node prev;

		public Node(int data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

	private void insertInFirstPlace(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		newNode.prev = null;
		if (head != null)
			head.prev = newNode;
		head = newNode;
	}

	private void insertInLastPlace(int data) {
		if (head == null) {
			insertInFirstPlace(data);
			return;
		}
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		Node newNode = new Node(data);
		newNode.prev = temp;
		temp.next = newNode;
		newNode.next = null;
	}

	private void deleteFirstNode() {
		Node temp = head;
		head = temp.next;
	}

	private void deleteLastNode() {
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.prev.next = null;
	}

	private void insertAfterNode(int data, int afterData) {
		Node temp = head;
		while (temp.next != null) {
			if (temp.data == afterData)
				break;
			temp = temp.next;
		}
		Node newNode = new Node(data);
		newNode.next = temp.next;
		temp.next.prev = newNode;
		temp.next = newNode;
		newNode.prev = temp;
	}

	private void insertBeforeNode(int data, int beforeData) {
		Node temp = head;
		while (temp.next != null) {
			if (temp.data == beforeData)
				break;
			temp = temp.next;
		}
		Node newNode = new Node(data);
		temp.prev.next = newNode;
		newNode.next = temp;
		newNode.prev = temp.prev;
		temp.prev = newNode;
	}

	private Node findMiddleNode(Node head) {
		Node slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

//	private Node addNode(int data) {
//		root = addRecursively(root, data);
//		return root;
//	}

	private Node addRecursively(Node root, int data) {
		if (root == null)	
			return new Node(data);
		if (data < root.data) {
			root.prev = addRecursively(root.prev, data);
		} else if (data > root.data) {
			root.next = addRecursively(root.next, data);
		}
		return root;
	}

	private TreeNode convertDLLToTree(int length) {
		if(length <= 0)
			return null;
		TreeNode leftChild = convertDLLToTree(length/2);
		TreeNode root = new TreeNode(head.data);
		root.leftChild = leftChild;
		head = head.next;
		root.rightChild = convertDLLToTree(length- (length/2) -1);
		return root;
	}

	private int getSizeOfList() {
		Node temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	private void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data + " ");
			temp = temp.next;
		}
	}

	private void printInOrder(TreeNode root) {
		if (root != null) {
			printInOrder(root.leftChild);
			System.out.println(root.data);
			printInOrder(root.rightChild);
		}
	}

	private void printTreeInLevels() {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int level = 1;
		while (!queue.isEmpty()) {
			TreeNode currentNode = queue.poll();
			System.out.println(currentNode.data);

			if (currentNode.leftChild != null || currentNode.rightChild != null) {
				level++;
				System.out.println("\n");
			}

			if (currentNode.leftChild != null) {
				queue.add(currentNode.leftChild);
			}
			if (currentNode.rightChild != null) {
				queue.add(currentNode.rightChild);
			}
		}
	}

	public static void main(String[] args) {
		ConvertDLLToTree dll = new ConvertDLLToTree();
		dll.insertInLastPlace(10);
		dll.insertInLastPlace(30);
		dll.insertAfterNode(15, 10);
		dll.insertBeforeNode(12, 15);
		dll.insertInLastPlace(40);
		dll.printList();
		dll.convertDLLToTree();
		System.out.println("printing converted tree in order");
		dll.printInOrder();
		// dll.printTreeInLevels();
	}

	
	private TreeNode convertDLLToTree() {
		root = convertDLLToTree(getSizeOfList());
		return root ;
	}
	
	private void printInOrder() {
		printInOrder(root);
	}


}
