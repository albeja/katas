package nBack;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

public class NBackApplicationTest {
	private NBackApplication application = new NBackApplication();

	@Test
	public void starteTest100() {
		Scanner scanner = new Scanner("n n n n j j j n j j n j j n n n n n n n");
		assertEquals(100, Math.round(application.starteTest(3, 500, "CBAABAAAAACAADDEFGHI", scanner)));
	}

	@Test
	public void starteTest0() {
		Scanner scanner = new Scanner("j j j j n n n j n n j n n j j j j j j j");
		assertEquals(0, Math.round(application.starteTest(3, 500, "CBAABAAAAACAADDEFGHI", scanner)));
	}
	
	@Test
	public void starteTest50() {
		Scanner scanner = new Scanner("j j j j n n n j n n n j j n n n n n n n");
		assertEquals(50, Math.round(application.starteTest(3, 500, "CBAABAAAAACAADDEFGHI", scanner)));
	}
}
