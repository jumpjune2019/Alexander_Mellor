package app;
import arrayutils.ArrayUtils;
public class Main {
	public static void main(String[] args) {
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
		System.out.println("arrayHasExactMatch(myList, \"zo\", false): " + ArrayUtils.arrayHasExactMatch(myList, "zo", false));
		System.out.println("Senario 2");
		System.out.println("arrayHasExactMatch(myList, \"zoo\", false): " + ArrayUtils.arrayHasExactMatch(myList, "zoo", false));
		System.out.println("Senario 3");
		System.out.println("arrayHasExactMatch(myList, \"zoo\", true): " + ArrayUtils.arrayHasExactMatch(myList, "zoo", true));
		System.out.println("Senario 4");
		System.out.println("arrayHasExactMatch(myList, \"foo\", true): " + ArrayUtils.arrayHasExactMatch(myList, "foo", true));
		System.out.println("Senario 5");
		System.out.println("arrayHasExactMatch(myList, \"foo\", false): " + ArrayUtils.arrayHasExactMatch(myList, "foo", false));
		System.out.println("Senario 6");
		System.out.println("arrayHasExactMatch(myList, \"delta\", True): " + ArrayUtils.arrayHasExactMatch(myList, "delta", true));
		System.out.println("Senario 7");
		System.out.println("arrayHasExactMatch(myList, \"Delta\", True): " + ArrayUtils.arrayHasExactMatch(myList, "Delta", true));
		System.out.println("Senario 8");
		System.out.println("indexOfOccuranceInArray(myList, \"zo\", false): " + ArrayUtils.indexOfOccuranceInArray(myList, "zo", false)[0]);
		System.out.println("Senario 9");
		System.out.println("indexOfOccuranceInArray(myList, \"zoo\", false): " + ArrayUtils.indexOfOccuranceInArray(myList, "zoo", false)[0]);
		System.out.println("Senario 10");
		System.out.println("indexOfOccuranceInArray(myList, \"zoo\", true): " + ArrayUtils.indexOfOccuranceInArray(myList, "zoo", true)[0]);
		System.out.println("Senario 11");
		System.out.println("indexOfOccuranceInArray(myList, \"foo\", true): " + ArrayUtils.indexOfOccuranceInArray(myList, "foo", true)[0]);
		System.out.println("Senario 12");
		System.out.println("indexOfOccuranceInArray(myList, \"foo\", false): " + ArrayUtils.indexOfOccuranceInArray(myList, "foo", false)[0]);
		System.out.println("Senario 13");
		System.out.println("indexOfOccuranceInArray(myList, \"delta\", True): " + ArrayUtils.indexOfOccuranceInArray(myList, "delta", true)[0]);
		System.out.println("Senario 14");
		System.out.println("indexOfOccuranceInArray(myList, \"Delta\", True): " + ArrayUtils.indexOfOccuranceInArray(myList, "Delta", true)[0]);
	}
}
