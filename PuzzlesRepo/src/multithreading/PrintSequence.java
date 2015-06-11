package multithreading;

public class PrintSequence {
	

	public static void main(String[] args) {
		Counter cnt = new Counter(0);
		PrintEvenThread even = new PrintEvenThread(cnt);
		PrintOddThread odd = new PrintOddThread(cnt);
		even.start();
		odd.start();
		
	}

}
