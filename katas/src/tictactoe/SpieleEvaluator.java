package tictactoe;

public class SpieleEvaluator {
	public enum Spielstand { UNENTSCHIEDEN, SPIELER_EINS_GEWINNT, SPIELER_ZWEI_GEWINNT, WEITER }
	
	public Spielstand spielstandEvaluieren(Spielbrett brett) {
		if (unentschieden(brett)) {
			System.out.println("Unentschieden. Entweder neu oder ende wählen.");
			return Spielstand.UNENTSCHIEDEN;
		} else if (spielerEinsGewinnt(brett)) {
			System.out.println("Spieler 1 gewinnt. Entweder neu oder ende wählen.");
			return Spielstand.SPIELER_EINS_GEWINNT;
		} else if (spielerZweiGewinnt(brett)) {
			System.out.println("Spieler 2 gewinnt. Entweder neu oder ende wählen.");
			return Spielstand.SPIELER_ZWEI_GEWINNT;
		} else {
			return Spielstand.WEITER;
		}
	}

	private boolean unentschieden(Spielbrett brett) {
		return brett.isJedesFeldBelegt();
	}

	private boolean spielerZweiGewinnt(Spielbrett brett) {
		return brett.hasZahlEineReihe(2);
	}

	private boolean spielerEinsGewinnt(Spielbrett brett) {
		return brett.hasZahlEineReihe(1);
	}
	
}
