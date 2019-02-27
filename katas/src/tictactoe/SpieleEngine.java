package tictactoe;

import java.util.Scanner;

public class SpieleEngine {
	private Spielbrett brett = new Spielbrett();
	private Scanner scanner = new Scanner(System.in);
	private SpieleEvaluator evaluator = new SpieleEvaluator();
	private int spieler = 1;
	private GrafikEngine grafik = new GrafikEngine();

	public void naechstenSpielzugBeginnen() {
		System.out.print(grafik.ausgabe(brett.ausgabe()));
		System.out.print("Kommando: ");
		inputVerarbeiten(scanner.next());
	}

	public void inputVerarbeiten(String kommando) {
		try {
			eingabeVerarbeiten(kommando);
		} catch(Exception e){
			System.out.println(e.getMessage());
			naechstenSpielzugBeginnen();
		}
	}

	private void eingabeVerarbeiten(String kommando) throws Exception {
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
		evaluator.spielstandEvaluieren(brett);
		naechstenSpielzugBeginnen();
	}

	private void spielerWechsel() {
		if (spieler == 1) spieler ++;
		else spieler--;
	}
		
	public static void main(String [] args) {
		new SpieleEngine().naechstenSpielzugBeginnen();
	}
}
