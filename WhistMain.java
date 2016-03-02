import java.io.Reader;
import java.io.StringReader;
import java.util.List;

import cs3500.hw02.Card;

/**
 * Created by Kim on 2/13/2016.
 */
public class WhistMain {
  public static void main(String[] args) {
    CardGameModel model = new WhistModel();
    String input = "2 1 2 1 2 1 2 1 2 1 2 1 1 1";
    Reader in = new StringReader(input);
    StringBuffer out = new StringBuffer();
    IWhistController controller = new WhistController(in, out);
    controller.startGame(model, 2);
    System.out.print(out);
  }
}
