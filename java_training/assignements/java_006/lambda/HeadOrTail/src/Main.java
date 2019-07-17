import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		String userAnswer;
		CoinFlip1 coinFlip1 = () -> {
			Random rand = new Random();
			return rand.nextInt(2) + 1;
		};
		CoinFlip2 coinFlip2 = (num) -> {
			if(num == 1) {
				return "Head";
			}else if(num == 2) {
				return "Tail";
			}else {
				return "ERROR";
			}
		};
		System.out.println("Welcome to the game of Head or Tail where you will flip your life away!");
		try(BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in))){
			do {
				System.out.println("Press the F key and flip your luck!");
				userAnswer = userIn.readLine();
				if(userAnswer.toLowerCase().charAt(0) == 'f') {
					System.out.println("The Coin Flip Is: "+ coinFlip2.coinFlipNum(coinFlip1.coinFlipNum()) + "!");
				}
			}while(userAnswer.toLowerCase().charAt(0) != 'f');
			do {
				System.out.println("Press the F key to try again, press Q or q to Quit");
				userAnswer = userIn.readLine();
				if(userAnswer.toLowerCase().charAt(0) == 'f') {
					System.out.println("The Coin Flip Is: "+ coinFlip2.coinFlipNum(coinFlip1.coinFlipNum()) + "!");
				}
				if(userAnswer.toLowerCase().charAt(0) == 'q') {
					break;
				}
			}while(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Thank you for playing");
	}
}
