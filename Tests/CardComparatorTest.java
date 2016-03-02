import org.junit.Test;
import cs3500.hw02.Card;
import cs3500.hw02.Suit;
import cs3500.hw02.Value;
import static org.junit.Assert.*;

/**
 * Created by Kim on 2/24/2016.
 */
public class CardComparatorTest {

  @Test
  public void testCompare() throws Exception {
	  Card ace_spades = new Card(Value.ACE, Suit.SPADES);
	  Card king_spades = new Card(Value.KING, Suit.SPADES);
	  CardComparator c = new CardComparator();
	  
	  assertEquals(1, c.compare(ace_spades, king_spades));
  }
  
  @Test
  public void testCompare1() throws Exception {
	  Card ace_spades = new Card(Value.ACE, Suit.SPADES);
	  Card king_spades = new Card(Value.KING, Suit.SPADES);
	  CardComparator c = new CardComparator();
	  
	  assertEquals(-1, c.compare(king_spades, ace_spades));
  }
  
  @Test
  public void testCompare2() throws Exception {
	  Card ace_spades = new Card(Value.ACE, Suit.SPADES);
	  Card ace_clubs = new Card(Value.ACE, Suit.CLUBS);
	  CardComparator c = new CardComparator();
	  
	  assertEquals(-1, c.compare(ace_clubs, ace_spades));
  }
  
  @Test
  public void testCompare3() throws Exception {
	  Card ace_spades = new Card(Value.ACE, Suit.SPADES);
	  CardComparator c = new CardComparator();
	  
	  assertEquals(0, c.compare(ace_spades, ace_spades));
  }
}