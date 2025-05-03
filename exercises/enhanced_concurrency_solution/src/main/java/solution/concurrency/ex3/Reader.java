package solution.concurrency.ex3;

public class Reader implements Runnable {

	private final Counter counter;
	private final Launcher launcher;
		
	public Reader(Counter counter, Launcher launcher) {
		this.counter = counter;
		this.launcher = launcher;
	}
		
	public void run() {
		while (true)  {
			if (Thread.interrupted()) {
				break;
			}
			
			long count = counter.getCounter();			
			if (count > launcher.TARGET_NUMBER) {
				launcher.executorService.shutdownNow();
				break;
			}
		}
	}
}
