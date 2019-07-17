import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		// Lambdas
		RollDice side6 = () -> {
			Random rand = new Random();
			int test = rand.nextInt(6) + 1;
			byte roll = (byte)test;
			return roll;
		};
		Results comWin = (player, computer, pType, cType) -> {
			System.out.println("You have rolled a " + player[0] + " and " + player[1] + " > the " + pType);
			System.out.println("I have rolled a " + computer[0] + " and " + computer[1] + " > the " + cType);
			System.out.println("I win!!!");
			System.out.println("Wanna try again? Press any key and ENTER to throw your dice or press (Q or q) to quit");
			return;
		};
		Results comLoss = (player, computer, pType, cType) -> {
			System.out.println("You have rolled a " + player[0] + " and " + player[1] + " > the " + pType);
			System.out.println("I have rolled a " + computer[0] + " and " + computer[1] + " > the " + cType);
			System.out.println("You win!!!");
			System.out.println("Did you cheat?? Gimme another try, c’mon Press any key and ENTER to throw your dice or press (Q or q) to quit");
			return;
		};
		Results comWinDouble = (player, computer, pType, cType) -> {
			System.out.println("You have rolled a " + player[0] + " and " + player[1] + " > the " + pType);
			System.out.println("I have rolled a " + computer[0] + " and " + computer[1] + " > the " + cType);
			System.out.println("Damn! I win on a Double! Ah! I pity you fool!");
			System.out.println("Wanna try again? Press any key and ENTER to throw your dice or press (Q or q) to quit");
			return;
		};
		Results comLossDouble = (player, computer, pType, cType) -> {
			System.out.println("You have rolled a " + player[0] + " and " + player[1] + " > the " + pType);
			System.out.println("I have rolled a " + computer[0] + " and " + computer[1] + " > the " + cType);
			System.out.println("Damn! You win on a Double! What Luck!");
			System.out.println("Did you cheat?? Gimme another try, c’mon Press any key and ENTER to throw your dice or press (Q or q) to quit");
			return;
		};
		Results tie = (player, computer, pType, cType) -> {
			System.out.println("You have rolled a " + player[0] + " and " + player[1] + " > the " + pType);
			System.out.println("I have rolled a " + computer[0] + " and " + computer[1] + " > the " + cType);
			System.out.println("Stalemate! You’re tough, let’s try for a tie-breaker Press any key and ENTER to throw your dice or press (Q or q) to quit");
			return;
		};
		ShowDiceCall getCall = (rollArr) -> {
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
		};
		AddDice diceAdder = (rollArray) -> (byte) (rollArray[0] + rollArray[1]);
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
		try(BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in))){
			answer = userIn.readLine().toLowerCase().charAt(0);	// Gets a string from input object, converts string to lower case, takes the first char object in the string, Closes the input object, Returns the char
			if(answer == 'q') {
				// Checks if user input is equivalent to q and exits the program if true
				System.out.println("See ya later alligator!");
				System.exit(0);
			}
			// Do while loop to run the logic
			do {
				System.out.println("Rolling the dice!!");
				// Assigns the two die rolls into an array for both the user and computer
				player[0] = side6.roll();
				player[1] = side6.roll();
				computer[0] = side6.roll();
				computer[1] = side6.roll();
				// Gets the name of the roll pair for the user and computer
				playerRollType = getCall.show(player);
				computerRollType = getCall.show(computer);
				// Gets the total die value for the user and computer
				playerTotal = diceAdder.add(player);
				computerTotal = diceAdder.add(computer);
				if(playerTotal < computerTotal) {
					comWin.show(player, computer, playerRollType, computerRollType);
				}else if(playerTotal > computerTotal) {
					comLoss.show(player, computer, playerRollType, computerRollType);
				}else if((playerTotal == computerTotal) && (computer[0] == computer[1]) && (player[0] != player[1])) {
					comWinDouble.show(player, computer, playerRollType, computerRollType);
				}else if((playerTotal == computerTotal) && (player[0] == player[1]) && (computer[0] != computer[1])) {
					comLossDouble.show(player, computer, playerRollType, computerRollType);
				}else if(playerTotal == computerTotal) {
					tie.show(player, computer, playerRollType, computerRollType);
				}
				answer = userIn.readLine().toLowerCase().charAt(0);	// Gets a string from input object, converts string to lower case, takes the first char object in the string, Closes the input object, Returns the char
			}while(answer != 'q');
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Thanks for being a sport! laters!");
	}
}