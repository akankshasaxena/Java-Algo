package multithreading;

public class PrintOddThread extends Thread {
	Counter cnt;
	PrintOddThread(Counter cnt){
		this.cnt = cnt;
	}
	public void run(){
		while(cnt.getCounter() <20){
			try {
				cnt.printOddCounter();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
