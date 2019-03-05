package mineSweeperHack;

import static org.junit.Assert.*;

import org.junit.Test;

public class MinesweeperEngineTest {
	private MinesweeperEngine engine = new MinesweeperEngine();

	@Test
	public void engineGetSolution4to4() {
		String mineField = 	"*...\r\n" + 
							"....\r\n" + 
							".*..\r\n" + 
							"....";
		String expectedSolution = 	"*100\r\n" + 
									"2210\r\n" + 
									"1*10\r\n" + 
									"1110\r\n";
		
		assertEquals(expectedSolution, engine.getSolution(mineField));
	}
	
	@Test
	public void engineGetSolution3to5() {
		String mineField = 	"**...\r\n" + 
							".....\r\n" + 
							".*...\r\n"; 
		
		String expectedSolution = 	"**100\r\n" + 
									"33200\r\n" + 
									"1*100\r\n"; 
		
		assertEquals(expectedSolution, engine.getSolution(mineField));
	}

}
