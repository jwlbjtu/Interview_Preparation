package cracking_the_coding_interview.chapter3;

import java.util.*;

class SetOfStacks {
	private int capacity;
	private List<Stack<Integer>> list;
	
	public SetOfStacks(int capacity) {
		this.capacity = capacity;
		list = new ArrayList<Stack<Integer>>();
	}
	
	private Stack<Integer> getLastStack() {
		if (list.size() == 0) {
			Stack<Integer> stack = new Stack<Integer>();
			list.add(stack);
		}
		while (list.get(list.size() - 1).isEmpty()) {
			list.remove(list.size() - 1);
		}
		return list.get(list.size() - 1);
	}
	
	public void push(int num) {
		Stack<Integer> stack = getLastStack();
		stack.push(num);
		if (stack.size() == capacity) {
			Stack<Integer> s = new Stack<Integer>();
			list.add(s);
		}
	}
	
	public int pop() {
		Stack<Integer> stack = getLastStack();
		int res = stack.pop();
		if (stack.isEmpty()) {
			list.remove(list.size() - 1);
		}
		return res;
	}
	
	public int popAt(int index) {
		if (index >= list.size()) return -1;
		Stack<Integer> stack = list.get(index);
		return stack.pop();
	}
}

public class StackOfPlates {
	
}
