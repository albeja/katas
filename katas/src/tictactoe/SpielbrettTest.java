package tictactoe;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SpielbrettTest {
	public Spielbrett spielbrett;
	
	@Before
	public void setUp() throws Exception {
		spielbrett = new Spielbrett();
	}

	@Test
	public void initialization() {
		int[][] expected = new int[][]{ {0, 0, 0},
										{0, 0, 0},
										{0, 0, 0} };
				
		int[][] actual = spielbrett.ausgabe();
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void zugFeldFrei() throws Exception {
		int[][] expected = new int[][]{ {1, 2, 0},
										{0, 0, 0},
										{0, 0, 0} };
		
		spielbrett.zug(0, 1);
		spielbrett.zug(1, 2);
		
		int[][] actual = spielbrett.ausgabe();
		
		assertArrayEquals(expected, actual);
	}

}
