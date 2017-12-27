package test;

public class Producer extends Thread {
	Thread other;

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("I am Producer : Produced Item " + i);
		}
	}

	public Thread getOther() {
		return other;
	}

	public void setOther(Thread other) {
		this.other = other;
	}

}
