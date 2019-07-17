
public class DisplayArray {
	public static final <T> void printArr(T arr[]) {
		for(int x = 0; x < arr.length; x++) {
			System.out.print(arr[x]);
			if(x + 1 < arr.length) {
				System.out.print(", ");
			}else {
				System.out.print("\n");
			}
		}
	}
}
