package cracking_the_coding_interview.chapter2;

import cracking_the_coding_interview.LinkedNode;

public class RemoveMiddleNode {
	public static void s1(LinkedNode node) {
		if (node == null || node.next == null) return;
		LinkedNode next = node.next;
		node.val = next.val;
		node.next = next.next;
	}
	
	public static void main(String[] args) {
		LinkedNode node1 = new LinkedNode(1);
		LinkedNode node2 = new LinkedNode(2);
		LinkedNode node3 = new LinkedNode(3);
		LinkedNode node4 = new LinkedNode(4);
		LinkedNode node5 = new LinkedNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		LinkedNode temp = node1;
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		
		System.out.println();
		s1(node4);
		
		temp = node1;
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
	}
}
