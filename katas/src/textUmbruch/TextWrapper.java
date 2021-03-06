package textUmbruch;

import java.util.ArrayList;
import java.util.List;

public class TextWrapper {
	private List<String> ausgabeZeilen = new ArrayList<String>();
	
	private void addArbeitszeileZuAusgabe() {
		this.ausgabeZeilen.add(getArbeitszeile().trim());
		clearArbeitszeile();
	}
	
	private String arbeitszeile = "";
	
	private void addWortZuArbeitszeile(String wort) {
		arbeitszeile = arbeitszeile.concat(wort);
	}
	
	private String getArbeitszeile() {
		return arbeitszeile;
	}
	
	private void clearArbeitszeile() {
		arbeitszeile = "";
	}
	
	public String umbrechen(String text, int maxZeilenl�nge) {
		zeilenErstellen(inputAufbereiten(text), maxZeilenl�nge);
		
		return ausgabeTextErstellen();
	}

	private String ausgabeTextErstellen() {
		String ausgabeString = "";
		
		for(int lineIndex = 0; lineIndex < ausgabeZeilen.size(); lineIndex++) {
			ausgabeString = ausgabeString.concat(ausgabeZeilen.get(lineIndex));
			if (lineIndex < ausgabeZeilen.size() - 1) ausgabeString = ausgabeString.concat("\r\n");
		}
		return ausgabeString;
	}

	private List<String> zeilenErstellen(String[] textGetrennt, int maxZeilenl�nge) {
		for (int wordIndex = 0; wordIndex < textGetrennt.length; wordIndex++) {
			addWortZuArbeitszeile(naechstesWortErmitteln(maxZeilenl�nge, textGetrennt[wordIndex]));
		}
		
		addArbeitszeileZuAusgabe();
		
		return ausgabeZeilen;
	}

	private String naechstesWortErmitteln(int maxZeilenl�nge, String naechstesWort) {
		if(passtWortInZeile(naechstesWort, getArbeitszeile(), maxZeilenl�nge)) {
			return naechstesWort + " ";
		} else {
			addArbeitszeileZuAusgabe();
			return naechsteZeileBeginnen(maxZeilenl�nge, naechstesWort);
		}
	}

	private String naechsteZeileBeginnen(int maxZeilenl�nge, String naechstesWort) {
		if (wortMussGetrenntWerden(maxZeilenl�nge, naechstesWort)) {
			return wortTrennen(maxZeilenl�nge, naechstesWort);
		} else {
			return naechstesWort + " ";
		}
	}

	private boolean wortMussGetrenntWerden(int maxZeilenl�nge, String naechstesWort) {
		return naechstesWort.length() > maxZeilenl�nge;
	}

	private String wortTrennen(int maxZeilenl�nge, String naechstesWort) {
		String ersterWortteil = naechstesWort.substring(0, maxZeilenl�nge);
		String zweiterWortteil = naechstesWort.trim().substring(maxZeilenl�nge) + " ";
		
		wortteilZuAusgabeHinzufuegen(maxZeilenl�nge, ersterWortteil);
		return zweiterWortteil;
	}

	private void wortteilZuAusgabeHinzufuegen(int maxZeilenl�nge, String ersterWortteil) {
		addWortZuArbeitszeile(ersterWortteil);
		addArbeitszeileZuAusgabe();
	}

	private boolean passtWortInZeile(String naechstesWort, String naechsteZeile, int maxZeilenl�nge) {
		return (naechsteZeile.length() + naechstesWort.length() + 1 <= maxZeilenl�nge);	
	}

	private String[] inputAufbereiten(String text) {
		return text.split(" ");
	}
}
