package cracking_the_coding_interview.chapter4;

import cracking_the_coding_interview.BinaryTreeNode;
import cracking_the_coding_interview.SuccessorNode;

public class InorderSucc {

	public SuccessorNode succ(SuccessorNode node) {
		if (node == null) return null;
		
		if (node.right != null) {
			SuccessorNode leftMost = getLeftMostNode(node.right);
			return leftMost;
		}
		
		SuccessorNode q = node;
		SuccessorNode x = node.parent;
		
		while (x != null && x.left != q) {
			q = x;
			x = x.parent;
		}
		return x;
	}
	
	SuccessorNode getLeftMostNode(SuccessorNode node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}
	
	BinaryTreeNode succ(BinaryTreeNode root, BinaryTreeNode p) {
		if (root == null) return null;
		
		if (root.val <= p.val) {
			return succ(root.right, p);
		}  else {
			BinaryTreeNode left = succ(root.left, p);
			return (left != null) ? left : root;
		}
	}
	
	BinaryTreeNode pres(BinaryTreeNode root, BinaryTreeNode p) {
		if (root == null) return null;
		
		if (root.val >= p.val) {
			return pres(root.left, p);
		} else {
			BinaryTreeNode right = pres(root.right, p);
			return (right != null) ? right : root;
		}
	}
}
