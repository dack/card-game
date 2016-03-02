import cs3500.hw03.CardGameModel;
import cs3500.hw03.WhistModel;

/**
 * Created by Kim on 2/24/2016.
 */
public class WhistModelCreator {

  public enum ModelType { TRUMP, NOTRUMP; }

  public static CardGameModel create(ModelType type) {
    if (type == ModelType.TRUMP) return new TrumpModel();
    if (type == ModelType.NOTRUMP) return new WhistModel();
    return null;
  }
}
