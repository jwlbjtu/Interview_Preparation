package cracking_the_coding_interview.chapter2;

import cracking_the_coding_interview.LinkedNode;

class ResType {
	LinkedNode node;
	int carry;
	public ResType(LinkedNode node, int carry) {
		this.node = node;
		this.carry = carry;
	}
}

public class SunList {

	public static LinkedNode reverse(LinkedNode head1, LinkedNode head2) {
		LinkedNode dummy = new LinkedNode(-1);
		LinkedNode temp = dummy;
		boolean carry = false;
		
		while (head1 != null && head2 != null) {
			int sum = head1.val + head2.val;
			if (carry) {
				sum += 1;
				carry = false;
			}
			if (sum / 10 != 0) {
				carry = true;
			}
			int val = sum % 10;
			LinkedNode newN = new LinkedNode(val);
			temp.next = newN;
			temp = newN;
			head1 = head1.next;
			head2 = head2.next;
		}
		
		while (head1 != null) {
			int sum = head1.val;
			if (carry) {
				sum += 1;
				carry = false;
			}
			if (sum / 10 != 0) {
				carry = true;
			}
			int val = sum % 10;
			LinkedNode newN = new LinkedNode(val);
			temp.next = newN;
			temp = newN;
			head1 = head1.next;
		}
		
		while (head2 != null) {
			int sum = head2.val;
			if (carry) {
				sum += 1;
				carry = false;
			}
			if (sum / 10 != 0) {
				carry = true;
			}
			int val = sum % 10;
			LinkedNode newN = new LinkedNode(val);
			temp.next = newN;
			temp = newN;
			head2 = head2.next;
		}
		
		if (carry) {
			LinkedNode newN = new LinkedNode(1);
			temp.next = newN;
		}
		return dummy.next;
	}
	
	public static LinkedNode addList(LinkedNode head1, LinkedNode head2, int carry) {
		if (head1 == null && head2 == null && carry == 0) {
			return null;
		}
		int sum = carry;
		if (head1 != null) {
			sum += head1.val;
		}
		if (head2 != null) {
			sum += head2.val;
		}
		
		int val = sum % 10;
		LinkedNode newNode = new LinkedNode(val);
		
		if (head1 != null || head2 != null) {
			LinkedNode res = addList(head1 == null ? null : head1.next,
									head2 == null ? null : head2.next,
									sum < 10 ? 0 : 1);
			newNode.next = res;
		}
		return newNode;
	}
	
	public static LinkedNode forward(LinkedNode head1, LinkedNode head2) {
		int len1 = length(head1);
		int len2 = length(head2);
		
		if (len1 < len2) {
			head1 = addPadding(head1, len2 - len1);
		} else if (len2 < len1) {
			head2 = addPadding(head2, len1 - len2);
		}
		
		ResType res = helper(head1, head2);
		
		if (res.carry == 0) {
			return res.node;
		} else {
			LinkedNode newN = insertFront(res.node, 1);
			return newN;
		}
	}
	
	private static ResType helper(LinkedNode head1, LinkedNode head2) {
		if (head1 == null && head2 == null) {
			return new ResType(null, 0);
		}
		
		ResType res = helper(head1.next, head2.next);
		
		int sum = res.carry + head1.val +head2.val;
		int val = sum % 10;
		LinkedNode newN = new LinkedNode(val);
		newN.next = res.node;
		int carry = sum / 10;
		
		return new ResType(newN, carry);
	}
	
	private static LinkedNode addPadding(LinkedNode head, int k) {
		for (int i = 0; i < k; i++) {
			head = insertFront(head, 0);
		}
		return head;
	}
	
	private static LinkedNode insertFront(LinkedNode head, int val) {
		LinkedNode newN = new LinkedNode(val);
		newN.next = head;
		return newN;
	}
	
	private static int length(LinkedNode head) {
		int count = 0;
		while (head != null) {
			head = head.next;
			count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		LinkedNode node1 = new LinkedNode(7);
		LinkedNode node2 = new LinkedNode(5);
		LinkedNode node3 = new LinkedNode(1);
		LinkedNode node4 = new LinkedNode(9);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		LinkedNode temp = node1;
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		
		System.out.println();
		
		LinkedNode node5 = new LinkedNode(6);
		LinkedNode node6 = new LinkedNode(9);
		LinkedNode node7 = new LinkedNode(9);
		node5.next = node6;
		node6.next = node7;
		
		temp = node5;
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		
		System.out.println();
		
		//LinkedNode head1 = reverse(node1, node5);
		LinkedNode head1 = addList(node1, node5, 0);
		
		temp = head1;
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		
		System.out.println();
		System.out.println();
		
		LinkedNode node8 = new LinkedNode(9);
		LinkedNode node9 = new LinkedNode(1);
		LinkedNode node10 = new LinkedNode(5);
		LinkedNode node11 = new LinkedNode(7);
		node8.next = node9;
		node9.next = node10;
		node10.next = node11;
		
		temp = node8;
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		
		System.out.println();
		
		LinkedNode node12 = new LinkedNode(9);
		LinkedNode node13 = new LinkedNode(9);
		LinkedNode node14 = new LinkedNode(6);
		node12.next = node13;
		node13.next = node14;
		
		temp = node12;
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		
		System.out.println();
		
		LinkedNode head2 = forward(node8, node12);
		
		temp = head2;
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		
		System.out.println();
	}
}
