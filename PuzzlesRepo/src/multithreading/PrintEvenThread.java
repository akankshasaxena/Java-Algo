package multithreading;

public class PrintEvenThread extends Thread {
	Counter cnt;
	PrintEvenThread(Counter cnt){
		this.cnt = cnt;
	}
	public void run(){
		while(cnt.getCounter() <= 20){
			try {
				cnt.printEvenCounter();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
