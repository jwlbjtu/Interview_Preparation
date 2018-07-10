package cracking_the_coding_interview.chapter7.deck_of_cards;

public abstract class Card {
	private boolean available;
	protected int faceValue;
	protected Suite suite;
	
	public Card(int v, Suite s) {
		faceValue = v;
		suite = s;
	}
	
	public abstract int getValue();
	public Suite suite() {return suite;}
	
	public boolean getAvailable() {return available;}
	public void markAvailable() {available = true;}
	public void markUnavailable() {available = false;}
}
