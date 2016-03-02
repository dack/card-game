import org.junit.Test;

import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import cs3500.hw02.Card;

import static org.junit.Assert.*;

/**
 * Created by Kim on 2/13/2016.
 */
public class WhistModelTest {
  WhistModel game = new WhistModel();
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


  @Test (expected=IllegalArgumentException.class)
  public void testPlay() throws Exception {
    game.play(0, 6);
  }

  @Test
  public void testGetCurrentPlayer() throws Exception {
    game.currentPlayer = 0;
    assertEquals(1, game.getCurrentPlayer());
  }

  @Test
  public void testIsGameOver() throws Exception {
    game.players.clear();
    assertEquals(true, game.isGameOver());
  }

}