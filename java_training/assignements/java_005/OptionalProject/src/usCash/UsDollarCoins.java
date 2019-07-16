package usCash;

public enum UsDollarCoins {
	Penny(0.01),
	Nickel(0.05),
	Dime(0.10),
	Quarter(0.25),
	HalfDollar(0.50),
	Dollar(1.00);
	private final double coinVal;
	private UsDollarCoins(double coinValue) {
		this.coinVal = coinValue;
	}
	public double getValue() {
		return coinVal;
	}
}
