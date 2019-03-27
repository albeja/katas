package dubletten;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import dubletten.IDublettenpruefung.IDublette;

public class ComparisonFileWriter {
	public static void schreibeDublettenInDatei(String zielpfad, String vergleichsroot) throws IOException {
		File newFile = new File(zielpfad);
		newFile.createNewFile();
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(newFile));
		
		Dublettenpruefung pruefung = new Dublettenpruefung();
		List<IDublette> kandidaten = pruefung.sammleKandidaten(vergleichsroot);
		List<IDublette> dubletten = pruefung.prüfeKandidaten(kandidaten);
		
		for(int ctr=1; ctr<=dubletten.size(); ctr++) {
			writer.write("Dublette " + ctr); writer.newLine();
			for(String pfad : dubletten.get(ctr-1).getDateipfade()) {
				writer.write("Pfad: " + pfad); writer.newLine();
			}
		}
		
		writer.close();
	}
	
	
	public static void main(String[] args) {
		//TODO: Gui bauen
		
		try {
			schreibeDublettenInDatei("C:\\Users\\jvonalbedyll\\eclipse-workspace\\program_files.txt", "C:\\Program Files");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
