package swapArrayElements;

public class GenericArrayMethods {
	public static final <T> void swapArrayItems(T arr[], int firstIndex, int secondIndex) {
		/*
		 * Swaps two items and swaps their position in an array
		 */
		T item1 = arr[firstIndex];
		T item2 = arr[secondIndex];
		arr[firstIndex] = item2;
		arr[secondIndex] = item1;
	}
	public static final <T> void displayArrayItems(T arr[]) {
		/*
		 * Prints out an input array to console
		 */
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if(i + 1 < arr.length) {
				System.out.print(", ");
			}
		}
		System.out.print("\n");
	}
}
