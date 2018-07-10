package cracking_the_coding_interview.chapter4;

import java.util.Random;

class TreeNode {
	private TreeNode left;
	private TreeNode right;
	private int size = 0;
	private int data;
	
	public TreeNode(int data) {
		this.data = data;
		size = 1;
	}
	
	public TreeNode getRandomNode() {
		int leftSize = left == null ? 0 : left.size;
		Random rand = new Random();
		int index = rand.nextInt(size);
		if (index < leftSize) {
			return left.getRandomNode();
		} else if (index == leftSize) {
			return this;
		} else {
			return right.getRandomNode();
		}
	}
	
	public int size() {
		return size;
	}
	
	public int data() {
		return data;
	}
	
	public void insert(int d) {
		if (d <= data) {
			if (left == null) {
				left = new TreeNode(d);
			} else {
				left.insert(d);
			}
		} else {
			if (right == null) {
				right = new TreeNode(d);
			} else {
				right.insert(d);
			}
		}
		size++;
	}
	
	public TreeNode find(int d) {
		if (data == d) {
			return this;
		} else if (d < data) {
			if (left != null) {
				return left.find(d);
			}
		} else {
			if (right != null) {
				return right.find(d);
			}
		}
		return null;
	}
}

public class RandomNode {

}
