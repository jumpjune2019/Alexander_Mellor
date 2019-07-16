package swapArrayElements;

public class GenericArraySwap {
	private static <T> void workOnArray(T arr[]) {
		/*
		 * Simple method to swap and display the elements of incoming arrays
		 * Only works on the first 10 indexes
		 */
		GenericArrayMethods.displayArrayItems(arr);
		GenericArrayMethods.swapArrayItems(arr, 0, 9);
		GenericArrayMethods.displayArrayItems(arr);
		GenericArrayMethods.swapArrayItems(arr, 1, 8);
		GenericArrayMethods.displayArrayItems(arr);
		GenericArrayMethods.swapArrayItems(arr, 2, 7);
		GenericArrayMethods.displayArrayItems(arr);
		GenericArrayMethods.swapArrayItems(arr, 3, 6);
		GenericArrayMethods.displayArrayItems(arr);
		GenericArrayMethods.swapArrayItems(arr, 4, 5);
		GenericArrayMethods.displayArrayItems(arr);
		System.out.println("");
	}
	public static void main(String[] args) {
		// Sample arrays to do work on
		String strArr[] = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
		Byte byteArr[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		Double doubleArr[] = {0.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0};
		System.out.println("This program switches any two values from within any array input.\n");
		// String Array Display and Switch
		System.out.println("String Array");
		workOnArray(strArr);
		// Byte Array Display and Switch
		System.out.println("Byte Array");
		workOnArray(byteArr);
		// Double Array Display and Switch
		System.out.println("Double Array");
		workOnArray(doubleArr);
	}
}
