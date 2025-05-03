package solution.concurrency.ex3;

public class Main {

	public static void main(String... args) {

		Launcher launcher = new Launcher();
		
		System.out.println("Launching time-consuming operation using an AtomicLongCounter...");
		launcher.doIt(new AtomicLongCounter());

		System.out.println("\nLaunching time-consuming operation using a LongAdderCounter...");
		launcher.doIt(new LongAdderCounter());
	}
}