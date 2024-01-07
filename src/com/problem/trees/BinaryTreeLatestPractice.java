package com.problem.trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

@SuppressWarnings("unused")
public class BinaryTreeLatestPractice {

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
	
	public boolean search(int data) {
		return search(root, data);
	}

	private boolean search(Node root, int data) {
		if(root == null)
			return false;
		if(data < root.data)
			return search(root.leftChild, data);
		else if(data > root.data)
			return search(root.rightChild, data);
		else
			return true;
			
	}

	public Node addNode(int data) {
		root = addNode(root, data);
		return root;
	}

	private Node addNode(Node root, int data) {
		if (root == null)
			return new Node(data);
		if (data < root.data) {
			root.leftChild = addNode(root.leftChild, data);
		} else if (data > root.data) {
			root.rightChild = addNode(root.rightChild, data);
		}
		return root;
	}

	private Node deleteNode(int data) {
		return deleteNode(root, data);
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
				int highestValueInLeftSubTree = getHighestValueInTree(root.leftChild);
				root.data = highestValueInLeftSubTree;
				root.leftChild = deleteNode(root.leftChild, highestValueInLeftSubTree);
			} else {
				root = root.leftChild != null ? root.leftChild : root.rightChild;
				deleteNode(root, root.data);
			}
		}
		return root;
	}
	
	private int getHeightOfBinaryTree(Node root) {
		if(root == null)
			return 0;
		int leftSubtreeHeight = getHeightOfBinaryTree(root.leftChild);
		int rightSubtreeHeight = getHeightOfBinaryTree(root.rightChild);
		return leftSubtreeHeight >= rightSubtreeHeight ? leftSubtreeHeight + 1: rightSubtreeHeight + 1;
	}

	private void inorderTraversal(Node root) {
		if (root != null) {
			inorderTraversal(root.leftChild);
			System.out.print(root.data + " ");
			inorderTraversal(root.rightChild);
		}
	}

	private void preordeTraversal(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preordeTraversal(root.leftChild);
			preordeTraversal(root.rightChild);
		}
	}

	private void postordeTraversal(Node root) {
		if (root != null) {
			postordeTraversal(root.leftChild);
			postordeTraversal(root.rightChild);
			System.out.print(root.data + " ");
		}
	}

	private void printBottomViewOfBinaryTree(Node root) {
		if (root == null)
			return;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		Map<Integer, Integer> distances = new TreeMap<>();
		while (queue.size() > 0) {
			Node node = queue.poll();
			distances.put(node.hd, node.data);
			if (node.leftChild != null) {
				node.leftChild.hd = node.hd - 1;
				queue.add(node.leftChild);
			}
			if (node.rightChild != null) {
				node.rightChild.hd = node.hd + 1;
				queue.add(node.rightChild);
			}
		}

		distances.entrySet().stream().forEach(distance -> System.out.print(distance.getValue() + " "));
	}

	private void printTopViewOfBinaryTree(Node root) {
		if (root == null)
			return;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		Map<Integer, Node> distances = new TreeMap<>();
		while (queue.size() > 0) {
			Node node = queue.poll();
			if (!distances.containsKey(node.hd))
				distances.put(node.hd, node);
			if (node.leftChild != null) {
				node.leftChild.hd = node.hd - 1;
				queue.add(node.leftChild);
			}
			if (node.rightChild != null) {
				node.rightChild.hd = node.hd + 1;
				queue.add(node.rightChild);
			}
		}

		distances.entrySet().stream().forEach(distance -> System.out.print(distance.getValue().data + " "));
	}

	private void printTreeInLevels(Node root) {
		if (root == null)
			return;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		int nodeCount = 0;
		while (queue.size() > 0) {
			nodeCount = queue.size();
			if (nodeCount == 0)
				break;
			while (nodeCount > 0) {
				Node node = queue.poll();
				System.out.print(node.data + " ");
				if (node.leftChild != null) {
					System.out.println("left Child of " + node.data + "is " + node.leftChild.data);
					queue.add(node.leftChild);
				}
				if (node.rightChild != null) {
					System.out.println("right Child of " + node.data + "is " + node.rightChild.data);
					queue.add(node.rightChild);
				}
				nodeCount--;
			}
			System.out.println();
		}
	}

	private int getHighestValueInTree(Node root) {
		return root.rightChild != null ? getHighestValueInTree(root.rightChild) : root.data;
	}

	private int getLowestValueInTree(Node root) {
		return root.leftChild != null ? getLowestValueInTree(root.leftChild) : root.data;
	}

	public static void main(String[] args) {
		BinaryTreeLatestPractice binaryTree = new BinaryTreeLatestPractice();
//		binaryTree.addNode(12);
//		binaryTree.addNode(5);
//		binaryTree.addNode(15);
//		binaryTree.addNode(3);
//		binaryTree.addNode(7);
//		binaryTree.addNode(13);
//		binaryTree.addNode(17);
//		binaryTree.addNode(1);
//		binaryTree.addNode(9);
//		binaryTree.addNode(8);
//		binaryTree.addNode(11);

		binaryTree.addNode(20);
		binaryTree.addNode(8);
		binaryTree.addNode(22);
		binaryTree.addNode(5);
		binaryTree.addNode(12);
		binaryTree.addNode(25);
		binaryTree.addNode(10);
		binaryTree.addNode(14);
		binaryTree.addNode(19);
		binaryTree.printTreeInLevels(binaryTree.root);
//		binaryTree.deleteNode(3);
//		System.out.println("after deleting 3");
//		binaryTree.printTreeInLevels(binaryTree.root);
		System.out.println("\nHeight of the binary Tree is " + binaryTree.getHeightOfBinaryTree(binaryTree.root));
		System.out.println("\nprinting inorder traversal");
		binaryTree.inorderTraversal(binaryTree.root);
		System.out.println("\nprinting preorder traversal");
		binaryTree.preordeTraversal(binaryTree.root);
		System.out.println("\nprinting postorder traversal");
		binaryTree.postordeTraversal(binaryTree.root);
		System.out.println("\nprinting bottom view of binary tree");
		binaryTree.printBottomViewOfBinaryTree(binaryTree.root);
		System.out.println("\nprinting top view of binary tree");
		binaryTree.printTopViewOfBinaryTree(binaryTree.root);

	}

}
