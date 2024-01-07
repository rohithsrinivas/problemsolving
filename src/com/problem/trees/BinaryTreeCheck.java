package com.problem.trees;

import com.problem.trees.BinaryTreeLatestPractice.Node;

public class BinaryTreeCheck {

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
	
	TreeNode previous;
	
	public boolean isValidBST(TreeNode root) {
		if(root != null) {
			if(!isValidBST(root.left))
				return false;
			if(previous != null && previous.val >= root.val) {
				return false;
			}
			previous = root;
			return isValidBST(root.right);
		}
		return true;
    }
	
	
	
	

}
