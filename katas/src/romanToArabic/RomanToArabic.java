package romanToArabic;

public class RomanToArabic {
	public int convertRoman(String romanNumber) {
		if (romanNumber.length() > 1) {
			return convertNonBasic(romanNumber);
		} else {
			return convertBasics(romanNumber);
		}
	}
	
	private int convertBasics(String basicLetter) {
		if(basicLetter.contains("M")) return 1000;
		if(basicLetter.contains("D")) return 500;
		if(basicLetter.contains("C")) return 100;
		if(basicLetter.contains("L")) return 50;
		if(basicLetter.contains("X")) return 10;
		if(basicLetter.contains("V")) return 5;
		if(basicLetter.contains("I")) return 1;
		
		return 0;
	}
	
	private int convertNonBasic(String nonBasicNumber) {
		if(nonBasicNumber.contains("M")) return calculateNumber(nonBasicNumber, "M");
		if(nonBasicNumber.contains("D")) return calculateNumber(nonBasicNumber, "D");
		if(nonBasicNumber.contains("C")) return calculateNumber(nonBasicNumber, "C");
		if(nonBasicNumber.contains("L")) return calculateNumber(nonBasicNumber, "L");
		if(nonBasicNumber.contains("X")) return calculateNumber(nonBasicNumber, "X");
		if(nonBasicNumber.contains("V")) return calculateNumber(nonBasicNumber, "V");
		if(nonBasicNumber.contains("I")) return 1 + convertRoman(nonBasicNumber.substring(1, nonBasicNumber.length()));
		
		return 0;
	}
	
	private int calculateNumber(String nonBasicNumber, String romanBase) {
		int basePosition = nonBasicNumber.indexOf(romanBase);
		return -convertRoman(nonBasicNumber.substring(0, basePosition)) + convertBasics(romanBase) + convertRoman(nonBasicNumber.substring(basePosition + 1, nonBasicNumber.length()));
	}
}
