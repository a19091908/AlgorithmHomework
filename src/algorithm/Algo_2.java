package algorithm;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths; 


public class Algo_2 {
	final static String  leftUp = "↖";
	final static String  left = "←";
	final static String  up = "↑";

	public static void main(String[] args) {
		int longestLen;
		String longestStr;
		CompareElement[][] arr;
		// 儲存字串的字元陣列
		char[] char1, char2;
		// 將儲存TXT檔的兩個字串的陣列
		String[] strArr = new String[2];
		// 串接為TXT檔案路徑
		Path path = Paths.get(System.getProperty("user.dir"), "src", "algorithm", "LCS_test.txt");				
		File txt = new File(path.toString());
		
		// 從文字檔中取得字串，並放入strArr陣列中
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

		// 將strArr中的兩字串分別轉為字元陣列
		char1 = strArr[0].toCharArray();
		char2 = strArr[1].toCharArray();

		// 建立二維陣列，其中列的長度為char1長度+1，行的長度為char2長度+1
		// 因為new int[][] 的緣故，所以目前所有陣列值皆為0
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
		
		System.out.println("最長子序列長度為：" + longestLen);
		System.out.println("最長子序列為：" + longestStr);

		

//		// 印出計算後的矩陣
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
		// 從最後一個點開始找
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
		// 取得最常字串
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
