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
	
	public String umbrechen(String text, int maxZeilenlänge) {
		zeilenErstellen(inputAufbereiten(text), maxZeilenlänge);
		
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

	private List<String> zeilenErstellen(String[] textGetrennt, int maxZeilenlänge) {
		for (int wordIndex = 0; wordIndex < textGetrennt.length; wordIndex++) {
			addWortZuArbeitszeile(naechstesWortErmitteln(maxZeilenlänge, textGetrennt[wordIndex]));
		}
		
		addArbeitszeileZuAusgabe();
		
		return ausgabeZeilen;
	}

	private String naechstesWortErmitteln(int maxZeilenlänge, String naechstesWort) {
		if(passtWortInZeile(naechstesWort, getArbeitszeile(), maxZeilenlänge)) {
			return naechstesWort + " ";
		} else {
			addArbeitszeileZuAusgabe();
			return naechsteZeileBeginnen(maxZeilenlänge, naechstesWort);
		}
	}

	private String naechsteZeileBeginnen(int maxZeilenlänge, String naechstesWort) {
		if (wortMussGetrenntWerden(maxZeilenlänge, naechstesWort)) {
			return wortTrennen(maxZeilenlänge, naechstesWort);
		} else {
			return naechstesWort + " ";
		}
	}

	private boolean wortMussGetrenntWerden(int maxZeilenlänge, String naechstesWort) {
		return naechstesWort.length() > maxZeilenlänge;
	}

	private String wortTrennen(int maxZeilenlänge, String naechstesWort) {
		String ersterWortteil = naechstesWort.substring(0, maxZeilenlänge);
		String zweiterWortteil = naechstesWort.trim().substring(maxZeilenlänge) + " ";
		
		wortteilZuAusgabeHinzufuegen(maxZeilenlänge, ersterWortteil);
		return zweiterWortteil;
	}

	private void wortteilZuAusgabeHinzufuegen(int maxZeilenlänge, String ersterWortteil) {
		addWortZuArbeitszeile(ersterWortteil);
		addArbeitszeileZuAusgabe();
	}

	private boolean passtWortInZeile(String naechstesWort, String naechsteZeile, int maxZeilenlänge) {
		return (naechsteZeile.length() + naechstesWort.length() + 1 <= maxZeilenlänge);	
	}

	private String[] inputAufbereiten(String text) {
		return text.split(" ");
	}
}
