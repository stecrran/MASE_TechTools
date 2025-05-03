package demo.concurrency;

public class Employee {

	private String name;
	private String nationality;
	private double salary;
	private int yearsExperience;
	
	public Employee(String name, String nationality, double salary, int yearsExperience) {
		this.name = name;
		this.nationality = nationality;
		this.salary = salary;
		this.yearsExperience = yearsExperience;
	}
	
	public String getName() {
		return name;
	}

	public String getNationality() {
		return nationality;
	}

	public double getSalary() {
		return salary;
	}

	public int getYearsExperience() {
		return yearsExperience;
	}

	@Override
	public String toString() {
		return String.format("%s, nationality %s, earns €%.2f, years experience %d", name, nationality, salary, yearsExperience);
	}
}