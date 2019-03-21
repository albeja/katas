package dubletten;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class FileFinder {
	private List<File> filesUnterRoot = new LinkedList<File>();
	
	public List<File> findeDateien(String basisPfad) {
		filesUnterRoot = new LinkedList<File>();
		
		durchsucheVerzeichnis(new File(basisPfad));	

		return filesUnterRoot;
	}

	private void durchsucheVerzeichnis(File root) {
		if (!(root.listFiles() == null)) {
			for(File fileInDirectory : root.listFiles()) {
				if(fileInDirectory.isFile()) {
					filesUnterRoot.add(fileInDirectory);
				} else {
					durchsucheVerzeichnis(fileInDirectory);
				}
			}
		}
	}
	
}
