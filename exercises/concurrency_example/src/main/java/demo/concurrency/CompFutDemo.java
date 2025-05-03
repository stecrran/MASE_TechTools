package demo.concurrency;

import java.util.Scanner;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompFutDemo {

	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String... args) {
		
		try {
			demo1();	// Simple syntax.
			demo2();	// Create a Runnable.
			demo3();	// Create a Supplier.
			demo4();	// Apply actions on completion.
			demo5();	// Apply actions that themselves return Futures.
		}
		catch (CancellationException | ExecutionException |InterruptedException ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	private static void demo1() throws CancellationException, ExecutionException, InterruptedException {
		// Just create a CompletableFuture manually, and complete it explicitly. 
		// This will unlock any clients waiting on the Future. 
		// It will also fire completion callbacks immediately.
		CompletableFuture<String> future = new CompletableFuture<>();
		future.complete("Super swans");
		String result = future.get();    // There's also getNow(valueIfAbsent), doesn't block, handy for robustness.
		System.out.printf("\nIn demo1(), future value is %s\n", result);
	}


	private static void demo2() throws CancellationException, ExecutionException, InterruptedException {
		// Create a CompletableFuture that runs a Runnable. 
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			for (int i = 0; i < 10000; i++) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException ex) {}
			}
		});
		
		// Allow the user to complete it prematurely, or wait for it to complete naturally.
		System.out.print("\nIn demo2(), do you want to forcibly complete Runnable? ");
		String response = scanner.nextLine().toLowerCase();
		if (response.startsWith("y"))
			future.complete(null);
		else 
			future.join();  // Wait until it's finished.
		
		System.out.printf("Runnable has completed.\n");
	}

	private static void demo3() throws CancellationException, ExecutionException, InterruptedException {
		// Create a CompletableFuture that runs a Supplier. 
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			for (int i = 0; i < 10000; i++) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException ex) {}
			}
			return "Simon Peter";
		});
		
		// Allow the user to complete it prematurely, or wait for it to complete naturally.
		System.out.print("\nIn demo3(), do you want to forcibly complete Supplier? ");
		String response = scanner.nextLine().toLowerCase();
		if (response.startsWith("y"))
			future.complete("Forced completion!");
		else 
			future.join();
		
		System.out.printf("Supplier completed with value: %s\n", future.get());
	}

	
	private static void demo4() throws CancellationException, ExecutionException, InterruptedException {
		// Create a CompletableFuture and apply actions on completion.
		CompletableFuture<String> future = CompletableFuture.supplyAsync(CompFutDemo::getBestDefender);
		
		CompletableFuture<Integer> finalFuture = future.thenApply(String::length)
		                                               .thenApply(n -> n * n);
		
		System.out.printf("\nIn demo4(), final value: %s\n", finalFuture.get());
	}

	
	private static void demo5() throws CancellationException, ExecutionException, InterruptedException {
		// Chain together actions that each return a CompletableFuture;
		CompletableFuture<String> playerFuture = CompletableFuture.supplyAsync(CompFutDemo::getBestDefender);
		
		CompletableFuture<Integer> finalFuture = playerFuture.thenCompose(CompFutDemo::getLength)
				                                             .thenCompose(CompFutDemo::getSquare);

		System.out.printf("\nIn demo5(), final value: %s\n", finalFuture.get());
	}

	
	// A slow method that runs synchronously and returns a String.
	private static String getBestDefender() {
		for (int i = 0; i < 5000; i++) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException ex) {}
		}
		return "Ashley Williams";
	}

	
	// A slow method that runs asynchronously and returns a Future.
	private static CompletableFuture<Integer> getLength(final String str) {
		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
			for (int i = 0; i < 3000; i++) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException ex) {}
			}
			return str.length();
		});
		return future;
	}

	
	// Another slow method that runs asynchronously and returns a Future.
	private static CompletableFuture<Integer> getSquare(final Integer num) {
		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
			for (int i = 0; i < 3000; i++) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException ex) {}
			}
			return num * num;
		});
		return future;
	}
}

