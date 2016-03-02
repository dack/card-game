import java.util.List;

import cs3500.hw02.GenericCardGameModel;

/**
 * Created by Kim on 1/30/2016.
 */
public interface CardGameModel<K> extends GenericCardGameModel<K> {
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

  /**
   * Plays card at index in the set of cards for player
   * assumes that player numbers and card indices begin with 0 and hands are sorted
   * @param playerNo player
   * @param cardIdx index of card
   */
  void play(int playerNo, int cardIdx);

  /**
   *
   * @return the player whose turn it is to play
   */
  int getCurrentPlayer();

  /**
   *
   * @return if game is over true, else false
   */
  boolean isGameOver();

}
