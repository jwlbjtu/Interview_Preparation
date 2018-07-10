package two_sigma.set1.reverse.polish.notation;

import java.util.ArrayList;

public class MultiplyOperator extends Operator{
	public MultiplyOperator() {
		super(2);
	}
	
	public int cal(ArrayList<Integer> list) {
		int firstNum = list.get(1);
		int secNum = list.get(0);
		return firstNum * secNum;
	}
}
