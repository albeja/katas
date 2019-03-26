package dubletten;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import dubletten.IDublettenpruefung.IDublette;

public class DublettenpruefungTest {
	Dublettenpruefung cut;
	
	@Before
	public void setUp() throws Exception {
		cut = new Dublettenpruefung();
	}

	@Test
	public void testSammleKandidatenGleicheGrößeUndNamen() {
		List<IDublette> kandidaten = cut.sammleKandidaten("C:\\Users\\jvonalbedyll\\eclipse-workspace\\testdir_duplicates");
		List<String> dateipfade = Stream.of("C:\\Users\\jvonalbedyll\\eclipse-workspace\\testdir_duplicates\\demo_duplicate.txt",
											"C:\\Users\\jvonalbedyll\\eclipse-workspace\\testdir_duplicates\\testdir\\demo_duplicate.txt").collect(Collectors.toList());
		
		assertEquals(1, kandidaten.size());
		assertEquals(dateipfade.get(0), kandidaten.get(0).getDateipfade().get(0));
		assertEquals(dateipfade.get(1), kandidaten.get(0).getDateipfade().get(1));
		assertEquals(1, cut.prüfeKandidaten(kandidaten).size());

	}

	@Test
	public void testSammleKandidatenGleicherNameUnterschiedlicheGröße() {
		List<IDublette> kandidaten = cut.sammleKandidaten("C:\\Users\\jvonalbedyll\\eclipse-workspace\\testdir_false_size_duplicates");
		
		assertEquals(0, kandidaten.size());
	}
	
	@Test
	public void testSchreibeDublettenInDatei() throws IOException {
		String filename = "C:\\Users\\jvonalbedyll\\eclipse-workspace\\"+"dubletten_ergebnis_"+Instant.now().getEpochSecond()+".txt";
		cut.schreibeDublettenInDatei(filename, "C:\\Users\\jvonalbedyll\\eclipse-workspace\\testdir_duplicates");

		File createdFile = new File(filename);
		assertTrue(createdFile.isFile());
		assertTrue(createdFile.length() > 0);
	}
	
}
