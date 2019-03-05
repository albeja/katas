package nBack;

import java.util.Scanner;

public class NBackApplication {
	
	public double starteTest(int n, int reizdauerMs, String serie, Scanner scanner) {
		String input = "";
		int korrektErraten = 0;
		
		for(int iterator = 0; iterator < serie.length(); iterator++) {
			
			input = scanner.next();

			if (input.equalsIgnoreCase("j")) {
				try {
					if (serie.charAt(iterator) == serie.charAt(iterator - n)) {
						korrektErraten++;
					}
				} catch (Exception e) {}
			} else {
				try {
					if (serie.charAt(iterator) != serie.charAt(iterator - n)) {
						korrektErraten++;
					}					
				} catch (Exception e) {
					korrektErraten++;
				}
			}
		}
		
		return new Double(korrektErraten * 100 / serie.length() );
	}
}
