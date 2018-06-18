package cracking_the_coding_interview.chapter3;

import java.util.Stack;

public class SortStack {

	public static void sort(Stack<Integer> stack) {
		Stack<Integer> s2 = new Stack<Integer>();
		while (!stack.isEmpty()) {
			int tmp = stack.pop();
			while (!s2.isEmpty() && s2.peek() > tmp) {
				stack.push(s2.pop());
			}
			s2.push(tmp);
		}
		
		while (!s2.isEmpty()) {
			stack.push(s2.pop());
		}
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(12);
		stack.push(3);
		stack.push(8);
		stack.push(10);
		stack.push(1);
		stack.push(10);
		
		Stack<Integer> temp = (Stack<Integer>)stack.clone();
		while (!temp.isEmpty()) {
			System.out.println(temp.pop());
		}
		
		sort(stack);
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
}
