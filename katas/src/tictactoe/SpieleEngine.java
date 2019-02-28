package tictactoe;

import java.util.Scanner;

import tictactoe.SpieleEvaluator.Spielstand;

public class SpieleEngine {
	private Spielbrett brett = new Spielbrett();
	private Scanner scanner;
	private SpieleEvaluator evaluator = new SpieleEvaluator();
	private int spieler = 1;
	private GrafikEngine grafik = new GrafikEngine();
	private Spielstand spielstand = Spielstand.WEITER;
	
	public void spielInitialisieren (Scanner inputScanner){
		this.scanner = inputScanner;
	}
	
	public Spielstand spielBeginnen() {
		while (spielstand == Spielstand.WEITER) {
			naechstenSpielzugStarten();
		}
		
		System.out.print(grafik.ausgabe(brett.ausgabe()));
		return spielstand;
	}

	private void naechstenSpielzugStarten() {
		System.out.print(grafik.ausgabe(brett.ausgabe()));
		System.out.print("Kommando: ");
		try {
			spielstand = eingabeVerarbeiten(scanner.next());
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
	}

	private Spielstand eingabeVerarbeiten(String kommando) throws Exception {
		switch (kommando) {
			case "A0": return spielzugDurchf�hren(0);
			case "B0": return spielzugDurchf�hren(1);
			case "C0": return spielzugDurchf�hren(2);
	        case "A1": return spielzugDurchf�hren(3);
	        case "B1": return spielzugDurchf�hren(4);
	        case "C1": return spielzugDurchf�hren(5);
	        case "A2": return spielzugDurchf�hren(6);
	        case "B2": return spielzugDurchf�hren(7);
	        case "C2": return spielzugDurchf�hren(8);
	        default:
	        	throw new Exception("Ung�ltiger Befehl.");
		}	
	}

	private Spielstand spielzugDurchf�hren(int spielfeld) throws Exception {
		brett.zug(spielfeld, spieler);
		spielerWechsel();
		return evaluator.spielstandEvaluieren(brett);
	}

	private void spielerWechsel() {
		if (spieler == 1) spieler ++;
		else spieler--;
	}
		
	public static void main(String [] args) {
		SpieleEngine engine = new SpieleEngine();
		engine.spielInitialisieren(new Scanner(System.in));
		engine.spielBeginnen();
	}
}
