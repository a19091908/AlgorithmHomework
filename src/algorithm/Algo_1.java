package algorithm;


public class Algo_1 {

	public static void main(String[] str) {

		// vertex array
		char[] charArr = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K' };

		// visited vertex array
		boolean[] visitedArr = new boolean[charArr.length];

		// we run the algorithm from A
		char startVertex = 'A';
		int startIndex = 0;

		// the shortest distance from start vertex to others
		double[] minDis = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

		// create the cost array between any two vertexes
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

		// set the value of the minDis to infinite except setting the start vertex to 0 
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


			// find the minimum number's index in minDis
			// and put this vertex(index) into visitedArr
			minIndex = minIndexInArr(minDis, visitedArr);
			if(minIndex == -1) {
				break;
			}
			visitedArr[minIndex] = true;

			// update all distance in minDis between the selected vertex and the vertex connecting to it   
			row = disArr[minIndex];
			for (int j = 0; j < row.length; j++) {
				// if the cost is 0, then skip
				// else compare the new distance is bigger than the old one, 
				// and put the smaller into minDis
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

	
	// find the smallest and not visited vertex
	private static int minIndexInArr(double[] minDis, boolean[] visitedArr) {
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
