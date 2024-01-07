package com.interview.microsoft;

import java.util.ArrayList;
import java.util.List;

public class CorrectBSTAfterNodesAreSwapped {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	private TreeNode first = null, middle = null, last = null, prev = null;
	
	public void recoverTree(TreeNode root) {
		if(root == null) return;
		inOrderTraversal(root);
		if(first != null && last != null) {
			int temp = first.val;
			first.val = last.val;
			last.val = temp;
		}
		else {
			int temp = first.val;
			first.val = middle.val;
			middle.val = temp;
		}
		
        
    }
	
	
	
	private void inOrderTraversal(TreeNode root) {
		if(root == null) return;
		inOrderTraversal(root.left);
		if(prev != null && prev.val >= root.val) {
			if(first == null) {
				first = prev;
				middle = root;
			}
			else {
				last = root;
			}
		}
		prev = root;
		inOrderTraversal(root.right);
		
	}
	
	

}
