package mineSweeperHack;

public class MinesweeperEngine {
	private char[][] parsedFields;
	private char[][] numbers;
	
	public String getSolution(String mineField) {
		parseInput(mineField);
		generateNumbers();
		return generateSolutionString();
	}
	
	private String generateSolutionString() {
		String mineField = "";
		
		for(int line=0; line<numbers.length; line++) {
			mineField = mineField.concat(generateLineString(line));
		}		
		
		return mineField;
	}

	private String generateLineString(int lineIndex) {
		String lineString = "";
		
		for(int column=0; column<numbers[lineIndex].length; column++) {
			lineString = lineString + numbers[lineIndex][column];
		}
		
		lineString = lineString + "\r\n";
		
		return lineString;
	}

	private void generateNumbers() {
		for(int line=0; line<parsedFields.length; line++) {
			for(int column=0; column<parsedFields[line].length; column++) {
				generateNumber(line, column);
			}
		}		
	}

	private void generateNumber(int line, int column) {
		if (isBomb(line, column)) numbers[line][column] = '*';
		else numbers[line][column] = Character.forDigit(countBombsAround(line, column), 10);
	}

	private boolean isBomb(int line, int column) {
		try {
			return parsedFields[line][column] == '*';			
		} catch (Exception e) {
			return false;
		}
	}

	private int countBombsAround(int currentLine, int currentColumn) {
		int numberOfBombs = 0;
		
		if (isBomb(currentLine, currentColumn - 1)) numberOfBombs++;
		if (isBomb(currentLine - 1, currentColumn - 1)) numberOfBombs++;
		if (isBomb(currentLine - 1, currentColumn)) numberOfBombs++;
		if (isBomb(currentLine - 1, currentColumn + 1)) numberOfBombs++;
		if (isBomb(currentLine, currentColumn + 1)) numberOfBombs++;
		if (isBomb(currentLine + 1, currentColumn + 1)) numberOfBombs++;
		if (isBomb(currentLine + 1, currentColumn)) numberOfBombs++;
		if (isBomb(currentLine + 1, currentColumn - 1)) numberOfBombs++;
		
		return numberOfBombs;	
	}

	private void parseInput(String mineField) {
		String[] parsedLines = mineField.split("\r\n");
				
		initializeParsedField(parsedLines);
		initizalizeNumbers(parsedLines);
	}

	private void initizalizeNumbers(String[] parsedLines) {
		this.numbers = new char[parsedLines.length][parsedLines[0].length()];
	}

	private void initializeParsedField(String[] parsedLines) {
		this.parsedFields = new char[parsedLines.length][parsedLines[0].length()];
		
		for(int lineCtr=0;lineCtr<parsedLines.length;lineCtr++) {
			this.parsedFields[lineCtr] = parsedLines[lineCtr].toCharArray();
		}
	}
}
