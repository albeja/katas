package galgen;

public class Galgenmännchen {
	private char[] gesuchtesArray;
	private char[] geratenerZustand;
	
	public Galgenmännchen(String gesuchtesWort) {
		gesuchtesArray = gesuchtesWort.toCharArray();
		geratenenZustandInitialisieren();   
	}

	private void geratenenZustandInitialisieren() {
		geratenerZustand = new char[gesuchtesArray.length];
		
		for(int counter=0;counter<geratenerZustand.length;counter++) {
			geratenerZustand[counter] = '-';
		}
	}
	 
	public String rateBuchstabe(char buchstabe) {
		buchstabePruefen(buchstabe);
		return geratenenZustandAusgeben();
	}

	private void buchstabePruefen(char buchstabe) {
		if(buchstabeIstInZielwort(buchstabe)) {
			geratenenZustandAnpassen(buchstabe);
		}
	}

	private void geratenenZustandAnpassen(char buchstabe) {
		for(int counter=0; counter<gesuchtesArray.length; counter++) {
			if(gesuchtesArray[counter] == buchstabe) {
				geratenerZustand[counter] = buchstabe;
			}
		}
	}

	private boolean buchstabeIstInZielwort(char buchstabe) {
		for(char i:gesuchtesArray) {
			if (i == buchstabe) return true;
		}
		return false;
	}

	private String geratenenZustandAusgeben() {
		String ausgabe = "";
		for(char i:geratenerZustand) ausgabe = ausgabe.concat(String.valueOf(i));
		System.out.println(ausgabe);
		return ausgabe;
	}
	 
}