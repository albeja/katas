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
	public void testScoreWithoutSparesOrStrikes() throws Exception {
		addXRollsWithYPins(10, 1);
		assertFalse(currentGame.isOver());
		assertEquals(10, currentGame.getTotalScore());
		
		addXRollsWithYPins(10, 1);
		assertTrue(currentGame.isOver());
		assertEquals(20, currentGame.getTotalScore());
	}
	
	@Test
	public void testPinsAndSizeOfFrames() throws Exception {		
		Frame expectedFrame = new Frame();
		expectedFrame.addPins(1);
		expectedFrame.addPins(1);
		
		addXRollsWithYPins(10, 1);
		
		List<Frame> currentFrames = currentGame.getFrames();
		for(Frame frame : currentFrames) {
			assertArrayEquals(expectedFrame.getPins(), frame.getPins());
		}
		
		assertEquals(5, currentFrames.size());
	}
	
	@Test (expected = Exception.class)
	public void testNoExtraRollAfterEnd() throws Exception {
		addXRollsWithYPins(20, 4);
		
		assertTrue(currentGame.isOver());
		
		currentGame.addRoll(4);
	}
	
	@Test
	public void testExtraRollAfterEnd() throws Exception {
		addXRollsWithYPins(19, 4);
		currentGame.addRoll(6);
		currentGame.addRoll(5);
		
		assertEquals(20, currentGame.getFrames().get(9).getScore());
		assertEquals(10, currentGame.getFrames().size());
	}
	
	private void addXRollsWithYPins(int rolls, int pins) throws Exception {
		for(int rollCtr=0; rollCtr<rolls; rollCtr++) {
			currentGame.addRoll(pins);			
		}
	}

}
