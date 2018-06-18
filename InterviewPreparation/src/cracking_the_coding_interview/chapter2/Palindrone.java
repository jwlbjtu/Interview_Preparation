package cracking_the_coding_interview.chapter2;

import java.util.Stack;

import cracking_the_coding_interview.LinkedNode;

public class Palindrone {

	public static boolean s1(LinkedNode head) {
		if (head == null) return false;
		LinkedNode dummy = null;
		LinkedNode node = head;
		while (node != null) {
			LinkedNode n = new LinkedNode(node.val);
			n.next = dummy;
			dummy = n;
			node = node.next;
		}
		while (head != null && dummy != null) {
			if (head.val != dummy.val) {
				return false;
			}
			head = head.next;
			dummy = dummy.next;
		}
		return head == null && dummy == null;
	}
	
	public static boolean s2(LinkedNode head) {
		if (head == null) return false;
		
		LinkedNode fast = head;
		LinkedNode slow = head;
		Stack<Integer> stack = new Stack<Integer>();
		while (fast != null && fast.next != null) {
			stack.push(slow.val);
			fast = fast.next.next;
			slow = slow.next;
		}
		
		if (fast != null) {
			slow = slow.next;
		}
		
		while (slow != null && !stack.isEmpty()) {
			int val = stack.pop().intValue();
			if (slow.val != val) {
				return false;
			}
			
			slow = slow.next;
		}
		
		return slow == null && stack.isEmpty();
	}
	
	public static void main(String[] args) {
		LinkedNode node1 = new LinkedNode(1);
		LinkedNode node2 = new LinkedNode(2);
		LinkedNode node3 = new LinkedNode(3);
		LinkedNode node4 = new LinkedNode(4);
		LinkedNode node5 = new LinkedNode(5);
		LinkedNode node6 = new LinkedNode(4);
		LinkedNode node7 = new LinkedNode(3);
		LinkedNode node8 = new LinkedNode(2);
		LinkedNode node9 = new LinkedNode(0);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		node8.next = node9;
		
		LinkedNode temp = node1;
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		
		System.out.println(s1(node1));
		
		LinkedNode node10 = new LinkedNode(1);
		LinkedNode node11 = new LinkedNode(2);
		LinkedNode node12 = new LinkedNode(3);
		LinkedNode node13 = new LinkedNode(4);
		LinkedNode node14 = new LinkedNode(4);
		LinkedNode node15 = new LinkedNode(3);
		LinkedNode node16 = new LinkedNode(3);
		LinkedNode node17 = new LinkedNode(1);
		node10.next = node11;
		node11.next = node12;
		node12.next = node13;
		node13.next = node14;
		node14.next = node15;
		node15.next = node16;
		node16.next = node17;
		
		System.out.println();
		
		temp = node10;
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		
		System.out.println(s2(node10));
	}
}
