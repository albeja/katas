package dubletten;

import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Dublettenpruefung implements IDublettenpruefung {
	private List<IDublette> kandidaten;
	private List<File> filesUnterRoot;
	private List<String> fileNamen;
	private List<File> nachNameGefiltert;
	private List<File> nachNameUndGrößeGefiltert;
	
	@Override
	public List<IDublette> sammleKandidaten(String pfad) {
		initialisiereListen();
		findeDateien(new File(pfad));
		findeKandidatenAusListe();
		
		return kandidaten;
	}

	private void initialisiereListen() {
		kandidaten = new LinkedList<IDublette>();
		filesUnterRoot = new LinkedList<File>();
		fileNamen = new LinkedList<String>();
		nachNameGefiltert = new LinkedList<File>();
		nachNameUndGrößeGefiltert = new LinkedList<File>();
	}

	private void findeKandidatenAusListe() {
		for(File file: filesUnterRoot) {
			if (häufigkeitFilename(file) > 1) {
				addeKandidaten(file);
				fileNamen.remove(file.getName());
			}
		}
	}

	private int häufigkeitFilename(File file) {
		return Collections.frequency(fileNamen, file.getName());
	}

	private void addeKandidaten(File file) {
		Dublette dublette = new Dublette();

		nachNameGefiltert = filtereListeNachNamen(file.getName());
		nachNameUndGrößeGefiltert = filtereListeNachGröße(file.length());
		
		for(File gefilterterFile : nachNameUndGrößeGefiltert) {
			dublette.addDateipfad(gefilterterFile.getPath());
		}

		if(dublette.getDateipfade().size() > 1) kandidaten.add(dublette);
	}

	private void findeDateien(File basisPfad) {
		if (!(basisPfad.listFiles() == null)) {
			durchsucheVerzeichnis(basisPfad);	
		}
	}

	private void durchsucheVerzeichnis(File basisPfad) {
		for(File fileInDirectory : basisPfad.listFiles()) {
			if(fileInDirectory.isFile()) {
				filesUnterRoot.add(fileInDirectory);
				fileNamen.add(fileInDirectory.getName());
			} else {
				findeDateien(fileInDirectory);
			}
		}
	}
	
	private List<File> filtereListeNachGröße(long fileSize) {
		return nachNameGefiltert.stream().filter(fileToFilter -> fileToFilter.length() == fileSize).collect(Collectors.toList());
	}
	
	private List<File> filtereListeNachNamen(String fileName) {
		return filesUnterRoot.stream().filter(fileToFiler -> fileToFiler.getName().equals(fileName)).collect(Collectors.toList());
	}

}
