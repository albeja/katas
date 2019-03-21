package dubletten;

import static org.junit.Assert.*;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class FileFinderTest {
	FileFinder finder = new FileFinder();

	@Test
	public void testFileFinder() {
		List<File> files = finder.findeDateien("C:\\Users\\jvonalbedyll\\eclipse-workspace\\testdir_duplicates");
		
		List<File> expectedFiles = new LinkedList<File>();
		expectedFiles.add(new File("C:\\Users\\jvonalbedyll\\eclipse-workspace\\testdir_duplicates\\demo_duplicate.txt"));
		expectedFiles.add(new File("C:\\Users\\jvonalbedyll\\eclipse-workspace\\testdir_duplicates\\demo_false_duplicate.txt"));
		expectedFiles.add(new File("C:\\Users\\jvonalbedyll\\eclipse-workspace\\testdir_duplicates\\demo_unique.txt"));
		expectedFiles.add(new File("C:\\Users\\jvonalbedyll\\eclipse-workspace\\testdir_duplicates\\testdir\\demo_duplicate.txt"));
		expectedFiles.add(new File("C:\\Users\\jvonalbedyll\\eclipse-workspace\\testdir_duplicates\\testdir\\demo_false_duplicate.txt"));
		
		assertEquals(5, files.size());
		assertTrue(files.containsAll(expectedFiles));
		assertTrue(expectedFiles.containsAll(files));
		
		files = finder.findeDateien("C:\\Users\\jvonalbedyll\\eclipse-workspace\\testdir_duplicates");
		assertEquals(5, files.size());
	}

}
