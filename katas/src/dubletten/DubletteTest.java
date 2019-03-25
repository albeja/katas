package dubletten;

import static org.junit.Assert.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

public class DubletteTest {
	Dublette dublette;

	@Test
	public void testAddGetPfade() {
		dublette = new Dublette(Stream.of("pfad1", "pfad2").collect(Collectors.toList()));
		
		assertEquals("pfad1", dublette.getDateipfade().get(0));
		assertEquals("pfad2", dublette.getDateipfade().get(1));
	}

}
