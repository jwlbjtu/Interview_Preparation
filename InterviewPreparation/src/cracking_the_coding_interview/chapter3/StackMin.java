package cracking_the_coding_interview.chapter3;

import java.util.Stack;

class MinStack {
	private Stack<Integer> stack;
	private Stack<Integer> minStack;
	
	public MinStack() {
		stack = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}
	
	public void push(int num) {
		if (minStack.isEmpty() || num <= min()) {
			minStack.push(num);
		}
		stack.push(num);
	}
	
	public int pop() {
		if (stack.peek() == minStack.peek()) {
			minStack.pop();
		}
		return stack.pop();
	}
	
	public int min() {
		if (minStack.isEmpty()) {
			return -1;
		}
		return minStack.peek();
	}
}

public class StackMin {
	
	public static void main(String[] args) {
		MinStack ms = new MinStack();
		ms.push(6);;
		System.out.println(ms.min());
		ms.push(7);
		ms.push(8);
		System.out.println(ms.min());
		ms.push(2);
		System.out.println(ms.min());
		ms.pop();
		System.out.println(ms.min());
		ms.pop();
		System.out.println(ms.min());
	}
}
