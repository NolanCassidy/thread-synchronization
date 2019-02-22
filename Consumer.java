import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class Consumer implements Runnable {
	private LinkedBlockingQueue<String> queue;
	private Producer prod1;
	private int num;

	public Consumer(LinkedBlockingQueue<String> queue, Producer prod1) {
		this.queue = queue;
		this.prod1 = prod1;
	}

	public int consumed() {
		return num;
	}

	public boolean isRunning() {
		return Main.run;
	}

	@Override
	public void run() {
		Random random = new Random();
		while (!queue.isEmpty() || prod1.isRunning()) {
			try {
				Thread.sleep(random.nextInt(10));
				queue.take();
				if (num % 100 == 0 && num != 0)
					System.out.println("Consumer 1: 100");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			num++;
		}
	}
}
