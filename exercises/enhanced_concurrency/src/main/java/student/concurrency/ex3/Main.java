package student.concurrency.ex3;

public class Main {

	public static void main(String... args) {

		Launcher launcher = new Launcher();
		
		System.out.println("Launching time-consuming operation using an AtomicLongCounter...");
		launcher.doIt(new AtomicLongCounter());

		// TODO: Call launcher.doIt() again, but this time pass in a new LongAdderCounter.

	}
}