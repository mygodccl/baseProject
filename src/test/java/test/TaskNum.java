package test;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class TaskNum implements Runnable {

	private List<NumCup> cups;

	private CountDownLatch count;
	
	private int num;

	public TaskNum(List<NumCup> cups, CountDownLatch count, int num) {
		this.cups = cups;
		this.count = count;
		this.num = num;
	}

	@Override
	public void run() {
		GetLCM.getAll(num, cups);
		count.countDown();
	}

}
