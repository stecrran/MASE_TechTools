package student.concurrency.ex4;

public class Withdrawer implements Runnable {

	private BankAccount account;
	
	public Withdrawer(BankAccount account) {
		this.account = account;
	}
	
	public void run() {
		for (int i = 0; i < 50; i++) {

			double amount = Generator.generate();
			account.withdraw(amount);
			
			System.out.printf("Withdrew %.2f, balance %.2f\n", amount, account.getBalance());

			try {
				Thread.sleep(100);
			}
			catch(InterruptedException ex) {}
		}
	}
}
