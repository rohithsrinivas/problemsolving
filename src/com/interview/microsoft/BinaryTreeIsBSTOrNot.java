package com.interview.microsoft;

public class BinaryTreeIsBSTOrNot {
	
	Node root;
	
	class Node{
		int data;
		Node leftChild;
		Node rightChild;
		
		Node(int data){
			this.data = data;
		}
	}
	
	public Node addNode(int data) {
		root = addNode(data, root);
		return root;
	}
	
	private Node addNode(int data, Node root) {
		if(root == null) {
			return new Node(data);
		}
		else if(data < root.data) {
			root.leftChild = addNode(data, root.leftChild);
		}
		else if(data > root.data) {
			root.rightChild = addNode(data, root.rightChild);
		}
		return root;
	}
	
	Node prev;
	private boolean isBinaryTreeBST(Node root) {
		if(root != null) {
			if(!isBinaryTreeBST(root.leftChild)) {
				return false;
			}
			if(prev != null && prev.data >= root.data)
				return false;
			prev = root;
			return isBinaryTreeBST(root.rightChild);
		}
		return true;
		
	}

	public static void main(String[] args) {
		
	}

}
