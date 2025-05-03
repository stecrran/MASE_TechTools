package demo.concurrency;

import java.util.concurrent.ConcurrentHashMap;

public class ConcHashDemo {

	private static ConcurrentHashMap<Integer, Employee> staff;
	
	static {
		staff = new ConcurrentHashMap<>();
		staff.put(1,  new Employee("Fabianski", "Poland", 50000, 12));
		staff.put(2,  new Employee("Amat", "Spain", 20000, 6));
		staff.put(3,  new Employee("Taylor", "Wales", 30000, 5));
		staff.put(4,  new Employee("Ki", "South Korea", 45000, 8));
		staff.put(5,  new Employee("Tate", "England", 15000, 19));
		staff.put(6,  new Employee("Williams", "Wales", 65000, 12));
		staff.put(7,  new Employee("Britton", "England", 30000, 14));
		staff.put(8,  new Employee("Shelvey", "England", 55000, 5));
		staff.put(9,  new Employee("Oliveira", "Portugal", 20000, 6));
		staff.put(10, new Employee("Gomis", "France", 90000, 7));
		staff.put(11, new Employee("Emnes", "Netherlands", 25000, 7));
	}

	// Program entry point.
	public static void main(String... args) {
		demoForEach();
		demoForEachEntry();
		demoForEachKey();
		demoForEachValue();
	}
	
	// Demo methods.
	private static void demoForEach() {
		System.out.println("forEach() sequentially");
		staff.forEach(ConcHashDemo::displayKeyValuePair);
		
		System.out.println("\nforEach() with parallelismThreshold=5");
		staff.forEach(5, ConcHashDemo::displayKeyValuePair);
	}
	
	private static void demoForEachEntry() {
		System.out.println("\nforEachEntry() with parallelismThreshold=5");
		staff.forEachEntry(5, ConcHashDemo::displayEntry);
		
		System.out.println("\nforEachEntry() with parallelismThreshold=100");
		staff.forEachEntry(100, ConcHashDemo::displayEntry);
	}		
	
	private static void demoForEachKey() {
		System.out.println("\nforEachKey() with parallelismThreshold=5");
		staff.forEachKey(5, ConcHashDemo::displayKey);

		System.out.println("\nforEachKey() with parallelismThreshold=100");
		staff.forEachKey(100, ConcHashDemo::displayKey);
	}
	
	private static void demoForEachValue() {
		System.out.println("\nforEachValue() with parallelismThreshold=5");
		staff.forEachValue(5, ConcHashDemo::displayValue);
		
		System.out.println("\nforEachValue() with parallelismThreshold=100");
		staff.forEachValue(100, ConcHashDemo::displayValue);
	}

	
	// Helper methods, to display details.
	private static void displayKeyValuePair(int key, Employee value) {
		System.out.printf("  [Thread %2d], key: %d, value: %s\n", getThreadId(), key, value);
	}
	
	private static void displayEntry(ConcurrentHashMap.Entry<Integer, Employee> entry) {
		displayKeyValuePair(entry.getKey(), entry.getValue());
	}

	private static void displayKey(int key) {
		System.out.printf("  [Thread %2d], key: %d\n", getThreadId(), key);
	}
	
	private static void displayValue(Employee value) {
		System.out.printf("  [Thread %2d], value: %s\n", getThreadId(), value);
	}
	
	private static long getThreadId() {
		return Thread.currentThread().getId();
	}
}
