package algorithm;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths; 


public class Algo_2 {
	static final  String  leftUp = "LU";
	static final  String  left = "L";
	static final  String  up = "U";

	public static void main(String[] args) {
		int longestLen;
		String longestStr;
		CompareElement[][] arr;
		// char arrays storing strings
		char[] char1, char2;
		// string arrays that will store the two lines in the txt file
		String[] strArr = new String[2];
		// concat the path of the txt file
		Path path = Paths.get(System.getProperty("user.dir"), "src", "algorithm", "LCS_test.txt");				
		File txt = new File(path.toString());
		
		//get the strings from the txt file and put them into strArr 
		try(BufferedReader br = new BufferedReader(new FileReader(txt))){
			for(int i =0 ; br.ready(); i++) {
				strArr[i] = br.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("找不到檔案");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// convert two strings in the strArr into two char arrays
		char1 = strArr[0].toCharArray();
		char2 = strArr[1].toCharArray();

		// crate a two dimension array, 
		// where the length of the row equals to the length of char1 + 1
		// and the length of the column equals to the length of char2 + 1.
		// the all values of the following array are zero because we new a int[][]
		arr = new CompareElement[char1.length+1][char2.length+1];
		for(int j =0 ; j < arr.length ; j++ ) {
			CompareElement[] row = arr[j];
			for(int i = 0; i < row.length ; i++) {
				row[i] = new CompareElement();
			}
		}
		
		for (int j = 1; j < arr.length; j++) {
			for (int i = 1; i < arr[j].length; i++) {
				if (char1[j-1] == char2[i - 1]) {
					arr[j][i].value = arr[j - 1][i - 1].value + 1;
					arr[j][i].direction = leftUp;
				} else {
					if (arr[j - 1][i].value >= arr[j][i - 1].value) {
						arr[j][i].value = arr[j - 1][i].value;
						arr[j][i].direction = up;
					} else {
						arr[j][i].value = arr[j][i - 1].value;
						arr[j][i].direction = left;
					}
				}
			}
		}
		
		longestLen = arr[char1.length][char2.length].value;
		longestStr = findLongestString(arr, char1, char2);
		
		System.out.println("The length of the longest subsequence of two sequence is：" + longestLen);
		System.out.println("The longest subsequence of two sequence is：" + longestStr);

		

//		// print the computing array
//		for(CompareElement[] row: arr) {
//			for(CompareElement ele:row) {
//				System.out.print(ele.value + "  ");
//			}
//			System.out.println("");
//		}
//		
//		for(CompareElement[] row: arr) {
//			for(CompareElement ele:row) {
//				System.out.print(ele.direction + "  ");
//			}
//			System.out.println("");
//		}

	}

	private static String findLongestString(CompareElement[][] arr, char[] char1, char[] char2) {
		// find the characters of the longest subsequence from the last element of the given array
		int char1Index = char1.length;
		int char2Index = char2.length;
		CompareElement ele = arr[char1Index][char2Index];
		int charIndex = ele.value;
		char[] longestCharArr = new char[charIndex];
		
		while(ele.direction != null) {
			switch (ele.direction) {
			case leftUp:
				longestCharArr[charIndex-1] = char1[char1Index-1];
				charIndex -= 1;
				char1Index -=1;
				char2Index -=1;
				break;
			case left:
				char2Index -=1;
				break;
			case up:
				char1Index -=1;
				break;
			default:
				break;
			}
			ele = arr[char1Index][char2Index];
		}
		// get the longest string
		StringBuilder sb = new StringBuilder();
		for(char c: longestCharArr) {
			sb.append(c);
		}
		
		return sb.toString();
		
	}

}

class CompareElement {
	String direction = null;
	int value = 0;

}
