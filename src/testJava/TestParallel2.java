package testJava;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class TestParallel2 {
	static final int n = 500;

	public static void main(String[] args) throws InterruptedException {
		long startTime, endTime;
		Integer num;
		SeqSum seqnum = new SeqSum(n);

		startTime = System.currentTimeMillis();
		num = (Integer) new ForkJoinPool().invoke(seqnum);
		endTime = System.currentTimeMillis();
		
		System.out.println(num);
		System.out.println("use parallel: The speed is " + (endTime - startTime));
//		-----------------------------------------------------------------------------------------
		System.out.println("------------------------------------------------------------------");
//		-----------------------------------------------------------------------------------------

		startTime = System.currentTimeMillis();
		num = seqnum.recurSum(n);
		endTime = System.currentTimeMillis();
		
		System.out.println(num);
		System.out.println("not use parallel:  The speed is " + (endTime - startTime));

	}

}

class SeqSum extends RecursiveTask {
	static final int limitation = 10;
	int n;

	SeqSum(int n) {
		this.n = n;
	}

	@Override
	protected Integer compute() {
		if (n < limitation) {
			return recurSum(n);
		} else {
			SeqSum seqSum = new SeqSum(n - 1);
			seqSum.fork();
			return (Integer) seqSum.join() + n;
		}
	}

	static public int recurSum(int n) {
		if(n == 1 ) 
			return 1;
		else
			return recurSum(n - 1) + n;

	}

}
