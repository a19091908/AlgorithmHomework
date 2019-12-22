package algorithm;

public class MatrixMultiple {
	// define some of the matrix's sizes that you want to compute
	static final int[] matrixProduct = {5,10,3,12,5,50,6};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matrixLength = matrixProduct.length - 1;
		int[][] m = new int[matrixLength][matrixLength];
		
		for (int i = matrixLength - 2; i >= 0; i--) {
			for (int j = i + 1; j < matrixLength; j++) {
				int theNumberOfProduct = j - i;
				if (theNumberOfProduct == 1) {
					m[i][j] = matrixProduct[i] * matrixProduct[i + 1] * matrixProduct[i + 2];
				} else {
					int tempNum;
					int minNum = 99999999;
					for (int k = 1; k <= theNumberOfProduct; k++) {
						tempNum = m[i][i + k - 1] + m[i + k][j]
								+ matrixProduct[i] * matrixProduct[i + k] * matrixProduct[j + 1];
						if (minNum > tempNum) {
							minNum = tempNum;
						}
					}
					m[i][j] = minNum;

				}

			}

		}
		
		for(int[] row: m) {
			for(int num: row ) {
				System.out.print(num + ",");
			}
			System.out.println("");
		}

	}

}
