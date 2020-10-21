package com.github.johnshao89.practice2;

public class Account {
	private double balance;
	
	public Account(double balance) {
		this.balance = balance;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public void deposit(double amount) {
		if(amount>=0) {
			this.balance +=amount;
		}else {
			System.out.println("Invalid input!");
		}
	}
	
	public void withdraw(double amount) {
		if(this.balance<amount) {
			System.out.println("Can not make a withdraw, not enough balance!");
		}else {
			this.balance -= amount;
		}
	}
}
