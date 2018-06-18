package cracking_the_coding_interview.chapter4;

import cracking_the_coding_interview.BinaryTreeNode;

class Result {
	boolean isBalance;
	int maxDepth;
	public Result (boolean isBalance, int maxDepth) {
		this.isBalance = isBalance;
		this.maxDepth = maxDepth;
	}
}

public class CheckBalanced {
	
	public boolean isBalance(BinaryTreeNode root) {
		Result res = helper(root);
		return res.isBalance;
	}
	
	private Result helper(BinaryTreeNode root) {
		if (root == null) {
			return new Result(true, 0);
		}
		
		Result left = helper(root.left);
		Result right = helper(root.right);
		
		if (!left.isBalance || !right.isBalance || Math.abs(left.maxDepth - right.maxDepth) > 1) {
			return new Result(false, -1);
		}
		
		int depth = Math.max(left.maxDepth, right.maxDepth) + 1;
		return new Result(true, depth);
	}
}
