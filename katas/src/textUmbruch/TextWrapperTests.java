package textUmbruch;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TextWrapperTests {
	public TextWrapper wrapper;
	
	@Before
	public void setUp() throws Exception {
		wrapper = new TextWrapper();
	}

	@Test
	public void testWithNine() {
		String expectedText = 	"Es blaut\r\n" + 
								"die\r\n" + 
								"Nacht,\r\n" + 
								"die\r\n" + 
								"Sternlein\r\n" + 
								"blinken,\r\n" + 
								"Schneeflö\r\n" + 
								"cklein\r\n" + 
								"leis\r\n" + 
								"hernieder\r\n" + 
								"sinken.";
		
		String actualText = wrapper.umbrechen("Es blaut die Nacht, die Sternlein blinken, Schneeflöcklein leis hernieder sinken.", 9);
		
		assertEquals(expectedText, actualText);
	}

	@Test
	public void testWithFourteen() {
		String expectedText = 	"Es blaut die\r\n" + 
								"Nacht, die\r\n" + 
								"Sternlein\r\n" + 
								"blinken,\r\n" + 
								"Schneeflöcklei\r\n" + 
								"n leis\r\n" + 
								"hernieder\r\n" + 
								"sinken.";

		String actualText = wrapper.umbrechen("Es blaut die Nacht, die Sternlein blinken, Schneeflöcklein leis hernieder sinken.", 14);

		assertEquals(expectedText, actualText);
	}

	
}
