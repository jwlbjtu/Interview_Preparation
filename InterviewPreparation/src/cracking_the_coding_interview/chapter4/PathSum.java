package cracking_the_coding_interview.chapter4;

import java.util.*;

import cracking_the_coding_interview.BinaryTreeNode;

public class PathSum {

	public int getPath(BinaryTreeNode root, int sum) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] count = new int[1];
		helper(root, sum, 0, map, count);
		return count[0];
	}
	
	void helper(BinaryTreeNode root, int sum, int total, HashMap<Integer, Integer> map, int[] count) {
		if (root == null) return;
		
		total = total + root.val;
		
		count[0] += map.getOrDefault(total - sum, 0);
		
		if (total == sum) {
			count[0]++;
		}
		
		map.put(total, map.getOrDefault(total, 0) + 1);
		
		helper(root.left, sum, total, map, count);
		helper(root.right, sum, total, map, count);
		
		map.put(total, map.get(total) - 1);
	}
}
