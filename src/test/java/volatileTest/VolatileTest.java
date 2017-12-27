package volatileTest;

public class VolatileTest implements Runnable{
	private volatile int num = 0;
	
	public static void main(String[] args) {
		VolatileTest volatileTest = new VolatileTest();
		new Thread(volatileTest, "a").start();
		new Thread(volatileTest, "b").start();
		new Thread(volatileTest, "c").start();
		
		int[] a = {1,2};
	}
	
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		for(int i=0; i<100; i++) {
			System.out.println(name + ":" +num);
			num = num + 1;
		}
	}
}
