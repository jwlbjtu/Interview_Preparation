package cracking_the_coding_interview.chapter2;

import cracking_the_coding_interview.LinkedNode;

public class LoopDetection {

	public static LinkedNode s1(LinkedNode head) {
		if (head == null) return null;
		LinkedNode fast = head;
		LinkedNode slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				break;
			}
		}
		if (fast == null || fast.next == null) {
			return null;
		}
		
		fast = head;
		while (slow != fast) {
			fast = fast.next;
			slow = slow.next;
		}
		
		return fast;
	}
	
	public static void main(String[] args) {
		LinkedNode node1 = new LinkedNode(1);
		LinkedNode node2 = new LinkedNode(2);
		LinkedNode node3 = new LinkedNode(3);
		LinkedNode node4 = new LinkedNode(4);
		LinkedNode node5 = new LinkedNode(5);
		LinkedNode node6 = new LinkedNode(6);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node3;
		
		LinkedNode temp = node3;
		/*while(temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}*/
		
		System.out.println();
		
		LinkedNode n = s1(node1);
		
		System.out.println(n.val);
	}
}
