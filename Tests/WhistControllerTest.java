import org.junit.Test;

import java.io.Reader;
import java.io.StringReader;
import java.util.List;

import cs3500.hw02.Card;

import static org.junit.Assert.*;

/**
 * Created by Kim on 2/24/2016.
 */
public class WhistControllerTest {

  /**
   * test that no exception is thrown
   * @throws Exception
   */
  @Test
  public void testStartGame() throws Exception {
    CardGameModel model = new WhistModel();
    String input = "2 1 2 1 2 1 2 1 2 1 2 1 1 1";
    Reader in = new StringReader(input);
    StringBuffer out = new StringBuffer();
    IWhistController controller = new WhistController(in, out);
    try {
      controller.startGame(model, 1);
    } catch (IllegalArgumentException e) {
      assertTrue(false);
    }
    assertTrue(true);
  }



  @Test
  public void testPlayer2Wins() throws Exception {
    WhistModel model2 = new WhistModel();
    String input =
            "1 0 0 1 0 0 1 0 0 1 0 0 1 0 0 1 0 0 1 0 0 1 0 0 1 0 0 1 0 0 1 0 0 1 0 0" +
            " 1 0 0 1 0 0 1 0 0 1 0 0 1 0 0 1 0 0 1 0 0 1 0 0 1 0 0 1 0 0 1 0 0 1 0 0 1 0 0 0 0";
    Reader in = new StringReader(input);
    StringBuffer out = new StringBuffer();
    IWhistController controller2 = new WhistController(in, out);
    controller2.startGame(model2, 2);
    assertEquals(2 , model2.getWinner());
  }

  @Test
  public void testPlayer1Wins() throws Exception {
    WhistModel model3 = new WhistModel();
    String input =
            "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0" +
            " 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0" +
            " 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 "
            ;
    Reader in = new StringReader(input);
    StringBuffer out = new StringBuffer();
    IWhistController controller3 = new WhistController(in, out);
    controller3.startGame(model3, 2);
    assertEquals(1 , model3.getWinner());
  }
}