package cracking_the_coding_interview.chapter4;

import cracking_the_coding_interview.BinaryTreeNode;

public class MinimalTree {

	public BinaryTreeNode buildBST(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		return helper(nums, 0, nums.length);
	}
	
	private BinaryTreeNode helper(int[] nums, int start, int end) {
		if (start > end) return null;
		
		int midd = (start + end) / 2;
		BinaryTreeNode root = new BinaryTreeNode(nums[midd]);
		root.left = helper(nums, start, midd - 1);
		root.right = helper(nums, midd + 1, end);
		return root;
	}
}
