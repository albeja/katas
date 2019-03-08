package mineSweeperHack;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MinesweeperGameReader {
	public String readGameFile(String absolutePath) {
		String gameAsString = null;
		
		try {
			BufferedReader reader = createReader(absolutePath);
		    gameAsString = readTextFromReader(reader);
		    reader.close();
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		};
		
		return gameAsString;
	}

	private String readTextFromReader(BufferedReader reader) throws IOException {
		String line = null;
		String gameAsString = null;
				
		while ((line = reader.readLine()) != null) {
		    gameAsString += line ;
		    gameAsString += "\r\n";
		}
		
		reader.close();
		
		return gameAsString;
	}
	
	private BufferedReader createReader(String absolutePath) throws IOException {
		return Files.newBufferedReader(Paths.get(absolutePath), Charset.forName("US-ASCII"));
	}
}
