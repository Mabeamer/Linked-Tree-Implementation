
import java.util.Scanner;
import java.io.IOException;
public class Main {
	
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		String numberFilename = "";
		
		//asking the user for the file name they want to use
		//filenames are pass.txt and fail.txt
		System.out.println("Please give a filename");
		numberFilename = input.nextLine();
		
		MagicSquareDetector newSquare = new MagicSquareDetector(numberFilename);
		
		newSquare.sDetector();
	}
	
	
}
