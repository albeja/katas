package dubletten;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import org.junit.Test;

public class ComparisonFileWriterTest {

	@Test
	public void testSchreibeDublettenInDatei() throws IOException {
		String filename = "C:\\Users\\jvonalbedyll\\eclipse-workspace\\"+"dubletten_ergebnis_"+Instant.now().getEpochSecond()+".txt";
		ComparisonFileWriter.schreibeDublettenInDatei(filename, "C:\\Users\\jvonalbedyll\\eclipse-workspace\\testdir_duplicates");

		File createdFile = new File(filename);
		assertTrue(createdFile.isFile());
		assertTrue(createdFile.length() > 0);
		
		assertFileContentEquals(createdFile, new File("C:\\Users\\jvonalbedyll\\eclipse-workspace\\dubletten_ergebnis_vergleichsfile.txt"));
		
	}

	private void assertFileContentEquals(File createdFile, File comparison) throws FileNotFoundException, IOException {
		BufferedReader readerActualFile = new BufferedReader(new FileReader(createdFile));
		BufferedReader readerExpectedFile = new BufferedReader(new FileReader(comparison));			
		String lineActualFile = "";
		String lineExpectedFile = "";
		
		while(lineActualFile != null) {
			assertTrue(lineActualFile.equals(lineExpectedFile));
			lineActualFile = readerActualFile.readLine();
			lineExpectedFile = readerExpectedFile.readLine();
		}

		readerActualFile.close();
		readerExpectedFile.close();
	}

}
