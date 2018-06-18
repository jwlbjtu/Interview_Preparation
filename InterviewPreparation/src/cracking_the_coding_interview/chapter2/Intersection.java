package cracking_the_coding_interview.chapter2;

import cracking_the_coding_interview.LinkedNode;

class Result {
	int size;
	LinkedNode tail;
}

public class Intersection {

	public static LinkedNode s1(LinkedNode head1, LinkedNode head2) {
		Result rt1 = tailSize(head1);
		Result rt2 = tailSize(head2);
		
		if (rt1.tail != rt2.tail) {
			return null;
		}
		
		LinkedNode shorter = rt1.size > rt2.size ? head2 : head1;
		LinkedNode longer = rt1.size > rt2.size ? head1 : head2;
		
		for (int i = 0; i < Math.abs(rt1.size - rt2.size); i++) {
			longer = longer.next;
		}
		
		while (shorter != longer) {
			shorter = shorter.next;
			longer = longer.next;
		}
		
		return longer;
	}
	
	private static Result tailSize(LinkedNode head) {
		int size = 0;
		LinkedNode node = head;
		while (node != null && node.next != null) {
			size++;
			node = node.next;
		}
		Result rt = new Result();
		rt.size = size + 1;
		rt.tail = node;
		return rt;
	}
	
	public static void main(String[] args) {
		LinkedNode node1 = new LinkedNode(1);
		LinkedNode node2 = new LinkedNode(2);
		LinkedNode node3 = new LinkedNode(3);
		
		LinkedNode node5 = new LinkedNode(5);
		
		LinkedNode node6 = new LinkedNode(4);
		LinkedNode node7 = new LinkedNode(3);
		LinkedNode node8 = new LinkedNode(2);
		LinkedNode node9 = new LinkedNode(0);
		node1.next = node2;
		node2.next = node3;
		node3.next = node6;

		node5.next = node6;
		
		node6.next = node7;
		node7.next = node8;
		node8.next = node9;
		
		
		
		LinkedNode temp = node1;
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		
		System.out.println();
		
		temp = node5;
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		
		System.out.println();
		
		LinkedNode head = s1(node1, node5);
		
		temp = head;
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
	}
}

