package arrayutils;

public class ArrayUtils {
	public static boolean arrayHasExactMatch(String stringArr[], String stringToCheck, boolean caseSensitive) {
		/*
		 * Takes an input String array, a String variable, and a boolean variable
		 * Boolean variable sets case sensitivity
		 * Returns True if string is found
		 */
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
	}
	public static int[] indexOfOccuranceInArray(String stringArr[], String stringToCheck, boolean caseSensitive) {
		/*
		 * Takes a String array, String variable, and a boolean variable
		 * Boolean variable sets case sensitivity
		 * Outputs an array of the indexes found for the String variable matches
		 * Outputs an array of length 1 with the value -1 if no matches found
		 */
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
	}
}
