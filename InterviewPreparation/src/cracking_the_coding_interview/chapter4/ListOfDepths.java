package cracking_the_coding_interview.chapter4;

import java.util.*;

import cracking_the_coding_interview.BinaryTreeNode;
import cracking_the_coding_interview.LinkedNode;

public class ListOfDepths {

	public List<LinkedNode> levelList(BinaryTreeNode root) {
		ArrayList<LinkedNode> res = new ArrayList<>();
		if (root == null) return res;
		
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			LinkedNode dummy = new LinkedNode(-1);
			LinkedNode prev = dummy;
			for (int i = 0; i < size; i++) {
				BinaryTreeNode node = queue.poll();
				LinkedNode n = new LinkedNode(node.val);
				prev.next = n;
				prev = n;
				if (node.left != null) queue.offer(node.left);
				if (node.right != null) queue.offer(node.right);
			}
			res.add(dummy.next);
		}
		return res;
	}
}
