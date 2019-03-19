package bowlingKata;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

	List<Frame> frames = new ArrayList<Frame>();
	
	public void addRoll(int pins) {
		if(isFirstFrame() || isCurrentFrameFull() ) {
			
		} else {
			
		}
	}
	
	private boolean isFirstFrame() {
		return frames.isEmpty();
	}

	private boolean isCurrentFrameFull() {
		return frames.get(frames.size() - 1).getPins().length >= 2;
	}

	public Frame[] getFrames() {
		return (Frame[])frames.toArray();
	}
	
	public int getTotalScore() {
		return 0;
	}
	
	public boolean isOver() {
		return false;
	}
}
