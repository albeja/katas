package dubletten;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Dublettenpruefung implements IDublettenpruefung {
	private List<File> filesUnterRoot;
	private FileFinder finder = new FileFinder();
	
	@Override
	public List<IDublette> sammleKandidaten(String pfad) {		
		filesUnterRoot = finder.findeDateien(pfad);
		return findeKandidatenAusListe();
	}

	private List<IDublette> findeKandidatenAusListe() {
		List<IDublette> kandidatenListe = new LinkedList<IDublette>();

		while(filesUnterRoot.isEmpty() == false) {
			List<File> nachNameUndGr��eGefiltert = filtereListeNachNamenUndGr��e(filesUnterRoot.get(0), filesUnterRoot);
			
			if (nachNameUndGr��eGefiltert.size() > 1) {
				kandidatenListe.add(baueDublettenkandidat(nachNameUndGr��eGefiltert));
			}
			
			filesUnterRoot.remove(0);
		}
		
		return kandidatenListe;
	}

	private Dublette baueDublettenkandidat(List<File> nachNameUndGr��eGefiltert) {
		Dublette dublette = new Dublette();
		for(File gefilterterFile : nachNameUndGr��eGefiltert) {
			dublette.addDateipfad(gefilterterFile.getPath());
		}
		return dublette;
	}
	
	private List<File> filtereListeNachNamenUndGr��e(File file, List<File> fileList) {
		List<File> nachNameGefiltert = fileList.stream().filter(fileToFiler -> fileToFiler.getName().equals(file.getName())).collect(Collectors.toList());
		return nachNameGefiltert.stream().filter(fileToFilter -> fileToFilter.length() == file.length()).collect(Collectors.toList());
	}

}
