package corejava.thread.synchronization;

import javassist.expr.NewArray;

public class BlockSyn extends Thread {

	Bank bank = null;

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public BlockSyn(String threadName) {
		super(threadName);
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			try {
				if (getName().equals("Deposite Thread")) {
					getBank().deposit();
				} else if (getName().equals("Draw Thread")) {
					getBank().draw();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		Bank bank = new Bank();

		BlockSyn thread1 = new BlockSyn("Deposite Thread");
		thread1.setBank(bank);
		BlockSyn thread2 = new BlockSyn("Draw Thread");
		thread2.setBank(bank);
		thread1.start();
		thread2.start();
	}

}

class Bank {

	int balance = 1000;

	byte[] mutex = new byte[] {};
	
	public void deposit() throws Exception {

		synchronized (mutex) {
			int temp = balance;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			balance += 1000;
			if (balance != temp + 1000) {
				throw new Exception("Error.");
			} else {
				System.out.println("Deposit successfully:" + balance);
			}
		}

	}

	public void draw() throws Exception {

		synchronized (mutex) {

			int temp = balance;
			try {
				Thread.sleep(9);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			balance -= 500;
			if (balance != temp - 500) {
				throw new Exception("Error.");
			} else {
				System.out.println("Draw successfully:" + balance);
			}
		}
	}

}
