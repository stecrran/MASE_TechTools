package student.concurrency.ex4;

public class Main {

	public static void main(String... args) {

		BankAccount acc1 = new BankAccount(10000);
		
		Thread t1 = new Thread(new Depositer(acc1));
		t1.start();
		
		Thread t2 = new Thread(new Withdrawer(acc1));
		t2.start();
	}

}
