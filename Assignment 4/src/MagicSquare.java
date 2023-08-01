import java.util.Arrays;
public class MagicSquare {

	private int confirmedNumber[][];
	private int finalConst;
	private String arrayString;
	private int rowCounter;
	
	MagicSquare(int confNum[][], int numConst, int numRows){
		confirmedNumber = confNum;
		finalConst = numConst;
		rowCounter = numRows;
		arrayString = Arrays.deepToString(confirmedNumber);
		arrayString = arrayString.replaceAll("\\[", "").replaceAll("\\]","");
	}
	
	public String toString() {
		return "The combination of numbers " + arrayString + " is a magic square order of " + rowCounter + ". The magic constant is " + finalConst + ".";
	}
}
