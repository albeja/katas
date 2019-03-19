package bowlingKata;

import java.util.LinkedList;
import java.util.List;

public class BowlingGame {
	LinkedList<Frame> frames = new LinkedList<Frame>();
	
	public void addRoll(int pins) throws Exception {
		if(isOver()) throw new Exception("No roll left, game is over!");
		if(isFirstFrame() || (getCurrentFrame().isFull() && !(isLastFrame()))) frames.add(new Frame()); 
		if(isLastFrame() && isStrikeOrSpare()) getCurrentFrame().addBonusScore(pins);
			
		getCurrentFrame().addPins(pins);
		
		if(frameBeforeWasStrike()) getLastFrame().addBonusScore(pins);
		if(frameBeforeWasSpare() && isFirstRollInThisFrame()) getLastFrame().addBonusScore(pins);
	}

	private boolean isFirstRollInThisFrame() {
		return getCurrentFrame().getRolls() == 1;
	}

	private Frame getLastFrame() {
		return frames.get(frames.size() - 2);
	}
	
	private boolean frameBeforeWasSpare() {
		try {
			return getLastFrame().isSpare();			
		} catch (IndexOutOfBoundsException firstFrame) {
			return false;
		}
	}

	private boolean frameBeforeWasStrike() {
		try {
			return getLastFrame().isStrike();			
		} catch (IndexOutOfBoundsException firstFrame) {
			return false;
		}

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
		return isLastFrame() && getCurrentFrame().isFull() && !isStrikeOrSpare() ||
				isLastFrame() && getCurrentFrame().getScore() > 10;	
	}

	private boolean isLastFrame() {
		return frames.size() == 10;
	}
	
	public boolean isStrikeOrSpare() {
		return getCurrentFrame().isSpare() || getCurrentFrame().isStrike();
	}
}
