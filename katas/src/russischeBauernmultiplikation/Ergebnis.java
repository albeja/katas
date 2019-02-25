package russischeBauernmultiplikation;

import java.util.List;

public class Ergebnis {
	private List<int[]> zahlen;
	private int ergebnis;

	public List<int[]> getZahlen() {
		return zahlen;
	}
	public int getErgebnis() {
		return ergebnis;
	}

	public void setZahlen(List<int[]> zahlen) {
		this.zahlen = zahlen;
	}
	public void setErgebnis(int ergebnis) {
		this.ergebnis = ergebnis;
	}
	
	public boolean equals(Ergebnis toCompare) {
		List<int[]> vergleichsZahlenPaare = toCompare.getZahlen();
		
		for(int index = 0; index < vergleichsZahlenPaare.size(); index++) {
			if (vergleichsZahlenPaare.get(index)[0] != this.getZahlen().get(index)[0] 
				|| vergleichsZahlenPaare.get(index)[1] != this.getZahlen().get(index)[1])
				return false;
		}
		
		return toCompare.getErgebnis() == this.ergebnis;
	}
}
