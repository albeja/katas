package froehlicheZahl;

import java.util.List;
import java.util.stream.Collectors;

public class FroehlicheZahlCalculator {
	public boolean isFroehlicheZahl(int zahl) {
		int ergebnis = neueZahlErmitteln(zahl);
		
		while(isZahlZerlegbar(ergebnis)) {
			ergebnis = neueZahlErmitteln(ergebnis);
		}
		
		return ergebnis == 1;
	}

	private int neueZahlErmitteln(int ergebnis) {
		List<Integer> ziffern = zahlZerlegen(ergebnis);
		List<Integer> quadrierteZiffern = quadrateBilden(ziffern);
		
		return summeBilden(quadrierteZiffern);
	}

	private int summeBilden(List<Integer> quadrierteZiffern) {
		return quadrierteZiffern.stream().reduce(0, (x,y) -> x + y);
	}

	private List<Integer> quadrateBilden(List<Integer> ziffern) {
		return ziffern.stream().map(i -> i*i).collect(Collectors.toList());
	}

	private List<Integer> zahlZerlegen(Integer zahl) {
		return String.valueOf(zahl).chars().map(c -> Character.getNumericValue(c)).boxed().collect(Collectors.toList());
	}

	private boolean isZahlZerlegbar(int zahl) {
		return zahl >= 10;
	}

}
