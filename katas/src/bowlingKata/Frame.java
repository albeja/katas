package bowlingKata;

import java.util.ArrayList;
import java.util.List;

public class Frame {
	private List<Integer> pinsRolled = new ArrayList<Integer>();
	private int score = 0;
	
	public int getScore() {
		return score;
	}
	
	public int[] getPins() {
		return pinsRolled.stream().mapToInt(i->i).toArray();
	}
	
	public void addPins(int pins) {
		pinsRolled.add(pins);
		score += pins;
	}
	
	public void addBonusScore(int bonusScore) {
		score += bonusScore;
	}
	
	public boolean isSpare() {
		if (pinsRolled.size() >= 2)	return pinsRolled.get(0) + pinsRolled.get(1) == 10;
		else return false;
	}
	
	public boolean isStrike() {
		if (pinsRolled.size() >= 1) return pinsRolled.get(0) == 10;
		else return false;
	}
	
	public int getRolls() {
		return pinsRolled.size();
	}
	
	public boolean isFull() {
		try {			
			return isStrike() || getRolls()>=2;
		} catch (Exception e) {
			return false;
		}
	}
}
