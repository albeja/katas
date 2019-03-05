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
			if (hatKorrektErraten(scanner.next(), iterator)) korrektErraten++;
		}
		
		return new Double(korrektErraten * 100 / serie.length() );
	}

	private boolean hatKorrektErraten(String input, int iterator) {
		if (input.equalsIgnoreCase("j")) {
			try {
				if (aktuelleSerie.charAt(iterator) == aktuelleSerie.charAt(iterator - this.n)) {
					return true;
				}
			} catch (Exception e) {
				return false;
			}
		} else {
			try {
				if (aktuelleSerie.charAt(iterator) != aktuelleSerie.charAt(iterator - this.n)) {
					return true;
				}					
			} catch (Exception e) {
				return true;
			}
		}
		
		return false;
	}
}
