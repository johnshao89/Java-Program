package com.github.johnshao89.practice;

public class Account {
	private int id;
	private double balance;
	private double annualInterestRate;
	
	public Account(int id, double balance, double annualInterestRate) {
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	
	public void withdraw(double amount) {
		if(this.balance>amount) {
			this.balance -=amount;
			System.out.println("成功取出："+amount);
		}else {
			System.out.println("余额不足，取款失败");
			return;
		}
	}
	
	public void deposit(double amount) {
		this.balance +=amount;
		System.out.println("成功存入："+amount);
	}
	
	
}
