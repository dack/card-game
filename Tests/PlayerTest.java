package cs3500.hw02;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Kim on 1/30/2016.
 */
public class PlayerTest {
  Player p = new Player(1);

  @Test
  public void testAddCard() throws Exception {
    Card c = new Card(2, 1);
    p.addCard(c);
    assertEquals(1, p.getNumCards());
  }

  @Test
  public void testGetValue() throws Exception {
    assertEquals("Player 1", p.getValue());
  }

  @Test
  public void testGetCards() throws Exception {
    assertEquals("", p.getCards());
  }

  @Test
  public void testGetCards2() throws Exception {
    Card c = new Card(2, 1);
    p.addCard(c);
    assertEquals("2♣", p.getCards());
  }
}