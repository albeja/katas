package tictactoe;

public class GrafikEngine {
	private static final String zeilenumbruch = "\r\n";

	public String ausgabe(int[][] spielstand) {
		return �berschriftAusgeben() + zeilenAusgeben(spielstand);
	}

	private String zeilenAusgeben(int[][] spielstand) {
		String ausgabe = "";
		for(int zeile=0; zeile < spielstand.length; zeile++) {
			ausgabe += zeile + ": ";
			ausgabe += zeileAusgeben(spielstand[zeile]);
		};
		return ausgabe;
	}
	
	private String �berschriftAusgeben() {
		return "   A | B | C" + zeilenumbruch + zeilenTrennen();
	}

	private String zeilenTrennen() {
		return "-------------" + zeilenumbruch;
	}

	private String zeileAusgeben(int[] zeile) {
		String ausgabe = "";
		for(int spalte = 0; spalte < zeile.length; spalte++) {
			ausgabe += feldAusgeben(zeile, spalte);
			ausgabe += zeichenTrennen(spalte);
		}
		return ausgabe;
	}

	private String feldAusgeben(int[] zeile, int spalte) {
		if (zeile[spalte] == 1) {
			return "X";	
		} else if (zeile[spalte] == 2) {
			return "O";	
		} else {
			return " ";
		}
	}
	
	private String zeichenTrennen(int spalte) {
		if (spalte == 0 || spalte == 1) {
			return " | ";
		} else {
			return zeilenumbruch + zeilenTrennen();
		}
	}
}
