package demo.concurrency;

import java.util.concurrent.CountedCompleter;
import java.util.function.Consumer;

public class CountedDemo {

	public static void main(String... args) {

		Integer[] numbers = generateNumbers();
		
		ForEachCountedCompleter.doIt(numbers, n -> System.out.println(n));
	}
	
	private static Integer[] generateNumbers() {
		Integer[] numbers = new Integer[20];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i; 
		}
		return numbers;
	}
}

// This class extends CountedCompleter, to implement a recursive divide-and-conquer traversal of a collection.
class ForEachCountedCompleter<T> extends CountedCompleter<Void> {

	final T[] array;
	final Consumer<T> op;
	final int lo, hi;
	private static final long serialVersionUID = 1L;

	//  Convenience factory method, creates and invokes the base task (to process the whole array).
	public static <T> void doIt(T[] array, Consumer<T> op) {
		
		// Create a ForEachCountedCompleter (pending count is 0 by default).
		ForEachCountedCompleter<T> task = new ForEachCountedCompleter<T>(null, array, op, 0, array.length);
		
		// Call invoke() to commence performing the task. This will cause the compute() method to be invoked on our ForEachCountedCompleter instance.
		task.invoke();
	}

	// Constructor for a given instance of ForEachCountedCompleter, to process part of an array.
	ForEachCountedCompleter(CountedCompleter<?> p, T[] array, Consumer<T> op, int lo, int hi) {
		super(p);
		this.array = array;
		this.op = op;
		this.lo = lo;
		this.hi = hi;
	}

	// Here's the processing for our ForEachCountedCompleter instance.
	// It recursively splits the array into halves, and forks a separate ForEachCountedCompleter instance for each half.
	public void compute() { 
		
		// If there's more than 1 element to process, then split the work into two halves.
		if (hi - lo > 1) {
			
			int mid = (lo + hi) / 2;		

			// Set the pending count before we fork tasks, so we know when it's all complete.			
			setPendingCount(2); 			
			
			// Create two ForEachCountedCompleter instances, for the lower and upper parts of the array. 
			// Pass ourselves (i.e. this) as the completer for both. 
			ForEachCountedCompleter<T> lower = new ForEachCountedCompleter<T>(this, array, op, lo, mid); 
			ForEachCountedCompleter<T> upper = new ForEachCountedCompleter<T>(this, array, op, mid, hi); 
			
			// Now fork both ForEachCountedCompleter instances.
			System.out.println("Fork lower");
			lower.fork();
			System.out.println("Fork upper");
			upper.fork();
		} 
		else { 
			// There's only one piece of work, so just do it ourselves!
			op.accept(array[lo]);
		}
		
		// Call tryComplete(), which does one of the following things:
		//
		//   - If the pending count is NOT zero, it means we're not complete yet. 
		//     So it just decrements the pending count.
		//
		//   - If the pending count IS zero, it means we ARE complete now. 
		//     So it invokes onCompletion(CountedCompleter).
		//     It then calls tryComplete() on the task's completer (if one exists), else marks this task as complete.
		tryComplete();	
	}
}