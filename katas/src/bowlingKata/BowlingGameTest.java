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
		assertFalse(currentGame.isOver());
		currentGame.addRoll(5);
		assertTrue(currentGame.isOver());
		
		assertEquals(20, currentGame.getFrames().get(9).getScore());
		assertEquals(10, currentGame.getFrames().size());
	}
	
	@Test
	public void testWithSpareAndStrikes() throws Exception {
		currentGame.addRoll(10); // 10 + 8
		
		currentGame.addRoll(3); 
		currentGame.addRoll(5); // 8

		currentGame.addRoll(5);
		currentGame.addRoll(0); // 5
		
		currentGame.addRoll(5);
		currentGame.addRoll(5); // 10 + 7
		
		currentGame.addRoll(7);
		currentGame.addRoll(1); // 8
		
		currentGame.addRoll(3);
		currentGame.addRoll(2); // 5

		currentGame.addRoll(10); // 20
		
		currentGame.addRoll(8);
		currentGame.addRoll(2); // 10
		
		currentGame.addRoll(0);
		currentGame.addRoll(6); // 6
		
		currentGame.addRoll(10); //24
		currentGame.addRoll(7);
		
		assertEquals(10, currentGame.getFrames().size());
		assertEquals(121, currentGame.getTotalScore());
	}
	
	private void addXRollsWithYPins(int rolls, int pins) throws Exception {
		for(int rollCtr=0; rollCtr<rolls; rollCtr++) {
			currentGame.addRoll(pins);			
		}
	}

}
