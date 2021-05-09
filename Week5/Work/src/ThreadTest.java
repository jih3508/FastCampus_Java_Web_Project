
public class ThreadTest implements Runnable{
	
	public ThreadTest() {}
	
	public void run() {
		System.out.println(Thread.currentThread().getName() + " : Thread Start.");
		for (int i = 0; i< 10; i++) {
			try {
				Thread.sleep(1000);
				System.out.println(i+1+"��");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " : Thread End.");
	}

	public static void main(String[] args) {
		
		Thread thread = new Thread(new ThreadTest());
		thread.start();
		System.out.println("Thread�� ����ɶ����� ��ٸ��ϴ�.");
		try {
			thread.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Main Thread End");
	}
}
