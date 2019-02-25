package russischeBauernmultiplikation;

import java.util.ArrayList;
import java.util.List;

public class RussischeMultiplikation {
	private Ergebnis ergebnis = new Ergebnis();
	
	public Ergebnis mul(int x, int y) {
        ergebnis.setZahlen(zahlenReiheErmitteln(x, y));
        ergebnis.setErgebnis(produktBerechnen(ergebnis.getZahlen()));
		
		return ergebnis;
	}

	private List<int[]> zahlenReiheErmitteln(int x, int y) {
		List<int[]> zahlenReihe = new ArrayList<int[]>();
		int linkerWert = x;
		int rechterWert = y;
		
		while(linkerWert>=1) {
			zahlenReihe.add(new int[]{linkerWert,rechterWert});
			linkerWert = linkerWert/2;
			rechterWert = rechterWert*2;

		}
		return zahlenReihe;
	}

	private int produktBerechnen(List<int[]> zahlenReihe) {
		int produkt = 0;
		for (int[] pair : zahlenReihe) {
            if (pair[0]%2 != 0) {
                produkt += pair[1];
            }
        }
		return produkt;
	}
}
