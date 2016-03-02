import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Kim on 2/13/2016.
 */
public class WhistController implements IWhistController {
  public final Readable in;
  public final Appendable out;

  public WhistController(Readable rd, Appendable ap) {
    this.in = rd;
    this.out = ap;
  }
  /**
   * Start the provided game w/ the provided num players
   * return only after the game has ended
   * @param game
   * @param numPlayers
   * @param <K>
   */
  public <K> void startGame(CardGameModel<K> game, int numPlayers){
    if (game instanceof CardGameModel){
      List<K> deck = game.getDeck();
      Scanner scan = new Scanner(this.in);
      String in = "";
      try {
        game.startPlay(numPlayers, deck);
      } catch (IllegalArgumentException e) {
        try {
          this.out.append("Please check your number of players and/or deck.");
        } catch (IOException e1) {
          e1.printStackTrace();
        }
      }
      while (!game.isGameOver() && scan.hasNext()) {
        int cardIndex = 0;
        try {
          this.out.append(game.getGameState() + '\n');
        } catch (IOException e) {
          e.printStackTrace();
        }
        if (scan.hasNext()) {
          in = scan.next();
        }
        try {
          cardIndex = Integer.parseInt(in);
        } catch (NumberFormatException e) {
          try {
            this.out.append("Try again, that was invalid input: " + e + '\n');
          } catch (IOException e1) {
            e1.printStackTrace();
          }
          continue;
        }
        try {
          game.play(game.getCurrentPlayer(), cardIndex);
        } catch (IllegalArgumentException e) {
          try {
            this.out.append("Invalid index " + cardIndex + ". " +  e.getMessage() + '\n');
          } catch (IOException e1) {
            e1.printStackTrace();
          }
        }
      }
      try {
        this.out.append(game.getGameState() + '\n');
      } catch (IOException e) {
        e.printStackTrace();
      }

    }
  }
}
