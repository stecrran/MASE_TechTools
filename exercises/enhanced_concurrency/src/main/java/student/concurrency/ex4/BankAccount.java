package student.concurrency.ex4;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BankAccount {
	
	private final ReadWriteLock lock = new ReentrantReadWriteLock();
	
	private double balance;

	public BankAccount(double balance) {
		this.balance = balance;
	}

	public void deposit(double amount) {
		lock.writeLock().lock();
	    try {
	      balance += amount;
	    } 
	    finally {
	      lock.writeLock().unlock();
	    }
	}

	public void withdraw(double amount) {
		lock.writeLock().lock();
	    try {
	      balance -= amount;
	    } 
	    finally {
	      lock.writeLock().unlock();
	    }
	}

	public double getBalance() {
	   lock.readLock().lock();
	    try {
	      return balance;
	    } 
	    finally {
	      lock.readLock().unlock();
	    }
	}
}
