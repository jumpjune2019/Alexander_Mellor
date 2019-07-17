import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[] numArr = { 10, 3, 4, 15, 7, 9, 1, 21 };
		String[] strArr = {"claude", "Phil", "lois", "clark", "Arthur", "Mera", "bruce"};
		SortReturnInt numSort = (arr, sortDirection) -> {
			if(sortDirection) {
				Arrays.sort(arr);
				return arr;
			}else {
				Arrays.sort(arr);
				for (int i = 0; i < arr.length / 2; i++) { 
		            int t = arr[i]; 
		            arr[i] = arr[arr.length - i - 1]; 
		            arr[arr.length - i - 1] = t; 
		        } 
				return arr;
			}
		};
		SortReturnStr strSort = (arr, sortDirection, ignoreCase) -> {
			if(sortDirection) {
				if(ignoreCase) {
					Arrays.sort(arr);
				}else {
					Arrays.sort(arr, String.CASE_INSENSITIVE_ORDER);
				}
				return arr;
			}else {
				if(ignoreCase) {
					Arrays.sort(arr);
				}else {
					Arrays.sort(arr, String.CASE_INSENSITIVE_ORDER);
				}
				for (int i = 0; i < arr.length / 2; i++) { 
		            String t = arr[i]; 
		            arr[i] = arr[arr.length - i - 1]; 
		            arr[arr.length - i - 1] = t; 
		        } 
				return arr;
			}
		};
		System.out.println("Initial Int Array");
		DisplayArray.printArr(Arrays.stream(numArr).boxed().toArray());
		System.out.println("Ascending Sort");
		numSort.sorted(numArr, true);
		DisplayArray.printArr(Arrays.stream(numArr).boxed().toArray());
		System.out.println("Descending Sort");
		numSort.sorted(numArr, false);
		DisplayArray.printArr(Arrays.stream(numArr).boxed().toArray());
		System.out.println("Initial String Array");
		DisplayArray.printArr(strArr);
		System.out.println("Ascending Sort Ignoring Case");
		strSort.sorted(strArr, true, false);
		DisplayArray.printArr(strArr);
		System.out.println("Descending Sort Ignoring Case");
		strSort.sorted(strArr, false, false);
		DisplayArray.printArr(strArr);
		System.out.println("Ascending Sort Including Case");
		strSort.sorted(strArr, true, true);
		DisplayArray.printArr(strArr);
		System.out.println("Descending Sort Including Case");
		strSort.sorted(strArr, false, true);
		DisplayArray.printArr(strArr);
	}
}
