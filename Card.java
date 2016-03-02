/**
 * Created by Kim on 1/30/2016.
 */
public class Card implements Comparable<Card> {
  private Value value;
  private Suit suit;

  /**
   *
   * @param v
   * @param s
   */
  public Card(Value v, Suit s) {
    this.value = v;
    this.suit = s;
  }

  public Card(int v, int s) {
    this.value = Value.values()[v];
    this.suit = Suit.values()[s];
  }

  /**
   *
   * @return value
   */
  public Value getValue() { return value; }

  /**
   *
   * @return suit
   */
  public Suit getSuit() {
    return suit;
  }

  /**
   *
   * @return string value
   */
  public String displayValue() {
    switch (value) {
      case TWO:
        return "2";
      case THREE:
        return "3";
      case FOUR:
        return "4";
      case FIVE:
        return "5";
      case SIX:
        return "6";
      case SEVEN:
        return "7";
      case EIGHT:
        return "8";
      case NINE:
        return "9";
      case TEN:
        return "10";
      case JACK:
        return "J";
      case QUEEN:
        return "Q";
      case KING:
        return "K";
      case ACE:
        return "A";
      default:
        return null;
    }
  }

  /**
   *
   * @return string suit
   */
  public String displaySuit () {
    switch (suit) {
      case CLUBS:
        return "♣";
      case DIAMONDS:
        return "♦";
      case HEARTS:
        return "♥";
      case SPADES:
        return "♠";
      default:
        return null;
    }
  }

  /**
   *
   * @return string rep of card
   */
  public String toString() {
    String valueStr = displayValue();
    String suitStr = displaySuit();

    return valueStr + suitStr;
  }

  /**
   *
   * @param other
   * @return the value 0 if this == other ;
   * a value less than 0 if this < other;
   * and a value greater than 0 if this > other
   */
  @Override
  public int compareTo(Card other) {
    if (!(other instanceof Card)) {
      throw new ClassCastException("A card object expected.");
    }

    int valueComp = Integer.compare(this.getValue().value, other.getValue().value);
    int suitComp = Integer.compare(this.getSuit().value, other.getSuit().value);
    //if suits are the same, compare values
    if (suitComp == 0) {
      return valueComp * -1;
    }

    return suitComp;
  }
}
