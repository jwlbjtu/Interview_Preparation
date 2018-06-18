package cracking_the_coding_interview.chapter2;

import java.util.HashSet;

import cracking_the_coding_interview.LinkedNode;

public class RemoveDups {
	
	public static LinkedNode s1(LinkedNode head) {
		if (head == null) return head;
		HashSet<Integer> set= new HashSet<Integer>();
		LinkedNode cur = head;
		LinkedNode prev = null;
		while (cur != null) {
			if (set.contains(cur.val)) {
				prev.next = cur.next;
			} else {
				set.add(cur.val);
				prev = cur;
			}
			cur = cur.next;
		}
		return head;
	}
	
	public static LinkedNode s2(LinkedNode head) {
		if (head == null) return head;
		LinkedNode cur = head;
		while (cur != null) {
			LinkedNode node = cur;
			while (node.next != null) {
				if (node.next.val == cur.val) {
					node.next = node.next.next;
				} else {
					node = node.next;
				}
			}
			cur = cur.next;
		}
		return head;
	}
	
	public static void main(String[] args) {
		LinkedNode node1 = new LinkedNode(1);
		LinkedNode node2 = new LinkedNode(2);
		LinkedNode node3 = new LinkedNode(3);
		LinkedNode node4 = new LinkedNode(2);
		LinkedNode node5 = new LinkedNode(1);
		LinkedNode node6 = new LinkedNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		
		LinkedNode temp = node1;
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		
		System.out.println("");
		
		LinkedNode head1 = s1(node1);
		while(head1 != null) {
			System.out.print(head1.val + " ");
			head1 = head1.next;
		}
		
		LinkedNode node7 = new LinkedNode(1);
		LinkedNode node8 = new LinkedNode(2);
		LinkedNode node9 = new LinkedNode(3);
		LinkedNode node10 = new LinkedNode(2);
		LinkedNode node11 = new LinkedNode(1);
		LinkedNode node12 = new LinkedNode(5);
		node7.next = node8;
		node8.next = node9;
		node9.next = node10;
		node10.next = node11;
		node11.next = node12;
		
		System.out.println("");
		
		temp = node7;
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		
		System.out.println("");
		
		LinkedNode head2 = s2(node7);
		while(head2 != null) {
			System.out.print(head2.val + " ");
			head2 = head2.next;
		}	
	}
}
