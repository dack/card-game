import java.util.Comparator;

import cs3500.hw02.Card;

/**
 * Created by Kim on 2/24/2016.
 */
public class CardComparator implements Comparator {

  @Override
  public int compare(Object o1, Object o2) {
    Card c1 = (Card) o1;
    Card c2 = (Card) o2;
    int valueComp = Integer.compare(c1.getValue().value, c2.getValue().value);
    int suitComp = Integer.compare(c1.getSuit().value, c2.getSuit().value);

    //if suits are the same, compare values
    if (suitComp == 0) {
      return valueComp; //descending order
    }

    return suitComp;
  }


}
