package tictactoe;

import java.util.Scanner;

public class SpieleEngine {
	private Spielbrett brett = new Spielbrett();
	private Scanner scanner = new Scanner(System.in);
	private int spieler = 1;
	private GrafikEngine grafik = new GrafikEngine();

	public void naechstenSpielzugBeginnen() {
		grafik.ausgabe(brett.ausgabe());
		inputVerarbeiten();
	}

	private void inputVerarbeiten() {
		System.out.print("Kommando: ");
		String kommando = scanner.next();
		try {
			eingabeVerarbeiten(kommando);
		} catch(Exception e){
			System.out.println(e.getMessage());
			inputVerarbeiten();
		}
	}
	
	private void spielstandEvaluieren() {
		if (unentschieden()) {
			System.out.println("Unentschieden. Entweder neu oder ende w�hlen.");
			naechstenSpielzugBeginnen();
		} else if (spielerEinsGewinnt()) {
			System.out.println("Spieler 1 gewinnt. Entweder neu oder ende w�hlen.");
			naechstenSpielzugBeginnen();
		} else if (spielerZweiGewinnt()) {
			System.out.println("Spieler 2 gewinnt. Entweder neu oder ende w�hlen.");
			naechstenSpielzugBeginnen();
		} else {
			naechstenSpielzugBeginnen();
		}
	}

	private boolean unentschieden() {
		return brett.isJedesFeldBelegt();
	}

	private boolean spielerZweiGewinnt() {
		return brett.hasZahlEineReihe(2);
	}

	private boolean spielerEinsGewinnt() {
		return brett.hasZahlEineReihe(1);
	}

	private void eingabeVerarbeiten(String kommando) throws Exception {
		//TODO: Spiel geht nach Zug weiter
		switch (kommando) {
			case "A0": spielzugDurchf�hren(0); break;
			case "B0": spielzugDurchf�hren(1); break;
			case "C0": spielzugDurchf�hren(2); break;
	        case "A1": spielzugDurchf�hren(3); break;
	        case "B1": spielzugDurchf�hren(4); break;
	        case "C1": spielzugDurchf�hren(5); break;
	        case "A2": spielzugDurchf�hren(6); break;
	        case "B2": spielzugDurchf�hren(7); break;
	        case "C2": spielzugDurchf�hren(8); break;
	        case "neu": brett = new Spielbrett(); this.naechstenSpielzugBeginnen(); break;
	        case "ende": break;
	        default:
	        	throw new Exception("Ung�ltiger Befehl.");
		}	
	}

	private void spielzugDurchf�hren(int spielfeld) throws Exception {
		brett.zug(spielfeld, spieler);
		spielerWechsel();
		spielstandEvaluieren();
	}

	private void spielerWechsel() {
		if (spieler == 1) spieler ++;
		else spieler--;
	}
		
	public static void main(String [] args) {
		new SpieleEngine().naechstenSpielzugBeginnen();
	}
}
