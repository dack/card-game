package cs3500.hw02;

/**
 * Created by Kim on 2/13/2016.
 */
public enum Suit {
  CLUBS(1), DIAMONDS(2), HEARTS(3), SPADES(4);
  public final int value;

  Suit(int v) {
    this.value = v;
  }
}
