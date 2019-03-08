package mineSweeperHack;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

public class MinesweeperGameReaderTest {
	private MinesweeperGameReader reader = new MinesweeperGameReader();
	
	@Before
	public void setUp() throws Exception {
		
	}

	private Path createFile(String content, String filePrefix) {
		try {
			Path tempPath = Paths.get(System.getProperty("user.dir"));
		    Path tempFile = Files.createTempFile(tempPath, filePrefix, ".txt");
		    
		    BufferedWriter writer = Files.newBufferedWriter(tempFile, Charset.forName("US-ASCII"));
	        writer.write(content, 0, content.length());
	        writer.close();
	        
	        System.out.format("The temporary file" + " has been created: %s%n", tempFile);
	        return tempFile;
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
		
		return null;
	}

	@Test
	public void readGameFileTest() {
		Path minesweeperFile = createFile(	"*...\r\n" + 
											"....\r\n" + 
											".*..\r\n" + 
											"....\r\n", "unittest_");
		String actualGame = reader.readGameFile(minesweeperFile.toString());
		String expectedGame = 	"*...\r\n" + 
								"....\r\n" + 
								".*..\r\n" + 
								"....\r\n";
		
		assertEquals(expectedGame, actualGame);
		
	}

}
