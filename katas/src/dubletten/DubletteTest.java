package dubletten;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DubletteTest {
	Dublette dublette;
	
	@Before
	public void setUp() throws Exception {
		dublette = new Dublette();
	}

	@Test
	public void testAddGetPfade() {
		dublette.addDateipfad("pfad1");
		dublette.addDateipfad("pfad2");
		
		assertEquals("pfad1", dublette.getDateipfade().get(0));
		assertEquals("pfad2", dublette.getDateipfade().get(1));
	}

}
