package two_sigma.set1.reverse.polish.notation;

import java.util.Stack;

public class Operand implements Token{

	private int value;
	
	public Operand(int value) {
		this.value = value;
	}
	
	public void process(Stack<Integer> stack) {
		if (stack == null) {
			throw new IllegalArgumentException("Stack cannot be null");
		}
		stack.push(value);
	}
}
