package two_sigma.set1.reverse.polish.notation;

import java.util.Stack;

public class Calculator {
	private Stack<Integer> stack;
	
	public Calculator() {
		stack = new Stack<Integer>();
	}
	
	public int calculate(String input) {
		if (input == null || input.length() == 0) {
			throw new IllegalArgumentException("Input cannot be empty");
		}
		
		String[] tokens = input.split(" ");
		OperationFactory of = new OperationFactory();
		for (String t : tokens) {
			of.processToken(t).process(stack);
		}
		if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid Reverse Polish Notation Provided");
        }
		return stack.pop();
	}
}
