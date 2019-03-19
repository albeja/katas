package bowlingKata;

import java.util.LinkedList;
import java.util.List;

public class BowlingGame {

	LinkedList<Frame> frames = new LinkedList<Frame>();
	
	public void addRoll(int pins) throws Exception {
		if(isOver()) throw new Exception("No roll left, game is over!");
		
		if(isFirstFrame() || (getCurrentFrame().isFull() && !isLastStrikeOrSpare())) frames.add(new Frame()); 

		if(isLastStrikeOrSpare()) getCurrentFrame().addBonusScore(pins);
			
		getCurrentFrame().addPins(pins);
		
		try {
			if(frameBeforeWasStrike()) getLastFrame().addBonusScore(pins);
			if(frameBeforeWasSpare() && getCurrentFrame().getRolls() == 1) getLastFrame().addBonusScore(pins);
		} catch (Exception e) {//No last Frame available
		}
	}

	private Frame getLastFrame() {
		return frames.get(frames.size() - 2);
	}
	
	private boolean frameBeforeWasSpare() {
		try {
			return getLastFrame().isSpare();			
		} catch (Exception e) {
			return false;
		}
	}

	private boolean frameBeforeWasStrike() {
		try {
			return getLastFrame().isStrike();			
		} catch (Exception e) {
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
		return frames.size() == 10 && getCurrentFrame().isFull()
				&& !getCurrentFrame().isSpare() && !getCurrentFrame().isStrike();	
	}
	
	public boolean isLastStrikeOrSpare() {
		return frames.size() == 10 && (getCurrentFrame().isSpare() || getCurrentFrame().isStrike());
	}
}
