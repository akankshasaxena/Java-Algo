package multithreading;

public class PrinitingMachine extends Thread{

	private int poolSize = 0;
	private int limit = 0;
	private volatile static int cnt  = 1;
	private int threadId = 0;
	
	PrinitingMachine(int threadId,int limit,int poolsize) {
		this.threadId = threadId;
		this.limit = limit;
		this.poolSize = poolsize;
	}
	
	public void run(){
		while(cnt<limit){
			//synchronized(this){
				if(cnt%poolSize == threadId){
					System.out.println(cnt);
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					cnt++;
					//notifyAll();
				}/*else{
					try {
						System.out.println("me in wait"+threadId);
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};*/
		}
	}
}
