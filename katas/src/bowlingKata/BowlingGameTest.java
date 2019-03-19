package bowlingKata;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BowlingGameTest {
	BowlingGame currentGame;
	
	@Before
	public void setUp() throws Exception {
		currentGame = new BowlingGame();
	}

	@Test
	public void testGameWithoutSparesOrStrikes() {
		for(int rollCtr=0; rollCtr<10; rollCtr++) {
			currentGame.addRoll(1);			
		}
		assertFalse(currentGame.isOver());
		assertEquals(10, currentGame.getTotalScore());
		
		for(int rollCtr=0; rollCtr<10; rollCtr++) {
			currentGame.addRoll(1);			
		}
		assertTrue(currentGame.isOver());
		assertEquals(20, currentGame.getTotalScore());
		
		Frame expectedFrame = new Frame();
		expectedFrame.addPins(1);
		expectedFrame.addPins(1);
		
		List<Frame> frames = currentGame.getFrames();
		for(Frame frame : frames) {
			assertArrayEquals(expectedFrame.getPins(), frame.getPins());
		}
	}

}
