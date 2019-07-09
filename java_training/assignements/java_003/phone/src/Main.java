import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));	// Opens a buffered reader for the console.
	private static String getUserInput() {
		// Uses reader to get input from console
		String inputString = "";
		try{
			inputString = reader.readLine();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return inputString;
	}
	private static void writeToFile(String arrayIn[][], byte row, byte column) {
		// Writes content of array into a file.
		File file = new File("phone.txt");
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
			if(!file.exists()) {
				file.createNewFile();
			}
			StringBuilder builder = new StringBuilder();
			builder.append("Phone Book App\n");
			for(byte i = 0; i < column; i++) {
				if(i == 0) {
					builder.append("Name:");
				}else if(i == 1) {
					builder.append("Phone Number:");
				}else if (i == 2) {
					builder.append("City:");
				}
				builder.append("\t");
			}
			builder.append("\n");
			for(byte x = 0; x < row; x++) {
				for(byte y = 0; y < column; y++) {
					builder.append(arrayIn[x][y]);
					if(y < arrayIn.length - 1) {
						builder.append("\t\t");
					}
				}
				builder.append("\n");
			}
			bw.write(builder.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return;
	}
	private static void closeReader() {
		// Closes the reader object.
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		boolean askAgain = false;
		boolean doRowOver;
		byte numOfColumns = 3;
		byte numOfRows = 5;
		String userInputString;
		String phoneBook[][] = new String[numOfRows][numOfColumns];
		// Start of program logic
		System.out.println("Welcome to the Phone Book App");
		System.out.println("Please input the values prompted when prompted");
		// Input values into array
		for(byte x = 0; x < numOfRows; x++) {	// Row
			do {
				for(byte y = 0; y < numOfColumns; y++) {	// Column
					do {	// Loop Checks if input string is empty or blank and asks user again
						try {
							// Displays what user needs to input based on column id
							if(y == 0) {
								System.out.println("Name: ");
							}else if(y == 1) {
								System.out.println("Phone Number: ");
							}else if (y == 2) {
								System.out.println("City: ");
							}
							userInputString = getUserInput();
							if(userInputString.isEmpty() || userInputString.isBlank()) {
								throw new UserInputEmpty();
							}
							phoneBook[x][y] = userInputString;
							askAgain = true;
						}catch(UserInputEmpty e) {
							System.out.println(e);
							askAgain = false;
						}
					}while(!askAgain);
					// This block is for testing 
	//				if(y == 0) {
	//					phoneBook[x][y] = "name";
	//				}else if(y == 1) {
	//					phoneBook[x][y] = "number";
	//				}else if (y == 2) {
	//					phoneBook[x][y] = "city";
	//				}
				}
				// Checks if user wants to keep the row values
				System.out.println("You input the following values");
				for(byte i = 0; i < numOfColumns; i++) {
					System.out.print(phoneBook[x][i] + " ");
				}
				System.out.print("\n");
				System.out.println("Is this all right? (any key for yes/n for no)");
				userInputString = getUserInput();
				if(userInputString.toLowerCase().charAt(0) == 'n') {
					doRowOver = true;
				}else {
					doRowOver = false;
				}
			}while(doRowOver);
		}
		System.out.println("Do You want the output to file (f) or console (c) or both (any other key)?");
		userInputString = getUserInput();
		closeReader();	// Closes the buffered reader on the console.
		if(userInputString.toLowerCase().charAt(0) == 'c') {
			System.out.println("Phone Book App");
			for(byte i = 0; i < numOfColumns; i++) {
				if(i == 0) {
					System.out.print("Name:");
				}else if(i == 1) {
					System.out.print("Phone Number:");
				}else if (i == 2) {
					System.out.print("City:");
				}
				System.out.print("\t");
			}
			System.out.print("\n");
			for(byte x = 0; x < numOfRows; x++) {	// Row
				for(byte y = 0; y < numOfColumns; y++) {	// Column
					System.out.print(phoneBook[x][y] + "\t");
				}
				System.out.print("\n");
			}
		}else if(userInputString.toLowerCase().charAt(0) == 'f') {
			writeToFile(phoneBook, numOfRows, numOfColumns);
		}else{
			writeToFile(phoneBook, numOfRows, numOfColumns);
			System.out.println("Phone Book App");
			for(byte i = 0; i < numOfColumns; i++) {
				if(i == 0) {
					System.out.print("Name:");
				}else if(i == 1) {
					System.out.print("Phone Number:");
				}else if (i == 2) {
					System.out.print("City:");
				}
				System.out.print("\t");
			}
			System.out.print("\n");
			for(byte x = 0; x < 5; x++) {	// Row
				for(byte y = 0; y < 3; y++) {	// Column
					System.out.print(phoneBook[x][y] + "\t");
				}
				System.out.print("\n");
			}
		}
	}
}
