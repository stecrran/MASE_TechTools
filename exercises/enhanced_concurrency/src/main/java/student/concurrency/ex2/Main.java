package student.concurrency.ex2;

import java.util.concurrent.ConcurrentHashMap;

public class Main {

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

	public static void main(String... args) {
		doReduceValues(5);
		doReduceValuesToDouble(5);
		doReduceValuesToInt(5);
	}
	
	// Reduction methods.
	private static void doReduceValues(long parallelismThreshold) {

		// TODO: Call reduceValues() to get a String containing the employees' nationalities, e.g. "Poland | Spain | Wales ... | Netherlands".
		//       Then display the string on the console.

		
	}
	
	private static void doReduceValuesToDouble(long parallelismThreshold) {
		
		// TODO: Call reduceValuesToDouble() to get a double containing the sum of all the employees' salaries.
		//       Then display the value on the console.

		
	}

	private static void doReduceValuesToInt(long parallelismThreshold) {
		
		// TODO: Call reduceValuesToInt() to get an int containing the sum of all the employees' years experience.
		//       Then display the value on the console.

		
		// TODO: Call reduceValuesToInt() to get an int containing the minimum years experience of any employee.
		//       Then display the value on the console.
		
		
		// TODO: Call reduceValuesToInt() to get an int containing the maximum years experience of any employee.
		//       Then display the value on the console.
		
		
	}
}
