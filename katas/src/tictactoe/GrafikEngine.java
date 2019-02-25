package tictactoe;

public class GrafikEngine {
	public void ausgabe(int[][] spielstand) {
		überschriftAusgeben();
		zeilenAusgeben(spielstand);
	}

	private void zeilenAusgeben(int[][] spielstand) {
		for(int zeile=0; zeile < spielstand.length; zeile++) {
			System.out.print(zeile + ": ");
			zeileAusgeben(spielstand[zeile]);
		};
	}
	
	private void überschriftAusgeben() {
		System.out.println("   A | B | C");
		zeilenTrennen();
	}

	private void zeilenTrennen() {
		System.out.println("-------------");
	}

	private void zeileAusgeben(int[] zeile) {
		for(int spalte = 0; spalte < zeile.length; spalte++) {
			feldAusgeben(zeile, spalte);
			zeichenTrennen(spalte);
		}
	}

	private void feldAusgeben(int[] zeile, int spalte) {
		if (zeile[spalte] == 1) {
			System.out.print("X");	
		} else if (zeile[spalte] == 2) {
			System.out.print("O");	
		} else {
			System.out.print(" ");
		}
	}
	
	private void zeichenTrennen(int spalte) {
		if (spalte == 0 || spalte == 1) {
			System.out.print(" | ");
		} else {
			System.out.print("\r\n");
			zeilenTrennen();
		}
	}
}
