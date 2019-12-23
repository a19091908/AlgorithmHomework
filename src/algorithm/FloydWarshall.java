package algorithm;

public class FloydWarshall {
	static final Integer inf = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int size = 7;
		
		Integer[][] d0 = {
				{0,5,18,6,inf,inf,inf},
				{5,0,12,19,14,inf,inf},
				{18,12,0,3,2,19,1},
				{6,9,3,0,inf,3,10},
				{inf,14,2,inf,0,15,inf},
				{inf,20,19,3,15,0,21},
				{inf,inf,1,10,inf,21,0}
		};
		
		// check do is a square matrix
		if(size != d0.length) {
			throw new Exception("d0 do not match the size given above");
		}else {
			for (int i = 0; i< size ; i++) {
				Integer[] row = d0[i];
				if (row.length != size) {
					throw new Exception("d0 is not a square matrix. "
							+ "The mismatch appears in row " + (i+1));
				}
			}
		}


		// set v0 matrix
		Integer[][] v0 = new Integer[size][size];
		for(int i = 0 ; i < size ; i++) {
			for(int j = 0 ; j < size ; j++) {
				if(i==j || d0[i][j].equals(inf)) {
					v0[i][j] = null;
				}else {
					v0[i][j] = i+1;
				}
			}
		}
		
		
		
		Integer[][] d = d0;
		Integer[][] v = v0;		
		
		for(int i = 0 ; i < size ; i++) {
//			i = 0 ~ 4, 
//			and that means each row tries to update its all values by passing through vertex(i+1) 
			for(int k = 0 ; k < size ; k++) {
//				k = 0 ~ 4,
//				and that means recent processing row
				if(i == k) {
					continue;
				}else {
					if(! d[k][i].equals(inf)) {
						Integer kToI = d[k][i];
						for(int j = 0 ; j < size ; j++) {
//							j = 0 ~ 4,
//							and that means the column
							if(plus(kToI,d[i][j]) < d[k][j]) {
								d[k][j] = plus(kToI, d[i][j]);
								v[k][j] = i+1;
							}
						}
					}
				}
			}		
		}
		
//		print the result of d
		for(Integer[] row: d) {
			for(Integer value: row) {
				System.out.print(value + ", ");
			}
			System.out.println("");
		}
		System.out.println("-------------------");
		
//		print the result of v
		for(Integer[] row: v) {
			for(Integer value: row) {
				System.out.print(value + ", ");
			}
			System.out.println("");
		}
	}
	
	static private Integer plus(Integer a, Integer b) {
		if(a == inf || b == inf) {
			return inf;
		}else {
			return a + b;
		}
	}

}
