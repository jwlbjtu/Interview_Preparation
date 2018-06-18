package cracking_the_coding_interview.chapter4;

import java.util.*;

import cracking_the_coding_interview.BinaryTreeNode;

public class BSTSequence {

	public ArrayList<LinkedList<Integer>> allSequences(BinaryTreeNode root) {
		ArrayList<LinkedList<Integer>> results = new ArrayList<LinkedList<Integer>>();
		
		if (root == null) {
			results.add(new LinkedList<Integer>());
			return results;
		}
		
		LinkedList<Integer> prefix = new LinkedList<Integer>();
		prefix.add(root.val);
		
		ArrayList<LinkedList<Integer>> leftList = allSequences(root.left);
		ArrayList<LinkedList<Integer>> rightList = allSequences(root.right);
		
		for (LinkedList<Integer> left : leftList) {
			for (LinkedList<Integer> right : rightList) {
				ArrayList<LinkedList<Integer>> weave = new ArrayList<LinkedList<Integer>>();
				weaveList(left, right, weave, prefix);
				results.addAll(weave);
			}
		}
		return results;
	}
	
	public void weaveList(LinkedList<Integer> first, LinkedList<Integer> second, 
			ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
		
		if (first.size() == 0 || second.size() == 0) {
			LinkedList<Integer> res = (LinkedList<Integer>)prefix.clone();
			res.addAll(first);
			res.addAll(second);
			results.add(res);
			return;
		}
		
		int headFirst = first.removeFirst();
		prefix.addLast(headFirst);
		weaveList(first, second, results, prefix);
		prefix.removeLast();
		first.addFirst(headFirst);
		
		int headSecond = second.removeFirst();
		prefix.addLast(headSecond);
		weaveList(first, second, results, prefix);
		prefix.removeLast();
		second.addFirst(headSecond);
	}
}
