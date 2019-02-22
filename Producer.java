import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class Producer implements Runnable{
	private LinkedBlockingQueue queue;
	private int num;

	public Producer(LinkedBlockingQueue queue) {
		Main.run = true;
		this.queue = queue;
	}

	public int produced() {
			return num;
	}

	public boolean isRunning() {
		return Main.run;
	}

	@Override
	public void run() {
		Random random = new Random();
		for (; num < 1000; num++) {
			try {
				queue.put(Double.toString(random.nextDouble()));
				if (num % 100 == 0 && num != 0) System.out.println("Producer: " + num);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Main.run = false;
	}
}
