package dubletten;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Dublettenpruefung implements IDublettenpruefung {
	private FileFinder finder = new FileFinder();
	
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
		List<IDublette> echteDubletten = new LinkedList<IDublette>();
		
		for(IDublette dublette : kandidaten) {
			if(isEchteDublette(dublette)) echteDubletten.add(dublette);
		}
		
		return echteDubletten;
	}
	
	private boolean isEchteDublette(IDublette dublette) {
		List<File> files = dublette.getDateipfade().stream().map(path -> new File(path)).collect(Collectors.toList());
		
		List<File >filteredFiles = getListFilteredByFirstElement(files);				
		
		return files.containsAll(filteredFiles) && filteredFiles.containsAll(files);
	}

	private List<File> getListFilteredByFirstElement(List<File> files) {
		return files.stream().filter(fileToFilter -> {
			try {
				return haveFilesSameContent(fileToFilter, files.get(0));
			} catch (IOException e) {
				return false;
			}
		}).collect(Collectors.toList());
	}
	
	
	private boolean haveFilesSameContent(File firstFile, File secondFile) throws IOException {
		BufferedReader readerFirstFile = new BufferedReader(new FileReader(firstFile));
		BufferedReader readerSecondFile = new BufferedReader(new FileReader(secondFile));			
	    int charValueFileOne = 0;
	    int charValueFileTwo = 0;
	    boolean haveSameContent = true;
	    
		while(charValueFileTwo != -1) {
			charValueFileOne = readerFirstFile.read();
			charValueFileTwo = readerSecondFile.read();

			if(charValueFileOne != charValueFileTwo ) haveSameContent = false; break;
		}

		readerFirstFile.close();
		readerSecondFile.close();
		return haveSameContent;
	}
}
