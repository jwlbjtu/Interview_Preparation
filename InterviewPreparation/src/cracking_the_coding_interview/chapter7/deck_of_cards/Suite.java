package cracking_the_coding_interview.chapter7.deck_of_cards;

public enum Suite {
	Club(0), Diamon(1), Heart(2), Spade(3);
	private int value;
	private Suite(int v) {value = v;}
	public int getValue() {return value;}
	public Suite getSuiteFromValue(int value) {return null;}
}
