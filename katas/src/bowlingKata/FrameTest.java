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
	}
}
