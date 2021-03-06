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
		int[][] actual = spielbrett.ausgabe();
		
		assertArrayEquals(getInitialField(), actual);
	}
	
	@Test
	public void zugFeldFrei() throws Exception {
		int[][] expected = new int[][]{ {1, 2, 0},
										{0, 0, 0},
										{0, 0, 0} };
		
		spielbrett.zug(0, 1);
		spielbrett.zug(1, 2);
		
		assertArrayEquals(expected, spielbrett.ausgabe());
	}
	
	@Test(expected = Exception.class)
	public void zugUngueltigerSpieler() throws Exception {
		spielbrett.zug(5, 0);
		spielbrett.zug(2, 3);
										
		assertArrayEquals(getInitialField(), spielbrett.ausgabe());
	}

	@Test(expected = Exception.class)
	public void zugUngueltigePosition() throws Exception {
		spielbrett.zug(10, 1);
		spielbrett.zug(-1, 2);
		
		assertArrayEquals(getInitialField(), spielbrett.ausgabe());
	}
	
	@Test(expected = Exception.class)
	public void zugBelegtesFeld() throws Exception{
		spielbrett.zug(1, 1);
		spielbrett.zug(1, 2);
	}
	
	@Test
	public void hasZahlReiheTest() throws Exception {
		assertFalse(spielbrett.hasZahlEineReihe(1));
		assertFalse(spielbrett.isJedesFeldBelegt());
		spielbrett.zug(0, 1);
		spielbrett.zug(1, 2);
		spielbrett.zug(2, 1);
		spielbrett.zug(3, 2);
		spielbrett.zug(4, 1);
		assertFalse(spielbrett.hasZahlEineReihe(2));
		spielbrett.zug(5, 2);
		spielbrett.zug(6, 1);
		spielbrett.zug(7, 2);
		spielbrett.zug(8, 1);
		assertTrue(spielbrett.hasZahlEineReihe(1));
		assertTrue(spielbrett.isJedesFeldBelegt());
	}

	private int[][] getInitialField() {
		int[][] expected = new int[][]{ {0, 0, 0},
										{0, 0, 0},
										{0, 0, 0} };
		return expected;
	}
	
}
