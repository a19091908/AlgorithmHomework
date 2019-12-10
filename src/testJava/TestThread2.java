package testJava;

import java.util.LinkedList;
import java.util.Scanner;

public class TestThread2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Log log = new Log();
		log.start();
		System.out.print("Type some words: ");
		while (scan.hasNext()) {
			String str = scan.nextLine().toUpperCase();
			if (str.equals("N"))
				break;
			log.addList(str);
			System.out.print("Type your name: ");
		}
		log.stopThread();
		System.out.println("結束");
	}

}

class Log extends Thread {
	boolean runFlag = true;
	private LinkedList<String> list = new LinkedList<String>();

	@Override
	public void run() {
		try {
			while (runFlag) {
				sleep(5000);

				while (!list.isEmpty()) {
					String name = getListEle();
					System.out.println("\n*****" + name + "註冊成功。" + "*****" );
				}

			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void addList(String name) {
		list.push(name);
	}

	public String getListEle() {
		String name = list.remove();
		return name;
	}
	public void stopThread() {
		runFlag = false;
	}
}
