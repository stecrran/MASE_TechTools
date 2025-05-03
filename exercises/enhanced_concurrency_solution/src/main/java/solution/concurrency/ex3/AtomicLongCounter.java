package solution.concurrency.ex3;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongCounter implements Counter {

	private final AtomicLong atomic = new AtomicLong();
	
	@Override
	public long getCounter() {
		return atomic.get();
	}

	@Override
	public void increment() {
		atomic.incrementAndGet();
	}
}

