import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import cs3500.hw02.Card;
import cs3500.hw02.Suit;
import cs3500.hw03.WhistModel;

import static org.junit.Assert.*;

/**
 * Created by Kim on 2/24/2016.
 */
public class TrumpModelTest {

	TrumpModel game = new TrumpModel();
	List<Card> deck = game.getDeck();
	@Test
	public void testGetDeck() throws Exception {
		String[] a = {"2♣", "2♦", "2♥", "2♠", "3♣", "3♦", "3♥", "3♠", "4♣", "4♦",
				"4♥", "4♠", "5♣", "5♦",
				"5♥", "5♠", "6♣", "6♦", "6♥", "6♠", "7♣", "7♦",
				"7♥", "7♠", "8♣", "8♦", "8♥", "8♠", "9♣",
				"9♦", "9♥", "9♠", "10♣", "10♦", "10♥", "10♠", "J♣",
				"J♦", "J♥", "J♠", "Q♣", "Q♦", "Q♥",
				"Q♠", "K♣", "K♦", "K♥", "K♠", "A♣", "A♦", "A♥", "A♠"};
		List<String> outcome = new ArrayList<String>(Arrays.asList(a));
		List<String> deckStr = new ArrayList<String>();
		for (int i = 0; i < deck.size(); i++) {
			deckStr.add(deck.get(i).toString());
		}
		assertEquals(outcome, deckStr);
	}

	//test if startPlay() throws exception when players are 0
	@Test (expected=IllegalArgumentException.class)
	public void testStartPlay() throws Exception {
		game.startPlay(0, deck);
	}

	//test if startPlay() throws exception when players are -1
	@Test (expected=IllegalArgumentException.class)
	public void testStartPlay1() throws Exception {
		game.startPlay(-1, deck);
	}

	//test if startPlay() throws exception when players are 1
	@Test (expected=IllegalArgumentException.class)
	public void testStartPlay2() throws Exception {
		game.startPlay(1, deck);
	}

	@Test
	public void testTrump() throws Exception {
		game.startPlay(2, deck);
		assertEquals(Suit.CLUBS, game.getTrumpSuit());
	}

	
}