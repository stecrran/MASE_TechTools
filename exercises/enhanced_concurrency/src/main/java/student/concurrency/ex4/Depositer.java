package student.concurrency.ex4;

public class Depositer implements Runnable {

	private BankAccount account;
	
	public Depositer(BankAccount account) {
		this.account = account;
	}
	
	public void run() {
		for (int i = 0; i < 50; i++) {
			
			double amount = Generator.generate();
			account.deposit(amount);
			
			System.out.printf("Deposited %.2f, balance %.2f\n", amount, account.getBalance());

			try {
				Thread.sleep(100);
			}
			catch(InterruptedException ex) {}
		}
	}
}
