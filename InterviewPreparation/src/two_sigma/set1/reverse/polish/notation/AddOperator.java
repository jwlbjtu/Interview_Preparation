package two_sigma.set1.reverse.polish.notation;

import java.util.ArrayList;

public class AddOperator extends Operator{

	public AddOperator() {
		super(2);
	}
	
	public int cal(ArrayList<Integer> list) {
		if (list == null || list.size() < super.numOfOperands) {
			throw new IllegalArgumentException("Not enough elements");
		}
		
		int num1 = list.get(1);
		int num2 = list.get(0);
		
		return num1 + num2;
	}
}
