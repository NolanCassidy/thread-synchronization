import java.util.concurrent.LinkedBlockingQueue;

public class Main {
	public static boolean run = true;
	private static Consumer con1;
	private static Conusumer2 con2;
	private static Producer prod1;

	public static void main(String[] args) {
		LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>(100);
		prod1 = new Producer(queue);
		con1 = new Consumer(queue, prod1);
		con2 = new Conusumer2(queue, prod1);
		Thread prod1Thread = new Thread(prod1);
		Thread con1Thread = new Thread(con1);
		Thread con2Thread = new Thread(con2);
		prod1Thread.start();
		con1Thread.start();
		con2Thread.start();
	}

	public static void summary() {
		System.out.println("Summary");
		System.out.println("Producer One: " + prod1.produced());
		System.out.println("Consumer One: " + con1.consumed());
		System.out.println("Consumer Two: " + con2.consumed());
	}
}
