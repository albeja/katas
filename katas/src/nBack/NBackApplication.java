package nBack;

import java.util.Scanner;

public class NBackApplication {
	private String aktuelleSerie = "";
	private int n = 0;
	private int korrektErraten = 0;
	
	public double starteTest(int n, int reizdauerMs, String serie, Scanner scanner) {
		this.korrektErraten = 0;
		this.aktuelleSerie = serie;
		this.n = n;
		
		for(int iterator = 0; iterator < serie.length(); iterator++) {
			if (isKorrekteEingabe(scanner.next(), iterator)) korrektErraten++;
		}
		
		return new Double(korrektErraten * 100 / serie.length() );
	}

	private boolean isKorrekteEingabe(String input, int iterator) {
		try {
			if (isZuBeginnKeinNBackKorrekt(input, iterator)) return true;
			if (isNBackKorrekt(input, iterator)) return true;
			if (isKeinNBackKorrekt(input, iterator)) return true;
		} catch (Exception e) {}
		
		return false;
	}

	private boolean isZuBeginnKeinNBackKorrekt(String input, int iterator) {
		return this.n > iterator && !input.equalsIgnoreCase("j");
	}

	private boolean isKeinNBackKorrekt(String input, int iterator) {
		return !input.equalsIgnoreCase("j") && aktuelleSerie.charAt(iterator) != aktuelleSerie.charAt(iterator - this.n);
	}

	private boolean isNBackKorrekt(String input, int iterator) {
		return input.equalsIgnoreCase("j") && aktuelleSerie.charAt(iterator) == aktuelleSerie.charAt(iterator - this.n);
	}
}
