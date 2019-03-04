package froehlicheZahl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FroehlicheZahlCalculatorTest {
	private FroehlicheZahlCalculator calculator = new FroehlicheZahlCalculator();
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void isFroehlicheZahlTrue() {
		assertTrue(calculator.isFroehlicheZahl(1));
		assertTrue(calculator.isFroehlicheZahl(10));
		assertTrue(calculator.isFroehlicheZahl(19));
		assertTrue(calculator.isFroehlicheZahl(49));
		assertTrue(calculator.isFroehlicheZahl(97));
		assertTrue(calculator.isFroehlicheZahl(100));
	}
	
	@Test
	public void isFroehlicheZahlFalse() {
		assertFalse(calculator.isFroehlicheZahl(2));
		assertFalse(calculator.isFroehlicheZahl(12));
		assertFalse(calculator.isFroehlicheZahl(20));
		assertFalse(calculator.isFroehlicheZahl(50));
		assertFalse(calculator.isFroehlicheZahl(99));
	}

}
