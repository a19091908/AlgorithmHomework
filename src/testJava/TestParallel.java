package testJava;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class TestParallel {
	static final int n = 40;

	public static void main(String[] args) {
		long startTime, endTime;
		
//		-----------------------------------------------------------------------------------------
	
		startTime = System.currentTimeMillis();

		Fibonacci  task = new Fibonacci (n);
        new ForkJoinPool().invoke(task);
        System.out.println("The answer is " + task.getNumber());
		
		endTime = System.currentTimeMillis();
		System.out.println("Use fork: the speed is " + (endTime - startTime));
		
//		-----------------------------------------------------------------------------------------
		System.out.println("------------------------------------------------------------------");
//		-----------------------------------------------------------------------------------------

		startTime = System.currentTimeMillis();
		
		long ans = Fibonacci .fib(n);
        System.out.println("The answer is " + ans);
		
		endTime = System.currentTimeMillis();
		System.out.println("Not use fork: the speed is " + (endTime - startTime));
//		-----------------------------------------------------------------------------------------

		
	}

}

class Fibonacci  extends RecursiveAction  {
    private static final long threshold = 10;
    private volatile long number;

    public Fibonacci (long number) {
        this.number = number;
    }

    public long getNumber() {
        return number;
    }

	@Override
    protected void compute() {
        long n = number;
        if (n <= threshold) {
            number = fib(n);
        } else {
        	Fibonacci  f1 = new Fibonacci (n - 1);
        	Fibonacci  f2 = new Fibonacci (n - 2);
            ForkJoinTask.invokeAll(f1, f2);

            number = f1.number + f2.number;
        }
    }

    public static long fib(long n) {
        if (n <= 1) 
        	return n;
        else 
        	return fib(n - 1) + fib(n - 2);
    }

}