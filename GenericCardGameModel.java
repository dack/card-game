package cs3500.hw02;

import java.util.List;

/**
 * Created by Kim on 1/30/2016.
 */
public interface GenericCardGameModel<K> {
  /**
   * 52 cards with 2, ..., jack, queen, king, ace in each of clubs, diamonds, hearts and spades
   * @return a deck of cards
   */
  List<K> getDeck();

  /**
   * distributes cards in order among players
   * @param numPlayers
   * @param deck
   * @throws IllegalArgumentException if plavers < 1 or invalid deck
   */
  void startPlay(int numPlayers, List<K> deck);

  /**
   * @return a string that contains the entire state of the game
   */
  String getGameState();

}
