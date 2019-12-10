package testJava;


public class TestThread  {

	public  static void main(String[] params) {
		ActA ra1 = new ActA(3, "Thread1");
		ActA ra2 = new ActA(2, "Thread2");
		
		Thread tr1 = new Thread(ra1);
		Thread tr2 = new Thread(ra2);
		tr2.start();
		tr1.start();
		
		
		System.out.println("main");
	}

}

class ActA implements Runnable{
	int max;
	String name;
	
	ActA(int max, String name){
		this.max = max;
		this.name = name;
	}
	
	@Override
	public void run() {
		long startTime = System.currentTimeMillis();

		for(int i = 0; i < max ; i++) {
			System.out.println(this.name + ": i = " + i);

		}
		
		long endTime = System.currentTimeMillis();

		System.out.println(this.name + " is over , and  it spends " + (endTime - startTime) );
		
	}
	
}

