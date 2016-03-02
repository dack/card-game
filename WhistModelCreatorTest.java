import static org.junit.Assert.*;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Test;

import cs3500.hw03.WhistModel;
import cs3500.hw04.WhistModelCreator.ModelType;

public class WhistModelCreatorTest {

	@Test
	public void testCreateTrump() {
		WhistModelCreator a = new WhistModelCreator();
		boolean b = a.create(ModelType.TRUMP).getClass() == TrumpModel.class;
		assertTrue(b);
	}
	
	@Test
	public void testCreateWhist() {
		WhistModelCreator c = new WhistModelCreator();
		boolean b = c.create(ModelType.NOTRUMP).getClass() == WhistModel.class;
		assertTrue(b);
	}

}
