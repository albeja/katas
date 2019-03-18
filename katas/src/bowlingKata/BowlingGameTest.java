package bowlingKata;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BowlingGameTest {
	BowlingGame currentGame;
	
	@Before
	public void setUp() throws Exception {
		currentGame = new BowlingGame();
	}

	@Test(expected = Exception.class)
	public void testGameWithoutSparesOrStrikes() {
		currentGame.addRoll(1);
		currentGame.addRoll(1);
		currentGame.addRoll(1);
		currentGame.addRoll(1);
		currentGame.addRoll(1);
		currentGame.addRoll(1);
		currentGame.addRoll(1);
		currentGame.addRoll(1);
		currentGame.addRoll(1);
		currentGame.addRoll(1);
		assertFalse(currentGame.isOver());
		assertEquals(10, currentGame.getTotalScore());
		
		currentGame.addRoll(1);
		currentGame.addRoll(1);
		currentGame.addRoll(1);
		currentGame.addRoll(1);
		currentGame.addRoll(1);
		currentGame.addRoll(1);
		currentGame.addRoll(1);
		currentGame.addRoll(1);
		currentGame.addRoll(1);
		currentGame.addRoll(1);
		assertTrue(currentGame.isOver());
		assertEquals(20, currentGame.getTotalScore());
		
		Frame expectedFrame = new Frame();
		expectedFrame.addPins(1);
		expectedFrame.addPins(1);
		
		for(Frame frame : currentGame.getFrames()) {
			assertArrayEquals(new int[] {1, 1}, frame.getPins());
		}
		
		currentGame.addRoll(1);
	}

}
