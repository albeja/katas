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
	public void testSammleKandidatenGleicheGrößeUndNamen() {
		List<IDublette> kandidaten = cut.sammleKandidaten("C:\\Users\\jvonalbedyll\\eclipse-workspace\\testdir_duplicates");
		List<String> dateipfade = new ArrayList<String>();
		dateipfade.add("C:\\Users\\jvonalbedyll\\eclipse-workspace\\testdir_duplicates\\demo_duplicate.txt");
		dateipfade.add("C:\\Users\\jvonalbedyll\\eclipse-workspace\\testdir_duplicates\\testdir\\demo_duplicate.txt");
		
		assertEquals(1, kandidaten.size());
		assertEquals(dateipfade.get(0), kandidaten.get(0).getDateipfade().get(0));
		assertEquals(dateipfade.get(1), kandidaten.get(0).getDateipfade().get(1));
	}

	@Test
	public void testSammleKandidatenGleicherNameUnterschiedlicheGröße() {
		List<IDublette> kandidaten = cut.sammleKandidaten("C:\\Users\\jvonalbedyll\\eclipse-workspace\\testdir_false_duplicates");
		
		assertEquals(0, kandidaten.size());
	}
	
}
