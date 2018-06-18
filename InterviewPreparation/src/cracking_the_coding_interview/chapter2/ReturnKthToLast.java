package cracking_the_coding_interview.chapter2;

import cracking_the_coding_interview.LinkedNode;

public class ReturnKthToLast {

	public static LinkedNode s1(LinkedNode head, int k) {
		if (head == null) return head;
		LinkedNode runner = head;
		/*int i = 1;
		while (runner != null && i < k) {
			runner = runner.next;
			i++;
		}
		if (runner == null) return null;*/
		for (int i = 1; i < k; i++) {
			if (runner == null) return null;
			runner = runner.next;
		}
		
		LinkedNode cur = head;
		while (runner.next != null) {
			cur = cur.next;
			runner = runner.next;
		}
		return cur;
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
		
		
		System.out.println(s1(node1, 1).val);
		System.out.println(s1(node1, 5).val);
		System.out.println(s1(node1, 3).val);
		System.out.println(s1(node1, 4).val);
	}
}
