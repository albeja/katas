package galgen;

import static org.junit.Assert.*;

import org.junit.Test;

public class GalgenTest {

	@Test
	public void test() {
		Galgenmännchen spiel = new Galgenmännchen("developer");
		
		assertEquals("---------", spiel.rateBuchstabe('u'));
		assertEquals("-e-e---e-", spiel.rateBuchstabe('e'));
		assertEquals("-e-e---e-", spiel.rateBuchstabe('n'));
		assertEquals("-e-e-o-e-", spiel.rateBuchstabe('o'));
		assertEquals("-e-e-o-er", spiel.rateBuchstabe('r'));
		assertEquals("-e-e-o-er", spiel.rateBuchstabe('a'));
		assertEquals("de-e-o-er", spiel.rateBuchstabe('d'));
		assertEquals("de-elo-er", spiel.rateBuchstabe('l'));
		assertEquals("de-eloper", spiel.rateBuchstabe('p'));
		assertEquals("developer", spiel.rateBuchstabe('v'));

	}

}
