package demo.asyncAndScheduledMethods;

import java.util.Date;

public class Util {

	public static void display(String message) {
		System.out.printf("%s, thread %02d: %s\n", new Date(), Thread.currentThread().getId(), message);
		
	}
}
