package com.interview.microsoft;

public class PrintBSTKeysInGivenRange {

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
	
	int sum = 0;
	
	public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null)
        	return 0;
        if(low < root.val) rangeSumBST(root.left, low, high);
        if(root.val >= low && root.val <= high) {
        	sum += root.val;
        }
        rangeSumBST(root.right, low, high);
        return sum;
    }
	
	public void printKeysInGivenRange(TreeNode root, int low, int high) {
        if(root == null)
        	return;
        if(low < root.val) printKeysInGivenRange(root.left, low, high);
        if(root.val >= low && root.val <= high) {
        	System.out.print(root.val);
        }
        printKeysInGivenRange(root.right, low, high);
    }

}
