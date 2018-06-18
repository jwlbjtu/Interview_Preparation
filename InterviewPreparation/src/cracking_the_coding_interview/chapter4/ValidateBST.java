package cracking_the_coding_interview.chapter4;

import cracking_the_coding_interview.BinaryTreeNode;

class ResultType {
    long min;
    long max;
    boolean isBST;
    public ResultType(long min, long max, boolean isBST) {
        this.min = min;
        this.max = max;
        this.isBST = isBST;
    }
}

public class ValidateBST {
	public boolean topDown(BinaryTreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    boolean helper(BinaryTreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val >= max || root.val <= min) {
            return false;
        }
        boolean left = helper(root.left, min, root.val);
        boolean right = helper(root.right, root.val, max);
        return left && right;
    }
    
    
    public boolean bottomUp(BinaryTreeNode root) {
    	ResultType res = helper(root);
        return res.isBST;
    }
    
    ResultType helper(BinaryTreeNode root) {
        if (root == null) {
            return new ResultType(Long.MAX_VALUE, Long.MIN_VALUE, true);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        if (!left.isBST || !right.isBST || left.max >= root.val || right.min <= root.val) {
            return new ResultType(-1, -1, false);
        }
        long min = Math.min(root.val, Math.min(left.min, right.min));
        long max = Math.max(root.val, Math.max(left.max, right.max));
        return new ResultType(min, max, true);
    }
}
