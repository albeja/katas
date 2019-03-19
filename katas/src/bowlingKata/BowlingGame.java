package bowlingKata;

import java.util.LinkedList;
import java.util.List;

public class BowlingGame {

	LinkedList<Frame> frames = new LinkedList<Frame>();
	
	public void addRoll(int pins) {
		if(isFirstFrame() || getCurrentFrame().isFull() ) {
			frames.add(new Frame());
		} 
			
		getCurrentFrame().addPins(pins);
	}
	
	private boolean isFirstFrame() {
		return frames.isEmpty();
	}

	private Frame getCurrentFrame() {
		return frames.getLast();
	}

	public List<Frame> getFrames() {
		return frames;
	}
	
	public int getTotalScore() {
		return frames.stream().mapToInt(x -> x.getScore()).reduce(0, (x,y) -> x + y);
	}
		
	public boolean isOver() {
		return frames.size() == 10 && frames.getLast().isFull()
				&& !frames.getLast().isSpare() && !frames.getLast().isStrike();
	}
}
