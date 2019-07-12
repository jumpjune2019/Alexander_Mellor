package usCash;

import java.text.DecimalFormat;

public class CountMoney {
	/*
	 * This class calculates cash in us dollars
	 */
	// variables
	private static int pennyAmount, nickelAmount, dimeAmount, quarterAmount, halfDollarAmount, dollarAmount;
	// Private Methods
	private static double calculatePenny() {
		return UsDollarCoins.Penny.getValue() * pennyAmount;
	}
	private static double calculateNickel() {
		return UsDollarCoins.Nickel.getValue() * nickelAmount;
	}
	private static double calculateDime() {
		return UsDollarCoins.Dime.getValue() * dimeAmount;
	}
	private static double calculateQuarter() {
		return UsDollarCoins.Quarter.getValue() * quarterAmount;
	}
	private static double calculateHalfDollar() {
		return UsDollarCoins.HalfDollar.getValue() * halfDollarAmount;
	}
	private static double calculateDollar() {
		return UsDollarCoins.Dollar.getValue() * dollarAmount;
	}
	private static double calculateTotal() {
		return calculatePenny() + calculateNickel() + calculateDime() + calculateQuarter() + calculateHalfDollar() + calculateDollar();
	}
	// Public Methods
	public void setPenny(int input) {
		pennyAmount = input;
	}
	public void setNickel(int input) {
		nickelAmount = input;
	}
	public void setDime(int input) {
		dimeAmount = input;
	}
	public void setQuarter(int input) {
		quarterAmount = input;
	}
	public void setHalfDollar(int input) {
		halfDollarAmount = input;
	}
	public void setDollar(int input) {
		dollarAmount = input;
	}
	public void returnRaw() {
		//  Display value in this format #.##
		DecimalFormat df = new DecimalFormat("#.##");
		if(calculateTotal() == 0) {
			System.out.println(0);
		}else {
			System.out.println(df.format(calculateTotal()));
		}
	}
	public void returnPretty() {
		//  Display value in this format Dollars and Cents
		DecimalFormat df = new DecimalFormat("#.##");
		if(calculateTotal() == 0) {
			System.out.println("No Money has been set");
		}else {
			String doubleAsString = df.format(calculateTotal());
			int indexOfDecimal = doubleAsString.indexOf(".");
			if(Integer.parseInt(doubleAsString.substring(0, indexOfDecimal)) == 1) {
				System.out.println(doubleAsString.substring(0, indexOfDecimal) + " Dollar and " + doubleAsString.substring(indexOfDecimal + 1) + " Cents");
			}else {
				System.out.println(doubleAsString.substring(0, indexOfDecimal) + " Dollars and " + doubleAsString.substring(indexOfDecimal + 1) + " Cents");
			}
		}
	}
	public void returnCurrancy() {
		//  Display value in this format $ #.##
		DecimalFormat df = new DecimalFormat("#.##");
		if(calculateTotal() == 0) {
			System.out.println("No Money has been set");
		}else {
			System.out.println("$ " + df.format(calculateTotal()));
		}
	}
}
