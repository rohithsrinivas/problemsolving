package com.interview.microsoft;

import java.util.ArrayList;
import java.util.List;

import com.interview.microsoft.CorrectBSTAfterNodesAreSwapped.TreeNode;

public class RootToLeafPaths {

	List<String> paths = new ArrayList<>();

	public List<String> binaryTreePaths(TreeNode root) {
		binaryTreePaths(root, "");
		return paths;
	}

	public void binaryTreePaths(TreeNode root, String path) {
		if (root == null)
			return; 	
		if (root.left == null && root.right == null) {
			path += root.val;
			paths.add(path);
			return;
		}
		
		path += root.val;
		path += "->";

		binaryTreePaths(root.left, path);
		binaryTreePaths(root.right, path);
	}

}
