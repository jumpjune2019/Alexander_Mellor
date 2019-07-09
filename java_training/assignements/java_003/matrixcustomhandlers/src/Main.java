import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static byte getUserAnswerInt() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String answerString = "";
		int answerInt = 0;
		byte answerByte;
		try {
			answerString = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			answerInt = Integer.parseInt(answerString);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		answerByte = (byte) answerInt;
		return answerByte;
	}
	private static void outputToConsole() {
		// Function to output array to the console
		byte control = 7;
		String diceRoll[][] = {
				{"", "1\t\t", "2\t", "3\t\t", "4\t", "5\t\t", "6"},
				{"1", "Snake Eyes\t", "Astrailian Yo", "Little Jo From Kokomo", "No Field Five", "Easy Six\t", "Six One You're Done"},
				{"2", "Ace Caught A Duece", "Ballarena", "The Fever\t", "Jimmie Hicks", "Benny Blue\t", "Easy Eight"},
				{"3", "Easy Four\t", "OJ\t", "Brooklen Forest\t", "Big Red", "Eighter From Decatur\t", "Nina From Pasadena"},
				{"4", "Little Phoebe\t", "Easy Six", "Skinny McKinney\t", "Square Pair", "Railroad Nine\t", "Big One On The End"},
				{"5", "Sixie From Dixie", "Skinny Dugan", "Easy Eight\t", "Jessie James", "Puppy Paws\t", "Yo"},
				{"6", "The Devil\t", "Easy Eight", "Lou Brown\t", "Tennessee", "Six Five No Jive", "Midnight"}
		};
		for(byte x = 0; x < control; x++) {
			for(byte y = 0; y < control; y++) {
				System.out.print(diceRoll[x][y]);
				System.out.print("\t");
			}
			System.out.print("\n");
		}
		return;
	}
	private static void outputToFile() {
		// Function to output array to text file
		File file = new File("data.txt");
		String diceRoll[][] = {
				{"", "1\t\t\t\t\t\t\t\t\t", "2\t\t\t\t\t\t", "3\t\t\t\t\t\t\t\t\t\t", "4\t\t\t\t\t\t", "5\t\t\t\t\t\t\t\t\t\t", "6"},
				{"1", "Snake Eyes\t\t\t\t", "Astrailian Yo", "Little Jo From Kokomo", "No Field Five", "Easy Six\t\t\t\t\t\t", "Six One You're Done"},
				{"2", "Ace Caught A Duece", "Ballarena\t\t", "The Fever\t\t\t\t\t\t", "Jimmie Hicks", "Benny Blue\t\t\t\t\t", "Easy Eight"},
				{"3", "Easy Four\t\t\t\t\t", "OJ\t\t\t\t\t", "Brooklen Forest\t\t\t", "Big Red\t\t\t", "Eighter From Decatur", "Nina From Pasadena"},
				{"4", "Little Phoebe\t\t\t", "Easy Six\t\t", "Skinny McKinney\t\t\t", "Square Pair\t", "Railroad Nine\t\t\t\t", "Big One On The End"},
				{"5", "Sixie From Dixie\t", "Skinny Dugan", "Easy Eight\t\t\t\t\t", "Jessie James", "Puppy Paws\t\t\t\t\t", "Yo"},
				{"6", "The Devil\t\t\t\t\t", "Easy Eight\t", "Lou Brown\t\t\t\t\t\t", "Tennessee\t\t", "Six Five No Jive\t\t", "Midnight"}
		};
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			StringBuilder builder = new StringBuilder();
			for(byte x = 0; x < diceRoll.length; x++) {
				for(byte y = 0; y < diceRoll.length; y++) {
					builder.append(diceRoll[x][y]);
					if(y < diceRoll.length - 1) {
						builder.append("\t\t");
					}
				}
				builder.append("\n");
			}
			bw.write(builder.toString());
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return;
	}
	public static void main(String[] args) {
		System.out.println("Dice Combination Label Matrix");
		System.out.println("How do you want the results printed? (1-3)");
		System.out.println("1 - Print to console");
		System.out.println("2 - Print to file");
		System.out.println("3 - Print to both");
		try {
			int answer = getUserAnswerInt();
			if(answer == 1) {	// Outputs to console
				outputToConsole();
			}else if(answer == 2) {	// Outputs to file
				outputToFile();
			}else if(answer == 3) {	// Outputs to console and file
				outputToConsole();
				outputToFile();
			}else {
				throw new NumOutOfBounds(answer);
			}
		} catch(NumOutOfBounds e) {
			System.out.println(e);
		}
	}
}