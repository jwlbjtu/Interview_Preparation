package two_sigma.set1.reverse.polish.notation;

public class OperationFactory {

	private AddOperator addOperator;
	private SubstractOperator subOperator;
	private MultiplyOperator mulOperator;
	private DividOperator dividOperator;
	
	public OperationFactory() {
		addOperator = new AddOperator();
		subOperator = new SubstractOperator();
		mulOperator = new MultiplyOperator();
		dividOperator = new DividOperator();
	}
	
	public Token processToken(String token) {
		switch(token) {
			case "+":
				return addOperator;
			case "-" :
				return subOperator;
			case "*" :
				return mulOperator;
			case "/" :
				return dividOperator;
			default :
				return new Operand(Integer.parseInt(token));
		}
	}
}
