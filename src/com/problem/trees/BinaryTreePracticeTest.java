package com.problem.trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BinaryTreePracticeTest {

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

	public void addNode(int data) {
		this.root = addNode(data, root);
	}

	public Node addNode(int data, Node root) {
		if (root == null) {
			root = new Node(data);
		}
		if (data < root.data) {
			root.leftChild = addNode(data, root.leftChild);
		}
		if (data > root.data) {
			root.rightChild = addNode(data, root.rightChild);
		}
		return root;
	}

	public boolean search(int data) {
		return search(data, root);
	}

	public boolean search(int data, Node root) {
		if (root == null)
			return false;
		if (data < root.data)
			return search(data, root.leftChild);
		if (data > root.data)
			return search(data, root.rightChild);
		else
			return true;
	}

	public void printTreeInLevels(Node root) {
		if (root == null)
			return;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		int nodeCount = 0;
		Node currentNode;
		while (queue.size() > 0) {
			nodeCount = queue.size();
			while (nodeCount > 0) {
				if (nodeCount == 0)
					break;
				currentNode = queue.poll();
				System.out.print(currentNode.data + " ");
				if (currentNode.leftChild != null) {
					queue.add(currentNode.leftChild);
				}
				if (currentNode.rightChild != null) {
					queue.add(currentNode.rightChild);
				}
				nodeCount--;
			}
			System.out.println();

		}

	}

	public int findDepthOfTheTree(Node root) {
		if (root == null)
			return 0;
		int leftSubTreeHeight = findDepthOfTheTree(root.leftChild);
		int rightSubTreeHeight = findDepthOfTheTree(root.rightChild);

		return leftSubTreeHeight > rightSubTreeHeight ? leftSubTreeHeight + 1 : rightSubTreeHeight + 1;
	}

	public void printLeavesInTheTree(Node root) {
		if (root == null)
			return;
		System.out.println("The leaves in the tree are: ");
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		Node currentNode;
		while (queue.size() > 0) {
			currentNode = queue.poll();
			if (currentNode.leftChild == null && currentNode.rightChild == null)
				System.out.println(currentNode.data + " ");
			if (currentNode.leftChild != null)
				queue.add(currentNode.leftChild);
			if (currentNode.rightChild != null)
				queue.add(currentNode.rightChild);
			
		}
	}
	
	public int getHighestValue(Node root) {
		return root.rightChild != null ? getHighestValue(root.rightChild) : root.data;
	}
	
	public int getLowestValue(Node root) {
		return root.leftChild != null ? getLowestValue(root.leftChild) : root.data;
	}
	
	public Node deleteNode(int data) {
		return deleteNode(data, root);
	}
	
	public void inOrderTraversal(Node root) {
		if(root != null) {
			inOrderTraversal(root.leftChild);
			System.out.print(root.data + " ");
			inOrderTraversal(root.rightChild);
		}
	}
	
	public void preOrderTraversal(Node root) {
		if(root != null) {
			System.out.print(root.data + " ");
			preOrderTraversal(root.leftChild);
			preOrderTraversal(root.rightChild);
		}
	}
	
	public void postOrderTraversal(Node root) {
		if(root != null) {
			postOrderTraversal(root.leftChild);
			postOrderTraversal(root.rightChild);
			System.out.print(root.data + " ");
		}
	}
	
	public Node deleteNode(int data, Node root) {
		if(root == null)
			return null;
		if(data < root.data)
			root.leftChild = deleteNode(data, root.leftChild);
		if(data > root.data)
			root.rightChild = deleteNode(data, root.rightChild);
		else {
			if(root.leftChild != null && root.rightChild != null) {
				int highestValueInLeftSubtree = getHighestValue(root.leftChild);
				root.data = highestValueInLeftSubtree;
				root.leftChild = deleteNode(highestValueInLeftSubtree, root.leftChild);
			}
			else if(root.leftChild != null)
				root = root.leftChild;
			else if(root.rightChild != null)
				root = root.rightChild;
			else
				root = null;
		}
		return root;
	}
	
	public void printBottomViewOfTree(Node root) {
		if(root == null)
			return;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		Map<Integer, Node> distanceMap = new HashMap<>();
		Node currentNode;
		while(queue.size() > 0) {
			currentNode = queue.poll();
			distanceMap.put(currentNode.hd, currentNode);
			if(currentNode.leftChild != null) {
				currentNode.leftChild.hd = currentNode.hd - 1;
				queue.add(currentNode.leftChild);
			}
			if(currentNode.rightChild != null) {
				currentNode.rightChild.hd = currentNode.hd + 1;
				queue.add(currentNode.rightChild);
			}
		}
		System.out.println("Bottom view of the binary tree is : ");
		distanceMap.entrySet().stream().forEach(entry -> System.out.print(entry.getValue().data + " "));
	}
	
	public void printTopViewOfBinaryTree(Node root) {
		if(root == null)
			return;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		Node currentNode;
		Map<Integer, Node> distanceMap = new HashMap<>();
		while(queue.size() > 0) {
			currentNode = queue.poll();
			if(!distanceMap.containsKey(currentNode.hd)) {
				distanceMap.put(currentNode.hd, currentNode);
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
		System.out.println("Top view of the binary tree is: ");
		distanceMap.entrySet().stream().forEach(entry -> System.out.print(entry.getValue().data + " "));
	}
	
	

	public static void main(String[] args) {
		BinaryTreePracticeTest binaryTree = new BinaryTreePracticeTest();
		binaryTree.addNode(10);
		binaryTree.addNode(5);
		binaryTree.addNode(15);
		binaryTree.addNode(2);
		binaryTree.addNode(25);
		binaryTree.addNode(3);
		binaryTree.printTreeInLevels(binaryTree.root);
		Node newRoot = binaryTree.deleteNode(5);
		System.out.println("after deleting");
		binaryTree.printTreeInLevels(newRoot);
		System.out.println("height of the binary tree is " + binaryTree.findDepthOfTheTree(binaryTree.root));
		binaryTree.printLeavesInTheTree(binaryTree.root);
		binaryTree.printTopViewOfBinaryTree(binaryTree.root);
		binaryTree.printBottomViewOfTree(binaryTree.root);
		System.out.println("In order traversal of binary tree");
		binaryTree.inOrderTraversal(binaryTree.root);
		System.out.println("Pre order traversal of binary tree");
		binaryTree.preOrderTraversal(binaryTree.root);
		System.out.println("post order traversal of binary tree");
		binaryTree.postOrderTraversal(binaryTree.root);

	}

}
