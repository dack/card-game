package cs3500.hw02;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Kim on 1/30/2016.
 */
public class GenericStandardDeckGameTest {

  GenericStandardDeckGame game = new GenericStandardDeckGame();
  List<Card> deck = game.getDeck();

  //tests if getDeck() returns a valid deck
  @Test
  public void testGetDeck() throws Exception {
    String[] a = {"2♣", "2♦", "2♥", "2♠", "3♣", "3♦", "3♥", "3♠",
            "4♣", "4♦", "4♥", "4♠", "5♣", "5♦",
            "5♥", "5♠", "6♣", "6♦", "6♥", "6♠", "7♣", "7♦", "7♥", "7♠",
            "8♣", "8♦", "8♥", "8♠", "9♣",
            "9♦", "9♥", "9♠", "10♣", "10♦", "10♥", "10♠", "J♣", "J♦",
            "J♥", "J♠", "Q♣", "Q♦", "Q♥",
            "Q♠", "K♣", "K♦", "K♥", "K♠", "A♣", "A♦", "A♥", "A♠"};
    List<String> outcome = new ArrayList<String>(Arrays.asList(a));
    List<String> deckStr = new ArrayList<String>();
    for (int i = 0; i < deck.size(); i++) {
      deckStr.add(deck.get(i).toString());
    }
    assertEquals(outcome, deckStr);
  }

  //returns true for a valid deck
  @Test
  public void testCheckDeck() throws Exception {
    assertEquals(true, game.checkDeck(deck));
  }

  //returns false for an invalid deck
  @Test
  public void testCheckDeck1() throws Exception {
    List<Card> badDeck = new ArrayList<Card>();
    for (int s = 2; s < 4; s++) {
      for (int v = 2; v < 10; v++) {
        Card c = new Card(v, s);
        badDeck.add(c);
      }
    }
    assertEquals(false, game.checkDeck(badDeck));
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
  public void testGetGameState() throws Exception {
    game.startPlay(3, deck);
    assertEquals("Number of players: 2\n" +
            "Player 0: A♠, Q♠, 10♠, 8♠, 6♠, 4♠, 2♠, K♥, J♥, 9♥, 7♥, " +
            "5♥, 3♥, A♦, Q♦, 10♦, 8♦, 6♦, 4♦, 2♦, K♣, J♣, 9♣, 7♣, 5♣, 3♣\n" +
            "Player 1: K♠, J♠, 9♠, 7♠, 5♠, 3♠, A♥, Q♥, 10♥, 8♥, 6♥, 4♥, 2♥, " +
            "K♦, J♦, 9♦, 7♦, 5♦, 3♦, A♣, Q♣, 10♣, 8♣, 6♣, 4♣, 2♣\n", game.getGameState());
  }
}