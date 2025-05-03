package solution.concurrency.ex2;

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
		String allNationalities = staff.reduceValues(parallelismThreshold, Employee::getNationality, (n1, n2) -> n1 + " | " + n2);
		System.out.printf("All nationalities: %s\n", allNationalities);
	}
	
	private static void doReduceValuesToDouble(long parallelismThreshold) {
		double totalSalary = staff.reduceValuesToDouble(parallelismThreshold, Employee::getSalary, 0.0, (s1,s2) -> s1 + s2);
		System.out.printf("Total salary: £%.2f\n", totalSalary);
	}

	private static void doReduceValuesToInt(long parallelismThreshold) {
		int totalYearsExperience = staff.reduceValuesToInt(parallelismThreshold, Employee::getYearsExperience, 0, (y1,y2) -> y1 + y2);
		System.out.printf("Total years experience: %d\n", totalYearsExperience);
		
		int minYearsExperience = staff.reduceValuesToInt(parallelismThreshold, Employee::getYearsExperience, Integer.MAX_VALUE, (y1,y2) -> y1 < y2 ? y1 : y2);
		System.out.printf("Minimum years experience: %d\n", minYearsExperience);

		int maxYearsExperience = staff.reduceValuesToInt(parallelismThreshold, Employee::getYearsExperience, Integer.MIN_VALUE, (y1,y2) -> y1 > y2 ? y1 : y2);
		System.out.printf("Maximum years experience: %d\n", maxYearsExperience);
	}
}
