import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class MagicSquareDetector {

	private String fileName;
	
	MagicSquareDetector(String fName){
		fileName = fName;
	}
	//this method is checking the file line by line to see if it is a magic square
	
	
	public String sDetector() throws IOException {
		//create a scanner that looks into the file and reads it
		//System.out.println(fileName);
		// this is poor but read file twice, once to get a static number to set the dynamic array
		Scanner readingLineNum = new Scanner(new File(fileName));
		Scanner fileInput = new Scanner(new File(fileName));
		
		int row = 0;
		int column = 0;
		//MENTAL NOTE: there are 3 arrays that hold 3 numbers {{1,2,3}{4,5,6}{7,8,9}}
		
		while(readingLineNum.hasNext()) {
			row++;
			String[] splitLen = readingLineNum.nextLine().split(" ");
			column = splitLen.length;
			//System.out.println(row);
			//System.out.println(column);
		}
		
		
		//System.out.println("entering other loop");
		int[][] numbers = new int [row][column];
		while(fileInput.hasNext()) {
			//split the current line by space then parse the ints?
			for(int i = 0; i < row; i++) {
				//System.out.println(fileInput.nextLine());
				String[] splitArray = fileInput.nextLine().split(" ");
				//creating for loop to go through and add the numbers to the proper array
				//System.out.println("going into loop");
				try {
					for(int j = 0; j < column; j++) {
						numbers[i][j] = Integer.parseInt(splitArray[j]);
						//System.out.println(numbers[i][j] + "split");
					}
				}catch(ArrayIndexOutOfBoundsException e) {
					System.out.println("Your rows and columns do not make a square, please check your file.");
				}
					
			}
		


			
			
			//once the above has been sorted out we will now go into our check to see if this array is a square
			boolean magicCheck = true;
			int magicConst = 0;
			int constCheck = 0;
			//test
			//System.out.println("Starting magic check");
				//create a loop to check the first row to get the consistent this will be our base
				
				for(int n = 0; n < numbers[0].length; n++) {
					magicConst += numbers[0][n];
					//System.out.println("cosnt =" + magicConst);
				}
				
				//now we begin the check of our arrays
				//first for loop checks through the actualy rows itself
				for(int n = 0; n < column; n++) {
					
					int z = 0;
					//System.out.println("looping " + numbers[n][z]);
					//checking horizontal rows
					try {
						for(int j = 0; j < row; j++) {
							z += numbers[n][j];
							//System.out.println(z);
						}
					}catch(ArrayIndexOutOfBoundsException e) {
						System.out.println("Your rows and columns do not make a square, please check your file.");
					}
					
					if(z != magicConst) {
						//System.out.println("False!");
						magicCheck = false;
					}
					//reset z for another check
					z = 0;
					
					//checking vert rows
					try {
						for(int j = 0; j < row; j++) {
							z += numbers[j][n];
							//System.out.println(z + " checking vert " + numbers[j][n]);
						}
					}catch(ArrayIndexOutOfBoundsException e) {
						System.out.println("Your rows and columns do not make a square, please check your file.");
					}
					if(z != magicConst) {
						//System.out.println("False!");
						magicCheck = false;
					}
					
					//reset z for the next check
					z = 0;
					
					//checking diag rows
					try {
						for(int j = 0; j < row; j++) {
							z+= numbers[j][j];
							//System.out.println(z + " checking diag left " + numbers[j][j]);
						}
					}catch(ArrayIndexOutOfBoundsException e) {
						System.out.println("Your rows and columns do not make a square, please check your file.");
					}
					if(z != magicConst) {
						//System.out.println("False!");
						magicCheck = false;
					}
					
					//reset z for the diag right check
					z = 0;
					
					//checking diag ros
					//System.out.println(row + " " + column);
					try {
						for(int j = row - 1; j >= 0; j--) {
							z+= numbers[j][j];
							//System.out.println(z + " checking diag right " + numbers[j][j]);
						}
					}catch(ArrayIndexOutOfBoundsException e) {
						System.out.println("Your rows and columns do not make a square, please check your file.");
					}
					//System.out.println("breaking out the inner loop");
					//after each round through resets check to 0 to start for another two numbers
					constCheck = 0;
				}
				//System.out.println(magicConst + " is is the magic consistent");
			//failure state and end the program there
			if(magicCheck == false) {
				String failureArray = Arrays.deepToString(numbers);
				failureArray = failureArray.replaceAll("\\[", "").replaceAll("\\]","");
				System.out.println("These numbers do not make up a magic square. " + failureArray + ".");
			}
			//move on from here, create a new object that collects the array and sends it to another class
			if(magicCheck == true) {
				//move on from here
				MagicSquare completeArray = new MagicSquare(numbers, magicConst, row);
				System.out.println(completeArray.toString());
			}
			
		}
		return fileName;
	}
	
}
