package two_sigma.set1.reverse.polish.notation;

import java.util.ArrayList;

public class DividOperator extends Operator{
	public DividOperator() {
		super(2);
	}
	
	public int cal(ArrayList<Integer> list) {
		int firstNum = list.get(1);
		int secNum = list.get(0);
		double res = (double)firstNum / (double)secNum;
		if (res > Integer.MAX_VALUE) {
            throw new ArithmeticException("Integer value overflow");
        }
        if (res < Integer.MIN_VALUE) {
            throw new ArithmeticException("Integer value underflow");
        }
        return (int)res;
	}
}
