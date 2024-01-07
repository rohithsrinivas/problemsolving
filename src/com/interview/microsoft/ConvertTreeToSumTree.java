package com.interview.microsoft;

import com.interview.microsoft.CheckIfBinaryTreeIsHeightBalanced.TreeNode;

public class ConvertTreeToSumTree {
	
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
	
	/*
	
	   10
    /      \
  -2        6
/   \      /  \ 
8     -4    7    5

*/
	
	TreeNode root;

	public TreeNode bstToGst(TreeNode root) {
		assignSum(root);
		return root;
	}
	
	int sum = 0;
	
	public void assignSum(TreeNode root) {
		if(root == null)
			return;
		assignSum(root.right);
		sum += root.val;
		root.val = sum;
		assignSum(root.left);
	}
	
	public static void main(String[] args) {
		ConvertTreeToSumTree tree = new ConvertTreeToSumTree();
		TreeNode root = tree.new TreeNode(10);
        root.left = tree.new TreeNode(-2);
        root.right = tree.new TreeNode(6);
        root.left.left = tree.new TreeNode(8);
        root.left.right = tree.new TreeNode(-4);
        root.right.left = tree.new TreeNode(7);
        root.right.right = tree.new TreeNode(5);
        tree.bstToGst(root);
        
	}

}
