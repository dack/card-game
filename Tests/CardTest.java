package cs3500.hw02;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Kim on 1/30/2016.
 */
public class CardTest {
  Card c = new Card(2, 3);
  @Test
  public void testGetValue() throws Exception {
    assertEquals(2, c.getValue());
  }

  @Test
  public void testGetSuit() throws Exception {
    assertEquals(3, c.getSuit());
  }

  @Test
  public void testGetValue1() throws Exception {
    assertEquals("Q", c.displayValue());
  }

  @Test
  public void testGetSuit1() throws Exception {
    assertEquals("♣", c.displaySuit());
  }

  @Test
  public void testToString() throws Exception {
    assertEquals("2♥", c.toString());
  }
}