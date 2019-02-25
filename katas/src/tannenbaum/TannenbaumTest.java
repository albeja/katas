package tannenbaum;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TannenbaumTest {
	public Tannenbaum baum;
	
	@Before
	public void setup() {
		baum = new Tannenbaum();
	}
	
	@Test
	public void outputOhneStern() {
		String erwarteterOutput = 	"    X    \r\n" + 
									"   XXX   \r\n" + 
									"  XXXXX  \r\n" + 
									" XXXXXXX \r\n" + 
									"XXXXXXXXX\r\n" + 
									"    I    ";
		
		assertEquals(erwarteterOutput, baum.zeichnen(5));
	}

}
