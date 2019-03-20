package dubletten;

import java.util.ArrayList;
import java.util.List;

import dubletten.IDublettenpruefung.IDublette;

public class Dublette implements IDublette {
	List<String> dateipfade = new ArrayList<String>();
	
	public void addDateipfad(String pfad) {
		dateipfade.add(pfad);
	}
	
	@Override
	public List<String> getDateipfade() {
		return dateipfade;
	}

}
