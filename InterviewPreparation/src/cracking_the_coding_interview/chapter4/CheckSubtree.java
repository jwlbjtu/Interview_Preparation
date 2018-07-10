package cracking_the_coding_interview.chapter4;

import cracking_the_coding_interview.BinaryTreeNode;

public class CheckSubtree {

	public boolean preOrder(BinaryTreeNode root1, BinaryTreeNode root2) {
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		getString(root1, sb1);
		getString(root2, sb2);
		return sb1.toString().indexOf(sb2.toString()) != -1;
	}
	
	void getString(BinaryTreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append("#");
			return;
		}
		sb.append(root.val);
		getString(root.left, sb);
		getString(root.right, sb);
	}
	
	public boolean math(BinaryTreeNode root1, BinaryTreeNode root2) {
		return mathSubtree(root1, root2);
	}
	
	boolean mathSubtree(BinaryTreeNode root1, BinaryTreeNode root2) {
		if (root1 == null) {
			return false;
		} else if (root1.val == root2.val && mathNodes(root1, root2)) {
			return true;
		}
		return mathSubtree(root1.left, root2) || mathSubtree(root1.right, root2);
	}
	
	boolean mathNodes(BinaryTreeNode root1, BinaryTreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		} else if (root1 == null || root2 == null) {
			return false;
		} else if (root1.val != root2.val) {
			return false;
		}
		
		return mathNodes(root1.left, root2.left) && mathNodes(root1.right, root2.right);
	}
}
