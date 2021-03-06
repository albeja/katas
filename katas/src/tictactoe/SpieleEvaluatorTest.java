package tictactoe;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tictactoe.SpieleEvaluator.Spielstand;

public class SpieleEvaluatorTest {
	private Spielbrett brett;
	private SpieleEvaluator evaluator;
	
	@Before
	public void setUp() throws Exception {
		brett = new Spielbrett();
		evaluator = new SpieleEvaluator();
	}

	@Test
	public void unentschiedenEvaluieren() throws Exception {
		assertEquals(Spielstand.WEITER, evaluator.spielstandEvaluieren(brett));
		brett.zug(0, 1);
		brett.zug(1, 2);
		brett.zug(2, 1);
		brett.zug(3, 2);
		brett.zug(4, 1);
		brett.zug(5, 2);
		brett.zug(6, 1);
		brett.zug(8, 2);
		brett.zug(7, 1);
		assertEquals(Spielstand.UNENTSCHIEDEN, evaluator.spielstandEvaluieren(brett));
	}

	@Test
	public void siegEinsEvaluieren() throws Exception {
		brett.zug(0, 1);
		brett.zug(1, 1);
		brett.zug(2, 1);
		assertEquals(Spielstand.SPIELER_EINS_GEWINNT, evaluator.spielstandEvaluieren(brett));
	}
	
	@Test
	public void siegZweiEvaluieren() throws Exception {
		brett.zug(0, 2);
		brett.zug(1, 2);
		brett.zug(2, 2);
		assertEquals(Spielstand.SPIELER_ZWEI_GEWINNT, evaluator.spielstandEvaluieren(brett));
	}

}
