package dubletten;

import static org.junit.Assert.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import dubletten.IDublettenpruefung.IDublette;

public class CandidateCheckTest {
	private CandidateCheck cut = new CandidateCheck();

	@Test
	public void prüfeKandidatenEchteDublette() {
		List<String> dateipfade = Stream.of("C:\\Users\\jvonalbedyll\\eclipse-workspace\\testdir_duplicates\\demo_duplicate.txt",
											"C:\\Users\\jvonalbedyll\\eclipse-workspace\\testdir_duplicates\\testdir\\demo_duplicate.txt").collect(Collectors.toList());
		List<IDublette> kandidaten = Stream.of(new Dublette(dateipfade)).collect(Collectors.toList());
		
		assertEquals(kandidaten, cut.prüfeKandidaten(kandidaten));
	}
	
	@Test
	public void prüfeKandidatenFalscheDublette() {
		List<String> dateipfade = Stream.of("C:\\Users\\jvonalbedyll\\eclipse-workspace\\testdir_false_content_duplicates\\demo_false_duplicate.txt",
											"C:\\Users\\jvonalbedyll\\eclipse-workspace\\testdir_false_content_duplicates\\testdir\\demo_false_duplicate.txt").collect(Collectors.toList());
		List<IDublette> kandidaten = Stream.of(new Dublette(dateipfade)).collect(Collectors.toList());
		
		assertTrue(cut.prüfeKandidaten(kandidaten).isEmpty());
	}

}
