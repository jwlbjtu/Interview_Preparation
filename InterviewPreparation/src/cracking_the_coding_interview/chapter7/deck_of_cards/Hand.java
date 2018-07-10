package cracking_the_coding_interview.chapter7.deck_of_cards;

import java.util.*;

public class Hand <T extends Card> {
	protected ArrayList<T> cards = new ArrayList<T>();
	
	public int score() {
		int score = 0;
		for (T card : cards) {
			score += card.getValue();
		}
		return score;
	}
	
	public void addCard(T card) {
		cards.add(card);
	}
}
