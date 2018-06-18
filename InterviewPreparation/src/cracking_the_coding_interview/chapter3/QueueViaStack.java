package cracking_the_coding_interview.chapter3;

import java.util.Stack;

public class QueueViaStack {
	private Stack<Integer> newStack;
	private Stack<Integer> oldStack;
	
	public QueueViaStack() {
		newStack = new Stack<Integer>();
		oldStack = new Stack<Integer>();
	}
	
	public int size() {
		return newStack.size() + oldStack.size();
	}
	
	public boolean isEmpty() {
		return newStack.isEmpty() && oldStack.isEmpty();
	}
	
	private void shiftElements() {
		if (oldStack.isEmpty()) {
			while(!newStack.isEmpty()) {
				oldStack.push(newStack.pop());
			}
		}
	}
	
	public int poll() {
		shiftElements();
		return oldStack.pop();
	}
	
	public int peek() {
		shiftElements();
		return oldStack.peek();
	}
}
