package student.concurrency.ex4;

import java.util.Random;

public class Generator {

	private static Random generator = new Random();

	public static double generate() {
		return generator.nextDouble() * 1000;
	}
}
