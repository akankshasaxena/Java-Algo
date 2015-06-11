package multithreading;

public class PrintingMachineImpl {
	//volatile int cnt = 1;
		public static void main(String args[]){
			int cnt = 5;
			PrinitingMachine thread1 = new PrinitingMachine(1, 25, cnt);
			PrinitingMachine thread2 = new PrinitingMachine(2, 25, cnt);
			PrinitingMachine thread3 = new PrinitingMachine(3, 25, cnt);
			PrinitingMachine thread4 = new PrinitingMachine(4, 25, cnt);
			PrinitingMachine thread5 = new PrinitingMachine(0, 25, cnt);
			thread1.start();thread2.start();
			thread3.start();
			thread4.start();
			thread5.start();
			
		}
}
