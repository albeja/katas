package dubletten;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import dubletten.IDublettenpruefung.IDublette;

public class CandidateCheck {
	public List<IDublette> prüfeKandidaten(List<IDublette> kandidaten) {
		List<IDublette> echteDubletten = new LinkedList<IDublette>();
		
		for(IDublette dublette : kandidaten) {
			if(isEchteDublette(dublette)) echteDubletten.add(dublette);
		}
		
		return echteDubletten;
	}
	
	private boolean isEchteDublette(IDublette dublette) {
		List<File> files = dublette.getDateipfade().stream().map(path -> new File(path)).collect(Collectors.toList());
		
		List<File> filteredFiles = getListFilteredByFirstElement(files);				
		
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
