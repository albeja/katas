package tictactoe;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class GrafikEngineTest {
	private static GrafikEngine engine;
	
	@BeforeClass
	public static void setUp() throws Exception {
		engine = new GrafikEngine();
	}

	@Test
	public void test() {
		int[][] spielstand = new int[][] {	{1, 2, 1},
											{2, 1, 2},
											{0, 0, 0}};
											
		String expected = 	"   A | B | C\r\n" + 
							"-------------\r\n" + 
							"0: X | O | X\r\n" + 
							"-------------\r\n" + 
							"1: O | X | O\r\n" + 
							"-------------\r\n" + 
							"2:   |   |  \r\n" + 
							"-------------\r\n";
											
		assertTrue(engine.ausgabe(spielstand).equals(expected));
	}

}
