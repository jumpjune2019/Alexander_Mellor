package usCash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import customExceptions.NegativeNumber;

public class Main {
	public static void main(String[] args) {
		CountMoney cm = new CountMoney();
		boolean inputErrorRedo = false;
		System.out.println("Welcome to the US Currancy Counter.");
		System.out.println("Please input whole number values.");
		BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));	// Buffered Reader Input
		// Penny User Input Loop
		System.out.println("How many Pennies?");
		do {
			inputErrorRedo = false;
			try {
				int input = Integer.parseInt(userIn.readLine());
				if(input < 0) {
					throw new NegativeNumber();
				}
				cm.setPenny(input);
			}catch(IOException | NumberFormatException | NegativeNumber e) {
				inputErrorRedo = true;
				System.out.println("ERROR: Wrong Input Type Please input again.");
			}
		}while(inputErrorRedo);
		// Nickel User Input Loop
		System.out.println("How many Nickels?");
		do {
			inputErrorRedo = false;
			try {
				int input = Integer.parseInt(userIn.readLine());
				if(input < 0) {
					throw new NegativeNumber();
				}
				cm.setNickel(input);
			}catch(IOException | NumberFormatException | NegativeNumber e) {
				inputErrorRedo = true;
				System.out.println("ERROR: Wrong Input Type Please input again.");
			}
		}while(inputErrorRedo);
		// Dime user Input Loop
		System.out.println("How many Dimes?");
		do {
			inputErrorRedo = false;
			try {
				int input = Integer.parseInt(userIn.readLine());
				if(input < 0) {
					throw new NegativeNumber();
				}
				cm.setDime(input);
			}catch(IOException | NumberFormatException | NegativeNumber e) {
				inputErrorRedo = true;
				System.out.println("ERROR: Wrong Input Type Please input again.");
			}
		}while(inputErrorRedo);
		// Quarter User Input Loop
		System.out.println("How many Quarters?");
		do {
			inputErrorRedo = false;
			try {
				int input = Integer.parseInt(userIn.readLine());
				if(input < 0) {
					throw new NegativeNumber();
				}
				cm.setQuarter(input);
			}catch(IOException | NumberFormatException | NegativeNumber e) {
				inputErrorRedo = true;
				System.out.println("ERROR: Wrong Input Type Please input again.");
			}
		}while(inputErrorRedo);
		// Half Dollar User Input Loop
		System.out.println("How many Half Dollars?");
		do {
			inputErrorRedo = false;
			try {
				int input = Integer.parseInt(userIn.readLine());
				if(input < 0) {
					throw new NegativeNumber();
				}
				cm.setHalfDollar(input);
			}catch(IOException | NumberFormatException | NegativeNumber e) {
				inputErrorRedo = true;
				System.out.println("ERROR: Wrong Input Type Please input again.");
			}
		}while(inputErrorRedo);
		// Dollar User Input Loop
		System.out.println("How many Dollars?");
		do {
			inputErrorRedo = false;
			try {
				int input = Integer.parseInt(userIn.readLine());
				if(input < 0) {
					throw new NegativeNumber();
				}
				cm.setDollar(input);
			}catch(IOException | NumberFormatException | NegativeNumber e) {
				inputErrorRedo = true;
				System.out.println("ERROR: Wrong Input Type Please input again.");
			}
		}while(inputErrorRedo);
		System.out.println("");
		try {
			userIn.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		cm.returnRaw();
		cm.returnPretty();
		cm.returnCurrancy();
	}
}
