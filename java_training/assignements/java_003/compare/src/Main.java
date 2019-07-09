import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
	private static boolean compareFiles(File file1, File file2){
		if (!file1.exists() || !file2.exists()) {
			return false;
		}
		if (file1.length() != file2.length()) {
			return false;
		}
		try {
			FileInputStream fis1 = new FileInputStream(file1);
			FileInputStream fis2 = new FileInputStream(file2);
			int i1 = fis1.read();
			int i2 = fis2.read();
			while (i1 != -1) {
				if (i1 != i2) {
					return false;
				}
				i1 = fis1.read();
				i2 = fis2.read();
			}
			fis1.close();
			fis2.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public static void main(String[] args) {
		File firstFile = new File("File1.txt");
		File secondFile = new File("File2.txt");
		try {
			if(!firstFile.exists()) {
				firstFile.createNewFile();
			}
			if(!secondFile.exists()) {
				secondFile.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		boolean tester = compareFiles(firstFile, secondFile);
		System.out.print("Result: ");
		if(tester) {
			System.out.println("identical content");
			System.out.println("character length for both: " + ((firstFile.length() + secondFile.length()) / 2));
		}else {
			System.out.println("different content");
			System.out.println("Character length for File1.txt: " + firstFile.length());
			System.out.println("Character length for File2.txt: " + secondFile.length());
		}
	}
}
