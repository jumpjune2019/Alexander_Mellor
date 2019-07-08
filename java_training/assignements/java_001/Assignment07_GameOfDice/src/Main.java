import java.util.Scanner;
public class Main {
	private static byte roll6SidedDie() {
		// Function that returns a number between 1 and 6 to simulate a 6 sided die roll
		int test = (int)Math.floor(Math.random() * 6) + 1;
		byte roll = (byte)test;
		return roll;
	}
	private static void computerWin(byte playerArr[], byte computerArr[], String playerType, String computerType) {
		System.out.println("You have rolled a " + playerArr[0] + " and " + playerArr[1] + " > the " + playerType);
		System.out.println("I have rolled a " + computerArr[0] + " and " + computerArr[1] + " > the " + computerType);
		System.out.println("I win!!!");
		System.out.println("Wanna try again? Press any key and ENTER to throw your dice or press (Q or q) to quit");
		return;
	}
	private static void computerWinDouble(byte playerArr[], byte computerArr[], String playerType, String computerType) {
		System.out.println("You have rolled a " + playerArr[0] + " and " + playerArr[1] + " > the " + playerType);
		System.out.println("I have rolled a " + computerArr[0] + " and " + computerArr[1] + " > the " + computerType);
		System.out.println("Damn! I win on a Double! Ah! I pity you fool!");
		System.out.println("Wanna try again? Press any key and ENTER to throw your dice or press (Q or q) to quit");
		return;
	}
	private static void computerLoss(byte playerArr[], byte computerArr[], String playerType, String computerType) {
		System.out.println("You have rolled a " + playerArr[0] + " and " + playerArr[1] + " > the " + playerType);
		System.out.println("I have rolled a " + computerArr[0] + " and " + computerArr[1] + " > the " + computerType);
		System.out.println("You win!!!");
		System.out.println("Did you cheat?? Gimme another try, c’mon Press any key and ENTER to throw your dice or press (Q or q) to quit");
		return;
	}
	private static void computerLossDouble(byte playerArr[], byte computerArr[], String playerType, String computerType) {
		System.out.println("You have rolled a " + playerArr[0] + " and " + playerArr[1] + " > the " + playerType);
		System.out.println("I have rolled a " + computerArr[0] + " and " + computerArr[1] + " > the " + computerType);
		System.out.println("Damn! You win on a Double! What Luck!");
		System.out.println("Did you cheat?? Gimme another try, c’mon Press any key and ENTER to throw your dice or press (Q or q) to quit");
		return;
	}
	private static void trueTie(byte playerArr[], byte computerArr[], String playerType, String computerType) {
		System.out.println("You have rolled a " + playerArr[0] + " and " + playerArr[1] + " > the " + playerType);
		System.out.println("I have rolled a " + computerArr[0] + " and " + computerArr[1] + " > the " + computerType);
		System.out.println("Stalemate! You’re tough, let’s try for a tie-breaker Press any key and ENTER to throw your dice or press (Q or q) to quit");
		return;
	}
	private static String rollType(byte rollArr[]) {
		String type = "";
		if(rollArr[0] == 1 && rollArr[1] == 1) {
			type = "Snake Eyes";
		}else if(rollArr[0] == 1 && rollArr[1] == 2) {
			type = "Astrailian Yo";
		}else if(rollArr[0] == 1 && rollArr[1] == 3) {
			type = "Little Jo From Kokomo";
		}else if(rollArr[0] == 1 && rollArr[1] == 4) {
			type = "No Field Five";
		}else if(rollArr[0] == 1 && rollArr[1] == 5) {
			type = "Easy Six";
		}else if(rollArr[0] == 1 && rollArr[1] == 6) {
			type = "Six One You're Done";
		}else if(rollArr[0] == 2 && rollArr[1] == 1) {
			type = "Ace Caught A Duece";
		}else if(rollArr[0] == 2 && rollArr[1] == 2) {
			type = "Ballarena";
		}else if(rollArr[0] == 2 && rollArr[1] == 3) {
			type = "The Fever";
		}else if(rollArr[0] == 2 && rollArr[1] == 4) {
			type = "Jimmie Hicks";
		}else if(rollArr[0] == 2 && rollArr[1] == 5) {
			type = "Benny Blue";
		}else if(rollArr[0] == 2 && rollArr[1] == 6) {
			type = "Easy Eight";
		}else if(rollArr[0] == 3 && rollArr[1] == 1) {
			type = "Easy Four";
		}else if(rollArr[0] == 3 && rollArr[1] == 2) {
			type = "OJ";
		}else if(rollArr[0] == 3 && rollArr[1] == 3) {
			type = "Brooklen Forest";
		}else if(rollArr[0] == 3 && rollArr[1] == 4) {
			type = "Big Red";
		}else if(rollArr[0] == 3 && rollArr[1] == 5) {
			type = "Eighter From Decatur";
		}else if(rollArr[0] == 3 && rollArr[1] == 6) {
			type = "Nina From Pasadena";
		}else if(rollArr[0] == 4 && rollArr[1] == 1) {
			type = "Little Phoebe";
		}else if(rollArr[0] == 4 && rollArr[1] == 2) {
			type = "Easy Six";
		}else if(rollArr[0] == 4 && rollArr[1] == 3) {
			type = "Skinny McKinney";
		}else if(rollArr[0] == 4 && rollArr[1] == 4) {
			type = "Square Pair";
		}else if(rollArr[0] == 4 && rollArr[1] == 5) {
			type = "Railroad Nine";
		}else if(rollArr[0] == 4 && rollArr[1] == 6) {
			type = "Big One On The End";
		}else if(rollArr[0] == 5 && rollArr[1] == 1) {
			type = "Sixie From Dixie";
		}else if(rollArr[0] == 5 && rollArr[1] == 2) {
			type = "Skinny Dugan";
		}else if(rollArr[0] == 5 && rollArr[1] == 3) {
			type = "Easy Eight";
		}else if(rollArr[0] == 5 && rollArr[1] == 4) {
			type = "Jessie James";
		}else if(rollArr[0] == 5 && rollArr[1] == 5) {
			type = "Puppy Paws";
		}else if(rollArr[0] == 5 && rollArr[1] == 6) {
			type = "Yo";
		}else if(rollArr[0] == 6 && rollArr[1] == 1) {
			type = "The Devil";
		}else if(rollArr[0] == 6 && rollArr[1] == 2) {
			type = "Easy Eight";
		}else if(rollArr[0] == 6 && rollArr[1] == 3) {
			type = "Lou Brown";
		}else if(rollArr[0] == 6 && rollArr[1] == 4) {
			type = "Tennessee";
		}else if(rollArr[0] == 6 && rollArr[1] == 5) {
			type = "Six Five No Jive";
		}else if(rollArr[0] == 6 && rollArr[1] == 6) {
			type = "Midnight";
		}
		return type;
	}
	private static byte rollTotal(byte rollArray[]) {
		return (byte) (rollArray[0] + rollArray[1]);
	}
	public static void main(String[] args) {
		// Variable Creation and initialization.
		char answer;
		byte player[] = new byte[2];
		byte computer[] = new byte[2];
		byte playerTotal = 0;
		byte computerTotal = 0;
		String playerRollType = "";
		String computerRollType = "";
		// Welcome and ask the user if they want to play
		System.out.println("Welcome to the dice throw challenge!");
		System.out.println("Do you feel lucky? “Punk”... Do ya?");
		System.out.println("Press any key and ENTER to throw your dice or press (Q or q) to chicken your butt off...");
		Scanner in = new Scanner(System.in);
		answer = in.nextLine().toLowerCase().charAt(0);	// Gets a string from input object, converts string to lower case, takes the first char object in the string, Closes the input object, Returns the char
		if(answer == 'q') {
			// Checks if user input is equivalent to q and exits the program if true
			System.out.println("See ya later alligator!");
			System.exit(0);
		}
		// Do while loop to run the logic
		do {
			System.out.println("Rolling the dice!!");
			// Assigns the two die rolls into an array for both the user and computer
			player[0] = roll6SidedDie();
			player[1] = roll6SidedDie();
			computer[0] = roll6SidedDie();
			computer[1] = roll6SidedDie();
			// Gets the name of the roll pair for the user and computer
			playerRollType = rollType(player);
			computerRollType = rollType(computer);
			// Gets the total die value for the user and computer
			playerTotal = rollTotal(player);
			computerTotal = rollTotal(computer);
			if(playerTotal < computerTotal) {
				computerWin(player, computer, playerRollType, computerRollType);
			}else if(playerTotal > computerTotal) {
				computerLoss(player, computer, playerRollType, computerRollType);
			}else if((playerTotal == computerTotal) && (computer[0] == computer[1]) && (player[0] != player[1])) {
				computerWinDouble(player, computer, playerRollType, computerRollType);
			}else if((playerTotal == computerTotal) && (player[0] == player[1]) && (computer[0] != computer[1])) {
				computerLossDouble(player, computer, playerRollType, computerRollType);
			}else if(playerTotal == computerTotal) {
				trueTie(player, computer, playerRollType, computerRollType);
			}
			answer = in.nextLine().toLowerCase().charAt(0);	// Gets a string from input object, converts string to lower case, takes the first char object in the string, Closes the input object, Returns the char
		}while(answer == 'y');
		in.close();
		System.out.println("Thanks for being a sport! laters!");
	}
}
