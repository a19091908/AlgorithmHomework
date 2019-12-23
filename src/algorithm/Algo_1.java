// 姓名：吳軒穎
// 學號：e608502004
package algorithm;


public class Algo_1 {
	static final Integer INF = Integer.MAX_VALUE;

	public static void main(String[] str) {

		// vertex array
		char[] charArr = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K' };
		
		// visited vertex array
		boolean[] visitedArr = new boolean[charArr.length];
		
		// the previous vertex of the shortest path
		int[] previousVertex = new int[charArr.length];

		// we run the algorithm from A
		char startVertex = 'A';
		int startIndex = 0;
		// set the previous vertex of start vertex = ' '
		previousVertex[startIndex] = -1; 
		
		// the shortest distance from start vertex to others
		Integer[] minDis = new Integer[charArr.length];
		
		// set the value of the minDis to infinite except setting the start vertex to 0 
		for (int i = 0; i < minDis.length; i++) {
			if (charArr[i] == startVertex) {
				minDis[i] = 0;
				startIndex = i;
			} else {
				minDis[i] = INF;
			}
		}

		// create the cost array between any two vertexes
		Integer[][] disArr = 
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
	
		for (int i = 0; i < disArr.length; i++) {
			int minIndex;
			Integer[] row;

			// find the index of the minimum number in minDis
			// and put this vertex(index) into visitedArr
			minIndex = minIndexInArr(minDis, visitedArr);
			if(minIndex == -1) {
				break;
			}
			visitedArr[minIndex] = true;

			// update all distance in minDis that from  the selected vertex to its adjacent vertex   
			row = disArr[minIndex];
			for (int j = 0; j < row.length; j++) {
				// if the cost is 0, then skip
				// else compare  the new distance and the old one, 
				// and put the smaller into minDis
				if (row[j] == 0) {
					continue;
				} else {
					if ( plus(minDis[minIndex], row[j]) < minDis[j]) {
						minDis[j] = plus( minDis[minIndex], row[j] );
						previousVertex[j] = minIndex;
					}
				}
			}
			printPath(minIndex, previousVertex, charArr, minDis);
//			printMinDis(minDis, visitedArr, charArr);
		}

	}
	
	private static void printPath(int minIndex, int[] previousVertex, char[] charArr, Integer[] minDis) {
		String s = "";
		int index = minIndex;
		while(index != -1) {
			s = charArr[index] + s;
			index = previousVertex[index];
		}

		System.out.println(s + ": " + minDis[minIndex]);
	}

	private static void printMinDis(Integer[] minDis, boolean[] visitedArr, char[] charArr) {
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
		System.out.println("Visited vertex: " + visitedVertex);
		System.out.println("-------------");
	}

	
	// find the smallest and not visited vertex
	private static int minIndexInArr(Integer[] minDis, boolean[] visitedArr) {
		Integer tempMinVal = INF;
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
	
	// avoid the sum of two numbers over the highest limitation of Integer
	static private Integer plus(Integer a, Integer b) {
		if(a == INF || b == INF) {
			return INF;
		}else {
			return a + b;
		}
	}

}
