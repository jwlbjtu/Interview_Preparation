package cracking_the_coding_interview.chapter4;

import cracking_the_coding_interview.BinaryTreeNode;

public class CommonAncester {
	
	public BinaryTreeNode commonAncestor(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}
		
		BinaryTreeNode left = commonAncestor(root.left, p, q);
		BinaryTreeNode right = commonAncestor(root.right, p, q);
		
		if (left != null && right != null) {
			return root;
		}
		
		if (left != null) return left;
		if (right != null) return right;
		
		return null;
	}
}
