package com.interview.microsoft;

import java.util.ArrayList;
import java.util.List;

import com.interview.microsoft.CheckIfBinaryTreeIsHeightBalanced.TreeNode;

public class LCAOfBinaryTree {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || p.val == root.val || q.val == root.val)
			return root;
		TreeNode leftLca = lowestCommonAncestor(root.left, p, q);
		TreeNode rightLca = lowestCommonAncestor(root.right, p, q);
		if(leftLca != null && rightLca != null)
			return root;
		return leftLca != null ? leftLca : rightLca;
	}

	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		List<TreeNode> firstNodepath = new ArrayList<>();
		List<TreeNode> secondNodepath = new ArrayList<>();
		rootToNodePath(root, p.val, firstNodepath);
		rootToNodePath(root, q.val, secondNodepath);
		int i;
		for (i = 0; i < firstNodepath.size(); i++) {
			if (firstNodepath.get(i).val != secondNodepath.get(i).val)
				break;
			;

		}
		return firstNodepath.get(i - 1);
	}

	private boolean rootToNodePath(TreeNode root, int target, List<TreeNode> path) {
		if (root == null)
			return false;
		path.add(root);
		if (root.val == target)
			return true;

		if (rootToNodePath(root.left, target, path) || rootToNodePath(root.right, target, path))
			return true;

		path.remove(path.size() - 1);
		return false;
	}

}
