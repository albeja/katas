package bowlingKata;

import java.util.LinkedList;
import java.util.List;

public class BowlingGame {

	LinkedList<Frame> frames = new LinkedList<Frame>();
	
	public void addRoll(int pins) throws Exception {
		if(isOver()) {
			throw new Exception("No roll left, game is over!");
		}
		
		if(isFirstFrame() || (getCurrentFrame().isFull() && !isLastStrikeOrSpare()) ) {
			frames.add(new Frame());
		} 

		if(isLastStrikeOrSpare()) {
			frames.getLast().addBonusScore(pins);
		}
			
		getCurrentFrame().addPins(pins);
		
		if(frameBeforeWasStrike()) {
			frames.get(frames.size() - 2).addBonusScore(pins);
		}
		
		if(frameBeforeWasSpare() && frames.getLast().getRolls() == 1) {
			frames.get(frames.size() - 2).addBonusScore(pins);
		}
	}
	
	private boolean frameBeforeWasSpare() {
		try {
			return frames.get(frames.size() - 2).isSpare();			
		} catch (Exception e) {
			return false;
		}
	}

	private boolean frameBeforeWasStrike() {
		try {
			return frames.get(frames.size() - 2).isStrike();			
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
		return frames.size() == 10 && frames.getLast().isFull()
				&& !frames.getLast().isSpare() && !frames.getLast().isStrike();	
	}
	
	public boolean isLastStrikeOrSpare() {
		return frames.size() == 10 && (frames.getLast().isSpare() || frames.getLast().isStrike());
	}
}
