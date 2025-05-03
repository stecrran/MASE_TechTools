package solution.concurrency.ex3;

import java.util.concurrent.atomic.LongAdder;

public class LongAdderCounter implements Counter {

	private final LongAdder adder = new LongAdder();
	
	@Override
	public long getCounter() {
		return adder.longValue();
	}

	@Override
	public void increment() {
		adder.increment();
	}
}
