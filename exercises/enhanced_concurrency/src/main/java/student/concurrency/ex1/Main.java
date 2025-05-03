package student.concurrency.ex1;

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

	
	// Program entry point.
	public static void main(String... args) {
		doSearch(5);
		doSearchEntries(5);
		doSearchValues(5);
	}
	
	
	// Test method, to help implement the lambda expression for search operations.
	private static Employee testEmployeeSalary(Employee emp) {
		System.out.printf("  [Thread %2d], testing employee %s\n", getThreadId(), emp);
		return emp.getSalary() > 60000 ? emp : null;
	}

	
	// Search methods.
	private static void doSearch(long parallelismThreshold) {
		
		System.out.printf("\nsearch() with parallelismThreshold %d\n", parallelismThreshold);
		
		// TODO: Search for all employees that match a test condition, via the search() method.
		//       Then call displayEmployee() to display the employee.

	}

	private static void doSearchEntries(long parallelismThreshold) {

		System.out.printf("\nsearchEntries() with parallelismThreshold %d\n", parallelismThreshold);
		
		// TODO: Search for all employees that match a test condition, via the searchEntries() method.
		//       Then call displayEmployee() to display the employee.

	}
	
	private static void doSearchValues(long parallelismThreshold) {

		System.out.printf("\nsearchValues() with parallelismThreshold %d\n", parallelismThreshold);

		// TODO: Search for all employees that match a test condition, via the searchValues() method.
		//       Then call displayEmployee() to display the employee.

	}

	
	// Helper methods, to display details.
	private static void displayEmployee(Employee emp) {
		if (emp != null) {
			System.out.println(emp);
		}
		else {
			System.out.println("No employee found.");
		}
	}

	
	// Helper methods, to get the Thread ID for the current thread..
	private static long getThreadId() {
		return Thread.currentThread().getId();
	}
}
