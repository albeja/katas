package dubletten;

import java.io.File;
import java.nio.file.Files;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Dublettenpruefung implements IDublettenpruefung {
	List<IDublette> kandidaten;
	List<File> fileListe;
	List<String> fileNameListe;

	@Override
	public List<IDublette> sammle_kandidaten(String pfad) {
		Dublette dublette;
		kandidaten = new LinkedList<IDublette>();
		fileListe = new LinkedList<File>();
		fileNameListe = new LinkedList<String>();
		File basisPfad = new File(pfad);
		
		finde_dateien(basisPfad);
		
		
		for(File file: fileListe) {
			int occurrences = Collections.frequency(fileNameListe, file.getName());
			
			System.out.println(	"File: " + file.getName() + " | Occurences: " + occurrences);
			
			
//			if(fileNameListe.lastIndexOf(file.getName()) > fileNameListe.indexOf(file.getName())) {
//				
//				dublette = new Dublette();
//				
//				while(fileNameListe.contains(file.getName())) {
//					int currentIndex = fileNameListe.indexOf(file.getName());
//					dublette.addDateipfad(fileListe.get(currentIndex).getPath());
//					fileListe.remove(currentIndex);
//					fileNameListe.remove(currentIndex);
//				}
//				
//				kandidaten.add(dublette);
//			
//			}
		}
		
		System.out.println("Anzahl Files: " + fileListe.size());		
		
		return kandidaten;
	}

	private void finde_dateien(File basisPfad) {
		if (!(basisPfad.listFiles() == null)) {
			for(File fileInDirectory : basisPfad.listFiles()) {
				if(fileInDirectory.isFile()) {
					fileListe.add(fileInDirectory);
					fileNameListe.add(fileInDirectory.getName());
				} else {
					finde_dateien(fileInDirectory);
				}
			}	
		}
	}

	@Override
	public List<IDublette> sammle_kandidaten(String pfad, Vergleichsmodi modus) {
		// TODO Auto-generated method stub
		return null;
	}

}
