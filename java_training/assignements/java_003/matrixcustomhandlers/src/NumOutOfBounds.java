
public class NumOutOfBounds extends Exception{
	byte min = 1;
	byte max = 3;
	int input;
	
	public NumOutOfBounds(int userInput) {
		input = userInput;
	}
	public String toString() {
		return "User Input: " + input + " is out of bound";
	}
}
