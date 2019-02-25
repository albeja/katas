package tannenbaum;

public class Tannenbaum {
	public String zeichnen(int hoehe) {
		int maximaleBreite = hoehe*2 - 1;
		String baumString= "";
		
		baumString = baumAufbauen(hoehe, maximaleBreite, baumString);
		baumString = stumpfAnfuegen(hoehe - 1, maximaleBreite, baumString);
		
		return baumString;
	}

	private String baumAufbauen(int hoehe, int maximaleBreite, String baumString) {
		String spaceString;
		int anzahlSpaces = 0;
		int anzahlX = 0;
		int hoeheMitStumpf = hoehe + 1;
		
		for (int aktuelleZeile=1; aktuelleZeile < hoeheMitStumpf; aktuelleZeile++) {
			anzahlSpaces = hoehe - aktuelleZeile;
			spaceString = substringGenerator(anzahlSpaces, " ");
			anzahlX = aktuelleZeile*2 - 1;
				
			baumString = baumString.concat(spaceString);
			baumString = baumString.concat(substringGenerator(anzahlX, "X"));
			baumString = baumString.concat(spaceString);
			baumString = baumString.concat("\r\n");
		}
		return baumString;
	}

	private String stumpfAnfuegen(int anzahlSpaces, int maximaleBreite, String baumString) {
		String spaceString = substringGenerator(anzahlSpaces, " ");
		
		baumString = baumString.concat(spaceString);
		baumString = baumString.concat("I");
		baumString = baumString.concat(spaceString);
		
		return baumString;
	}
	
	private String substringGenerator(int anzahlSpaces, String baseString) {
		String substring = "";
		for(int angefuegt=0; angefuegt<anzahlSpaces; angefuegt++) {
			substring = substring.concat(baseString);
		}
		return substring;
	}
}
