package bowlingKata;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FrameTest {
	private Frame currentFrame;
	
	@Before
	public void setUp() throws Exception {
		currentFrame = new Frame();
	}

	@Test
	public void testSetGetAdd() {
		currentFrame.addPins(6);
		currentFrame.addPins(4);	
		assertEquals(10,currentFrame.getScore());
		
		currentFrame.addBonusScore(5);
		assertEquals(15,currentFrame.getScore());
		
		assertArrayEquals(new int[] {6, 4},currentFrame.getPins());
		assertEquals(2, currentFrame.getRolls());
	}
	
	@Test
	public void testSpare() {
		currentFrame.addPins(6);
		assertFalse(currentFrame.isSpare());
		
		currentFrame.addPins(4);
		assertTrue(currentFrame.isSpare());
	}
	
	@Test
	public void testStrike() {
		assertFalse(currentFrame.isStrike());
		
		currentFrame.addPins(10);
		
		assertTrue(currentFrame.isStrike());
	}
	
	@Test
	public void testNoStrikeNoSpare() {
		currentFrame.addPins(6);
		currentFrame.addPins(3);

		assertFalse(currentFrame.isStrike());
		assertFalse(currentFrame.isSpare());		
	}
}
