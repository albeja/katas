package tictactoe;

public class Spielbrett {
	//TODO: Feld als eigene Klasse --> von 1 bis 9 durchnummerieren
	private int[] positionen;
	
	public Spielbrett() {
		positionen = new int[9];
	}
	
	public int[][] ausgabe(){
		int[][] spielbrett = new int[3][3];
		
		spielbrett[0][0] = positionen[0];
		spielbrett[0][1] = positionen[1];
		spielbrett[0][2] = positionen[2];
		spielbrett[1][0] = positionen[3];
		spielbrett[1][1] = positionen[4];
		spielbrett[1][2] = positionen[5];
		spielbrett[2][0] = positionen[6];
		spielbrett[2][1] = positionen[7];
		spielbrett[2][2] = positionen[8];
		
		return spielbrett;
	}
	
	public void zug(int position, int spieler) throws Exception {
		if (positionIstUngültig(position)) throw new Exception("Position ist ungültig.");
		if (spielerIstUngültig(spieler)) throw new Exception("Spieler ist ungültig.");
		
		if (feldIstFrei(position)) {
			feldBelegen(position, spieler);
		} else {
			throw new Exception("Feld ist bereits belegt.");
		}
	}

	public boolean hasZahlEineReihe(int zahl) {
		//A
		if (positionen[0] == zahl &&
			positionen[1] == zahl &&
			positionen[2] == zahl) return true;
		//B
		if (positionen[3] == zahl &&
			positionen[4] == zahl &&
			positionen[5] == zahl) return true;
		//C
		if (positionen[6] == zahl &&
			positionen[7] == zahl &&
			positionen[8] == zahl) return true;
		
		//0
		if (positionen[0] == zahl &&
			positionen[3] == zahl &&
			positionen[6] == zahl) return true;
		
		//1
		if (positionen[1] == zahl &&
			positionen[4] == zahl &&
			positionen[7] == zahl) return true;
		
		//2
		if (positionen[2] == zahl &&
			positionen[5] == zahl &&
			positionen[8] == zahl) return true;
		
		//Diagonal 1
		if (positionen[0] == zahl &&
			positionen[4] == zahl &&
			positionen[8] == zahl) return true;
		
		//Diagonal 2
		if (positionen[2] == zahl &&
			positionen[4] == zahl &&
			positionen[7] == zahl) return true;
		
		return false;
	}

	public boolean isJedesFeldBelegt() {
		return positionen[0] != 0 &&
				positionen[1] != 0 &&
				positionen[2] != 0 &&
				positionen[3] != 0 &&
				positionen[4] != 0 &&
				positionen[5] != 0 &&
				positionen[6] != 0 &&
				positionen[7] != 0 &&
				positionen[8] != 0;
	}
	
	private boolean spielerIstUngültig(int spieler) {
		return !(spieler == 1 || spieler == 2);
	}

	private boolean positionIstUngültig(int position) {
		return position < 0 || position > 8;
	}

	private boolean feldIstFrei(int position) {
		return positionen[position] == 0;
	}
	
	private void feldBelegen(int position, int spieler) {
		positionen[position] = spieler;
	}
}
