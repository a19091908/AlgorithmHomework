package algorithm;


public class Algo_1 {

	public static void main(String[] str) {

		// 頂點
		char[] charArr = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K' };

		// 已拜訪頂點
		boolean[] visitedArr = new boolean[charArr.length];

		// 起點為A
		char startVertex = 'A';
		int startIndex = 0;

		// 從起始點s到其他點的最短距離陣列
		double[] minDis = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

		// 建立走訪陣列
		double[][] disArr = 
			{   { 0, 3, 0, 0, 2, 0, 0, 0, 0, 0, 0 }, 
				{ 3, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 5, 0, 2, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 0, 2, 0, 3, 0, 0, 0, 0, 0, 0 },
				{ 2, 0, 0, 3, 0, 3, 0, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 3, 0, 4, 0, 2, 0, 0 },
				{ 0, 0, 1, 0, 0, 4, 0, 0, 0, 2, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3 },
				{ 0, 0, 0, 0, 0, 2, 0, 1, 0, 0, 5 }, 
				{ 0, 0, 0, 0, 0, 0, 2, 2, 0, 0, 1 },
				{ 0, 0, 0, 0, 0, 0, 0, 3, 5, 1, 0 } };

		// 設定minDis：除了起始點設為0，其餘皆設為無限大。
		for (int i = 0; i < minDis.length; i++) {
			if (charArr[i] == startVertex) {
				minDis[i] = 0;
				startIndex = i;
			} else {
				minDis[i] = Double.POSITIVE_INFINITY;
			}
		}

		
		for (int i = startIndex; i < disArr.length; i++) {
			int minIndex;
			double[] row;


			// 挑選minDis中最小值的index
			// 並將此點(index)放入visitedArr中
			minIndex = minIndexInArr(minDis, visitedArr);
			if(minIndex == -1) {
				break;
			}
			visitedArr[minIndex] = true;

			// 更新此次造訪的點所連接的所有點的權重到minDis
			row = disArr[minIndex];
			for (int j = 0; j < row.length; j++) {
				// 若權重為0，跳過
				// 若權重非0，比較新的距離是否小於舊距離(minDis的距離)，較小者存入minDis
				if (row[j] == 0) {
					continue;
				} else {
					if (minDis[minIndex] + row[j] < minDis[j]) {
						minDis[j] = minDis[minIndex] + row[j];
					}
				}
			}
			printMinDis(minDis, visitedArr, charArr);
		}
		


	}

	private static void printMinDis(double[] minDis, boolean[] visitedArr, char[] charArr) {
		// TODO Auto-generated method stub
		String row = "", visitedVertex = "";
		for (int k = 0; k < minDis.length; k++) {
			row = row + charArr[k] + " : " + minDis[k] + "\n";
		}
		for (int i = 0; i < visitedArr.length; i++) {
			if(visitedArr[i] == false) {
				visitedVertex += "*";
			}else {
				visitedVertex += charArr[i];
			}
		}
		System.out.print(row);
		System.out.println(visitedVertex);
		System.out.println("-------------");
	}

	/*
	 * 找出未被造訪且最小的index
	 */
	private static int minIndexInArr(double[] minDis, boolean[] visitedArr) {
		// TODO Auto-generated method stub
		double tempMinVal = Double.POSITIVE_INFINITY;
		int tempMinIndex = -1;

		for (int i = 0; i < minDis.length; i++) {
			// 若點已被挑選過，則跳過此點
			if( visitedArr[i] == true) {
				continue;
			}
			
			if (minDis[i] < tempMinVal) {
				tempMinVal = minDis[i];
				tempMinIndex = i;
			}
			
		}
		return tempMinIndex;
	}

}
