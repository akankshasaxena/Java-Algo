package multithreading;

public class Counter {
	private volatile int counter = 0;
	
	Counter(int cnt){
		counter  = cnt;
	}

	int getCounter() {
		return counter;
	}

	synchronized void printEvenCounter() throws InterruptedException {
		if(counter%2==0){
			System.out.println(counter);
			this.counter++;
			notifyAll();
		}else{
			wait();
		}
	}
	
	synchronized void printOddCounter() throws InterruptedException {
		if(counter%2!=0){
			System.out.println(counter);
			this.counter++;
			notifyAll();
		}else{
			wait();
		}
	}
	
}
