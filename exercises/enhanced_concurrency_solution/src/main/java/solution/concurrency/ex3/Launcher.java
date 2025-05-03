package solution.concurrency.ex3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Launcher {

	public final long TARGET_NUMBER = 500000000;
	public ExecutorService executorService;

	private final int NUM_THREADS = 20;

	public void doIt(Counter counter) {

		executorService = Executors.newFixedThreadPool(10);

		long start = System.currentTimeMillis();

		for (int j = 0; j < NUM_THREADS; j += 2) {
			executorService.execute(new Reader(counter, this));
			executorService.execute(new Writer(counter));
		}

		try {
			executorService.awaitTermination(10, TimeUnit.MINUTES);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();
		System.out.printf("Elapsed time %d\n", end - start);
	}
}
