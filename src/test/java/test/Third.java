package test;

public class Third extends Thread {
	Thread other;

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("I am Third : Third Item " + i);
			// try {
			// Thread.sleep(1000L);
			// } catch (InterruptedException e) {
			// e.printStackTrace();
			// }
			// Thread.yield();
		}
	}

	public Thread getOther() {
		return other;
	}

	public void setOther(Thread other) {
		this.other = other;
	}

}
