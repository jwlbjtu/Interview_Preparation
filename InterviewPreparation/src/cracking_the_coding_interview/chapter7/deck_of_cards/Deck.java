package cracking_the_coding_interview.chapter7.deck_of_cards;

import java.util.*;

public class Deck <T extends Card>{
	private ArrayList<T> cards;
	private int dealtIndex = 0;
	
	public void setCards(ArrayList<T> setOfCards) {
		cards = setOfCards;
	}
	
	public void shuffle() {}
	public int remainingCards() {
		return cards.size() - dealtIndex;
	}
	public T[] dealHand(int num) {return null;}
	public T dealCard() {return null;}
}
