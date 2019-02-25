package romanToArabic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RomanToArabicTests {
	public RomanToArabic converter;
	
	@Before
	public void setup(){
		converter = new RomanToArabic();
	}
	
	@Test
	public void testBaseValues() {
		assertEquals(1, converter.convertRoman("I"));
		assertEquals(5, converter.convertRoman("V"));
		assertEquals(10, converter.convertRoman("X"));
		assertEquals(50, converter.convertRoman("L"));
		assertEquals(100, converter.convertRoman("C"));
		assertEquals(500, converter.convertRoman("D"));
		assertEquals(1000, converter.convertRoman("M"));
	}

	@Test
	public void testDecimals() {
		assertEquals(2, converter.convertRoman("II"));
		assertEquals(3, converter.convertRoman("III"));
		assertEquals(4, converter.convertRoman("IV"));
		assertEquals(6, converter.convertRoman("VI"));
		assertEquals(9, converter.convertRoman("IX"));
	}
	
	@Test
	public void testDecadicsUntilFourty() {
		assertEquals(11, converter.convertRoman("XI"));
		assertEquals(12, converter.convertRoman("XII"));
		assertEquals(14, converter.convertRoman("XIV"));
		assertEquals(15, converter.convertRoman("XV"));
		assertEquals(16, converter.convertRoman("XVI"));
		assertEquals(19, converter.convertRoman("XIX"));
		assertEquals(20, converter.convertRoman("XX"));
		assertEquals(21, converter.convertRoman("XXI"));
		assertEquals(24, converter.convertRoman("XXIV"));
		assertEquals(26, converter.convertRoman("XXVI"));
	}
	
	@Test
	public void testDecadicsUntilNinety() {
		assertEquals(40, converter.convertRoman("XL"));
		assertEquals(41, converter.convertRoman("XLI"));
		assertEquals(44, converter.convertRoman("XLIV"));
		assertEquals(49, converter.convertRoman("XLIX"));
		assertEquals(51, converter.convertRoman("LI"));
		assertEquals(54, converter.convertRoman("LIV"));
	}
	
	@Test
	public void testHundredsUntilFourhundred() {
		assertEquals(90, converter.convertRoman("XC"));
		assertEquals(91, converter.convertRoman("XCI"));
		assertEquals(99, converter.convertRoman("XCIX"));
		assertEquals(101, converter.convertRoman("CI"));
		assertEquals(111, converter.convertRoman("CXI"));
		assertEquals(149, converter.convertRoman("XCLIX"));
		assertEquals(190, converter.convertRoman("CXC"));
		assertEquals(399, converter.convertRoman("CCCXCIX"));
	}
	
	@Test
	public void testHundredsUntilNinehundred() {
		assertEquals(400, converter.convertRoman("CD"));
		assertEquals(449, converter.convertRoman("CDXLIX"));
		assertEquals(649, converter.convertRoman("DCXLIX"));
		assertEquals(899, converter.convertRoman("DCCCXCIX"));
	}
	
	@Test
	public void testOverNinehundred() {
		assertEquals(900, converter.convertRoman("CM"));
		assertEquals(999, converter.convertRoman("CMXCIX"));
		assertEquals(1049, converter.convertRoman("MXLIX"));
		assertEquals(1401, converter.convertRoman("MCDI"));
		assertEquals(1899, converter.convertRoman("MDCCCXCIX"));
		assertEquals(2499, converter.convertRoman("MMCDXCIX"));
	}
}
