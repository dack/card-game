package cs3500.hw03;

/**
 * Created by Kim on 2/13/2016.
 */
public interface IWhistController {
  /**
   * Start the provided game w/ the provided num players
   * return only after the game has ended
   * @param game
   * @param numPlayers
   * @param <K>
   */
  <K> void startGame(CardGameModel<K> game, int numPlayers);

}
