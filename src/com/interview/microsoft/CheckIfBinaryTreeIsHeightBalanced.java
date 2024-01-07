package com.interview.microsoft;

public class CheckIfBinaryTreeIsHeightBalanced {

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

	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		int leftSubTreeHeight = getHeight(root.left);
		int rightSubTreeHeight = getHeight(root.right);

		if ((Math.abs(rightSubTreeHeight - leftSubTreeHeight) <= 1) && isBalanced(root.left) && isBalanced(root.right))
			return true;
		return false;
	}

	public int getHeight(TreeNode root) {
		if (root == null)
			return 0;
		int leftSubTreeHeight = getHeight(root.left);
		int rightSubTreeHeight = getHeight(root.right);
		return leftSubTreeHeight >= rightSubTreeHeight ? leftSubTreeHeight + 1 : rightSubTreeHeight + 1;
	}

}
