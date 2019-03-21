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
	private List<File> nachNameGefilterteListe;
	private List<File> nachNameUndGrößeGefilterteListe;
	Dublette dublette;
	int häufigkeitDateiname;
	File basisPfad;
	
	@Override
	public List<IDublette> sammle_kandidaten(String pfad) {
		kandidaten = new LinkedList<IDublette>();
		fileListe = new LinkedList<File>();
		fileNameListe = new LinkedList<String>();
		nachNameGefilterteListe = new LinkedList<File>();
		nachNameUndGrößeGefilterteListe = new LinkedList<File>();
		häufigkeitDateiname = 0;
		basisPfad = new File(pfad);
		
		finde_dateien(basisPfad);
		
		
		for(File file: fileListe) {
			häufigkeitDateiname = Collections.frequency(fileNameListe, file.getName());
			
			if (häufigkeitDateiname > 1) {
				dublette = new Dublette();

				nachNameGefilterteListe = filtereListeNachNamen(file.getName());
				nachNameUndGrößeGefilterteListe = filtereListeNachGröße(file.length());
				
				for(File gefilterterFile : nachNameUndGrößeGefilterteListe) {
					System.out.println(	"File: " + gefilterterFile.getName() + " | Path: " + gefilterterFile.getPath());
					dublette.addDateipfad(gefilterterFile.getPath());
				}

				if(dublette.getDateipfade().size() > 1) kandidaten.add(dublette);
				fileNameListe.remove(file.getName());
			}
		}
		
		
		return kandidaten;
	}

	private List<File> filtereListeNachGröße(long fileSize) {
		return nachNameGefilterteListe.stream().filter(fileToFilter -> fileToFilter.length() == fileSize).collect(Collectors.toList());
	}

	private List<File> filtereListeNachNamen(String fileName) {
		return fileListe.stream().filter(fileToFiler -> fileToFiler.getName().equals(fileName)).collect(Collectors.toList());
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
