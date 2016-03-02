import cs3500.hw02.Card;
import cs3500.hw02.Player;
import cs3500.hw02.Suit;

/**
 * Created by Kim on 2/13/2016.
 */
public class WhistPlayer extends Player {
  private int hands = 0;

  /**
   * player's number
   */
  public WhistPlayer(int value) {
    super(value);
  }

  /**
   * adds a won hand
   */
  public void addHand() {
    hands++;
  }

  /**
   * @return the number of hands
   */
  public int getHands() {
    return hands;
  }

  public boolean hasSuit(Suit s) {
    for (int i = 0; i < cards.size(); i++) {
      if (cards.get(i).getSuit().equals(s)) {
        return true;
      }
    }
    return false;
  }

  /**
   *
   * @param i index of card
   * @return card
   */
  public Card getCard(int i) { return cards.get(i); }
}
