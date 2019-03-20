package dubletten;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dubletten.IDublettenpruefung.IDublette;

public class DublettenpruefungTest {
	IDublettenpruefung cut;
	
	@Before
	public void setUp() throws Exception {
		cut = new Dublettenpruefung();
	}

	@Test
	public void testSammleKandidaten() {
		List<IDublette> kandidaten = cut.sammle_kandidaten("C:\\Users\\jvonalbedyll\\eclipse-workspace");
		List<String> dateipfade = new ArrayList<String>();
		dateipfade.add("C:\\Users\\jvonalbedyll\\eclipse-workspace\\demo.txt");
		dateipfade.add("C:\\Users\\jvonalbedyll\\eclipse-workspace\\katas\\demo.txt");
		
		assertEquals(1, kandidaten.size());
		assertEquals(dateipfade.get(0), kandidaten.get(0).getDateipfade().get(0));
		assertEquals(dateipfade.get(1), kandidaten.get(0).getDateipfade().get(1));
	}

}