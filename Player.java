package cs3500.hw02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Kim on 1/30/2016.
 */
public class Player {
  protected int value;
  protected List<Card> cards = new ArrayList<Card>();

  /**
   * player's number
   * @param value
   */
  public Player(int value) {
    this.value = value;
  }

  /**
   * add card to player's hand
   * @param c card
   */
  public void addCard(Card c) {
    cards.add(c);
  }

  /**
   *
   * @param i index of card to be removed
   */
  public void removeCard(int i) {cards.remove(i);}

  /**
   *
   * @return player number in int
   */
  public int getValue() { return value; }

  /**
   *
   * @return cards in player's hand
   */
  public String getCards() {
    Collections.sort(cards);
    StringBuilder sb = new StringBuilder();
    for (int i=0; i < cards.size(); i++) {
      sb.append(cards.get(i).toString());
      if (i != (cards.size() - 1)) {
        sb.append(", ");
      }
    }

    return sb.toString();
  }

  /**
   *
   * @return num cards in player's hand
   */
  public int getNumCards() {
    return cards.size();
  }


}
