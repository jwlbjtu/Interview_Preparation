package cracking_the_coding_interview.chapter2;

import cracking_the_coding_interview.LinkedNode;

public class Partition {

	public static LinkedNode s1(LinkedNode head, int k) {
		if (head == null) return head;
		LinkedNode dummyS = new LinkedNode(-1);
		LinkedNode stail = dummyS;
		LinkedNode dummyL = new LinkedNode(-1);
		LinkedNode ltail = dummyL;
		
		while (head != null) {
			if (head.val < k) {
				stail.next = head;
				stail = head;
			} else {
				ltail.next = head;
				ltail = head;
			}
			head = head.next;
		}
		ltail.next = null;
		stail.next = dummyL.next;
		return dummyS.next;
	}
	
	public static void main(String[] args) {
		LinkedNode node1 = new LinkedNode(3);
		LinkedNode node2 = new LinkedNode(5);
		LinkedNode node3 = new LinkedNode(8);
		LinkedNode node4 = new LinkedNode(5);
		LinkedNode node5 = new LinkedNode(10);
		LinkedNode node6 = new LinkedNode(2);
		LinkedNode node7 = new LinkedNode(1);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		
		LinkedNode temp = node1;
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		
		System.out.println();
		LinkedNode res = s1(node1, 8);
		
		temp = res;
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
	}
}
