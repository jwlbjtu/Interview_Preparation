package two_sigma.set1;

import static org.junit.Assert.*;

import org.junit.Test;

import two_sigma.set1.reverse.polish.notation.Calculator;

public class ReversePolishNotationCalculator {

	@Test
	public void testCalculate() {
		Calculator c = new Calculator();
		assertEquals(9, c.calculate("2 1 + 3 *"));
		assertEquals(6, c.calculate("4 13 5 / +"));
		assertEquals(22, c.calculate("10 6 9 3 + -11 * / * 17 + 5 +"));
	}

}
