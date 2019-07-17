
public class Main {
	public static void main(String[] args) {
		// Lambda
		WorkString boolReturn = (String stringArr[], String stringToCheck, boolean caseSensitive) -> {
			if(caseSensitive == true) { 	// Case sensitivity on
				for(String s : stringArr) {
					if(s.equals(stringToCheck)) {	// Checks if string is in array
						return true;
					}
				}
			}else if(caseSensitive == false) {	// Case sensitivity off
				for(String s : stringArr) {
					if(s.toLowerCase().equals(stringToCheck.toLowerCase())) {	// Checks if string is in array
						return true;
					}
				}
			}
			return false; // If string not found, returns false, otherwise true
		};
		workStringIndex intReturn = (String stringArr[], String stringToCheck, boolean caseSensitive) -> {
			int found[];
			if(caseSensitive == true) {	// Case sensitivity on
				byte checkVal = 0;
				for(String s : stringArr) {
					if(s.contentEquals(stringToCheck)) {	// Checks if string is in array
						checkVal++;
					}
				}
				if(checkVal > 0) {	// If string is found get the index of string
					found = new int[checkVal];
					byte counter = 0;
					for(byte x = 0; x < stringArr.length; x++) {
						if(stringArr[x].contentEquals(stringToCheck)) {
							found[counter] = x;
							counter++;
						}
					}
					return found;
				}else {	// If not found, return array with 1 index with a value of -1
					found = new int[1];
					found[0] = -1;
					return found;
				}
			}else if(caseSensitive == false) {	// Case sensitivity off
				byte checkVal = 0;
				for(String s : stringArr) {
					if(s.toLowerCase().contentEquals(stringToCheck.toLowerCase())) {	// Checks if string is in array
						checkVal++;
					}
				}
				if(checkVal > 0) {	// If string is found get the index of string
					found = new int[checkVal];
					byte counter = 0;
					for(byte x = 0; x < stringArr.length; x++) {
						if(stringArr[x].toLowerCase().contentEquals(stringToCheck.toLowerCase())) {
							found[counter] = x;
							counter++;
						}
					}
					return found;
				}else {	// If not found, return array with 1 index with a value of -1
					found = new int[1];
					found[0] = -1;
					return found;
				}
			}else {	// Sets a default for code compiling
				found = new int[1];
				found[0] = -1;
				return found;
			}
		};
		// Code
		String myList[] = {"Bozo", "FooBar", "Delta", "Foozball", "Demo", "Money", "Zoo"};
		System.out.println("This is the a test of the arrayHasExactMatch and indexOfOccurenceInArray methods");
		System.out.println("The array to test contains the following items");
		System.out.print("[");
		for(byte x = 0; x < myList.length; x++) {
			System.out.print(myList[x]);
			if(x + 1 < myList.length) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
		System.out.println("Senario 1");
		System.out.println("arrayHasExactMatch(myList, \"zo\", false): " + boolReturn.work(myList, "zo", false));
		System.out.println("Senario 2");
		System.out.println("arrayHasExactMatch(myList, \"zoo\", false): " + boolReturn.work(myList, "zoo", false));
		System.out.println("Senario 3");
		System.out.println("arrayHasExactMatch(myList, \"zoo\", true): " + boolReturn.work(myList, "zoo", true));
		System.out.println("Senario 4");
		System.out.println("arrayHasExactMatch(myList, \"foo\", true): " + boolReturn.work(myList, "foo", true));
		System.out.println("Senario 5");
		System.out.println("arrayHasExactMatch(myList, \"foo\", false): " + boolReturn.work(myList, "foo", false));
		System.out.println("Senario 6");
		System.out.println("arrayHasExactMatch(myList, \"delta\", True): " + boolReturn.work(myList, "delta", true));
		System.out.println("Senario 7");
		System.out.println("arrayHasExactMatch(myList, \"Delta\", True): " + boolReturn.work(myList, "Delta", true));
		System.out.println("Senario 8");
		System.out.println("indexOfOccuranceInArray(myList, \"zo\", false): " + intReturn.work(myList, "zo", false)[0]);
		System.out.println("Senario 9");
		System.out.println("indexOfOccuranceInArray(myList, \"zoo\", false): " + intReturn.work(myList, "zoo", false)[0]);
		System.out.println("Senario 10");
		System.out.println("indexOfOccuranceInArray(myList, \"zoo\", true): " + intReturn.work(myList, "zoo", true)[0]);
		System.out.println("Senario 11");
		System.out.println("indexOfOccuranceInArray(myList, \"foo\", true): " + intReturn.work(myList, "foo", true)[0]);
		System.out.println("Senario 12");
		System.out.println("indexOfOccuranceInArray(myList, \"foo\", false): " + intReturn.work(myList, "foo", false)[0]);
		System.out.println("Senario 13");
		System.out.println("indexOfOccuranceInArray(myList, \"delta\", True): " + intReturn.work(myList, "delta", true)[0]);
		System.out.println("Senario 14");
		System.out.println("indexOfOccuranceInArray(myList, \"Delta\", True): " + intReturn.work(myList, "Delta", true)[0]);
	}
}