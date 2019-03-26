package dubletten;

import java.io.File;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Dublettenpruefung implements IDublettenpruefung {
	private FileFinder finder = new FileFinder();
	private CandidateCheck checker = new CandidateCheck();
	
	public void schreibeDublettenInDatei(String zielpfad, String vergleichsroot) {
		
	}
	
	@Override
	public List<IDublette> sammleKandidaten(String pfad) {
		return findeKandidatenAusListe(finder.findeDateien(pfad));
	}

	private List<IDublette> findeKandidatenAusListe(List<File> fileListe) {
		List<File> listeAllerFiles = fileListe;
		List<IDublette> kandidatenListe = new LinkedList<IDublette>();
		
		while(listeAllerFiles.isEmpty() == false) {
			List<File> nachNameUndGr��eGefiltert = filtereNachNamenUndGr��e(listeAllerFiles.get(0), listeAllerFiles);
			
			if (nachNameUndGr��eGefiltert.size() > 1) {
				kandidatenListe.add(baueDublettenkandidat(nachNameUndGr��eGefiltert));
			}
			
			listeAllerFiles.remove(0);
		}
		
		return kandidatenListe;
	}

	private Dublette baueDublettenkandidat(List<File> nachNameUndGr��eGefiltert) {
		List<String> dateipfade = nachNameUndGr��eGefiltert.stream().map(file -> file.getPath()).collect(Collectors.toList());
		return new Dublette(dateipfade);
	}
	
	private List<File> filtereNachNamenUndGr��e(File file, List<File> fileList) {
		List<File> nachNameGefiltert = fileList.stream().filter(
										fileToFiler -> fileToFiler.getName().equals(file.getName())).collect(Collectors.toList());
		return nachNameGefiltert.stream().filter(
				fileToFilter -> fileToFilter.length() == file.length()).collect(Collectors.toList());
	}

	@Override
	public List<IDublette> pr�feKandidaten(List<IDublette> kandidaten) {
		return checker.pr�feKandidaten(kandidaten);
	}
	
	public static void main(String[] args) {
		//TODO: Gui bauen
		
		//TODO: Ergebnis in File schreiben
		
		
		System.out.println("Startzeit: " + Instant.now());

		Dublettenpruefung pruefung = new Dublettenpruefung();
		List<IDublette> kandidaten = pruefung.sammleKandidaten("C:\\Program Files");
		List<IDublette> dubletten = pruefung.pr�feKandidaten(kandidaten);
		
		for(int ctr=1; ctr<=dubletten.size(); ctr++) {
			System.out.println("Dublette " + ctr);
			for(String pfad : dubletten.get(ctr-1).getDateipfade()) {
				System.out.println("Pfad: " + pfad);
			}
		}
		
		System.out.println("Endzeit: " + Instant.now());
	}
}
