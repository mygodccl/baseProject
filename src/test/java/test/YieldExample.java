package test;

public class YieldExample {
	public static void main(String[] args) {
		Producer producer = new Producer();
		Consumer consumer = new Consumer();
//		Third third = new Third();
		producer.setOther(consumer);
		consumer.setOther(producer);

//		producer.setPriority(Thread.MIN_PRIORITY); // Min Priority
//		consumer.setPriority(Thread.MAX_PRIORITY); // Max Priority
//		third.start();
		producer.start();
		consumer.start();
	}
}