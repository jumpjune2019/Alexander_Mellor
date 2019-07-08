import java.lang.Math;
import java.util.Scanner;
public class Main {
	private static byte roll6SidedDie() {
		// Function that returns a number between 1 and 6 to simulate a 6 sided die roll
		int test = (int)Math.floor(Math.random() * 6) + 1;
		byte roll = (byte)test;
		return roll;
	}
	private static void clearScreen() {
		// Clears a terminal screen
		System.out.println("\033[H\033[2J");  
		System.out.flush();
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char answer;
		System.out.println("Press any key to throw a die and press Enter (or Q and Enter to quit)");
		answer = in.nextLine().toLowerCase().charAt(0);	// Gets a string from input object, converts string to lower case, takes the first char object in the string, Closes the input object, Returns the char
		if(answer == 'q') {
			// Checks if user input is equivalent to q and exits the program if true
			System.exit(0);
		}
		do {
			clearScreen();
			System.out.println("You have rolled a " + (int)roll6SidedDie());
			System.out.println("Play Again? (Y or y) and Enter, any other key and Enter to Quit");
			answer = in.nextLine().toLowerCase().charAt(0);	// Gets a string from input object, converts string to lower case, takes the first char object in the string, Closes the input object, Returns the char
		}while(answer == 'y');
		in.close();
	}
}
