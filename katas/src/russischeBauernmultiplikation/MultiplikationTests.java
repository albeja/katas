package russischeBauernmultiplikation;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MultiplikationTests {
	private RussischeMultiplikation rechner;
	
	@Before
	public void setUp() throws Exception {
		rechner = new RussischeMultiplikation();
	}

	@Test
	public void test() {
		Ergebnis expectedErgebnis = new Ergebnis();
		
		List<int[]> zahlenReihe = new ArrayList<int[]>();
		zahlenReihe.add(new int[]{47,42});
		zahlenReihe.add(new int[]{23,84});
		zahlenReihe.add(new int[]{11,168});
		zahlenReihe.add(new int[]{5,336});
		zahlenReihe.add(new int[]{2,672});
		zahlenReihe.add(new int[]{1,1344});
		
		expectedErgebnis.setErgebnis(1974);
		expectedErgebnis.setZahlen(zahlenReihe);

		assertTrue(rechner.mul(47, 42).equals(expectedErgebnis));
	}

}
