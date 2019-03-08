package mineSweeperHack;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MinesweeperGameReader {
	public String readGameFile(String absolutePath) {
		String gameAsString = "";
		Charset charset = Charset.forName("US-ASCII");
		try (BufferedReader reader = Files.newBufferedReader(Paths.get(absolutePath), charset)) {
		    String line = null;
		    while ((line = reader.readLine()) != null) {
		        gameAsString += line ;
		        gameAsString += "\r\n";
		    }
		    reader.close();
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		};
		
		return gameAsString;
	}

}
