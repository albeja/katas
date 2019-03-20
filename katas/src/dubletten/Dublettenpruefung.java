package dubletten;

import java.io.File;
import java.nio.file.Files;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Dublettenpruefung implements IDublettenpruefung {
	private List<IDublette> kandidaten;
	private List<File> fileListe;
	private List<String> fileNameListe;
	private List<File> gefilterteListe;

	@Override
	public List<IDublette> sammle_kandidaten(String pfad) {
		Dublette dublette;
		kandidaten = new LinkedList<IDublette>();
		fileListe = new LinkedList<File>();
		fileNameListe = new LinkedList<String>();
		gefilterteListe = new LinkedList<File>();
		int häufigkeitDateiname;
		
		File basisPfad = new File(pfad);
		finde_dateien(basisPfad);
		
		
		for(File file: fileListe) {
			häufigkeitDateiname = Collections.frequency(fileNameListe, file.getName());
			
			if (häufigkeitDateiname > 1) {
				dublette = new Dublette();

				gefilterteListe = fileListe.stream().filter(fileToFiler -> fileToFiler.getName().equals(file.getName())).collect(Collectors.toList());
				System.out.println("Anzahl gefilterte Files: " + gefilterteListe.size());		

				for(File gefilterterFile : gefilterteListe) {
					System.out.println(	"File: " + gefilterterFile.getName() + " | Path: " + gefilterterFile.getPath());
					dublette.addDateipfad(gefilterterFile.getPath());
				}

				kandidaten.add(dublette);
				fileNameListe.remove(file.getName());
			}
		}
		
		
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
