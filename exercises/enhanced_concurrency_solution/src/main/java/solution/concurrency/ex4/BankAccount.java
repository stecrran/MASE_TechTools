package solution.concurrency.ex4;

import java.util.concurrent.locks.StampedLock;

public class BankAccount {
	
	private final StampedLock sl = new StampedLock();
	
	private double balance;

	public BankAccount(double balance) {
		this.balance = balance;
	}

	public void deposit(double amount) {
		long stamp = sl.writeLock();
		try {
			balance += amount;
		} 
		finally {
			sl.unlockWrite(stamp);
		}
	}

	public void withdraw(double amount) {
		long stamp = sl.writeLock();
		try {
			balance -= amount;
		} 
		finally {
			sl.unlockWrite(stamp);
		}
	}

	public double getBalance() {
		long stamp = sl.readLock();
		try {
			return balance;
		} 
		finally {
			sl.unlockRead(stamp);
		}
	}
}
