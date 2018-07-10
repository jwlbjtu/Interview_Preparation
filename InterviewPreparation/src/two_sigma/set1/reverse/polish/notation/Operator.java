package two_sigma.set1.reverse.polish.notation;

import java.util.ArrayList;
import java.util.Stack;

public abstract class Operator implements Token{

	protected int numOfOperands;
	
	protected Operator(int num) {
		numOfOperands = num;
	}
	
	public void process(Stack<Integer> stack) {
		if (stack == null) {
			throw new IllegalArgumentException("Stack cannot be null");
		}
		
		if (stack.size() < numOfOperands) {
			throw new IllegalArgumentException("Not enough elements in stack");
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < numOfOperands; i++) {
			list.add(stack.pop());
		}
		
		stack.push(cal(list));
	}
	
	public abstract int cal(ArrayList<Integer> list);
}
