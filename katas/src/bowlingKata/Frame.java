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
}
