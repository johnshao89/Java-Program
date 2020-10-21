package com.github.johnshao89.practice;

public class AccountAndCustomerTest {
	public static void main(String[] args) {
		Customer customer = new Customer("Jane","Smith");
		Account account = new Account(1000,2000,0.0123);
		customer.setAccount(account);
		customer.getAccount().deposit(100);
		customer.getAccount().withdraw(960);
		customer.getAccount().withdraw(2000);
		System.out.format("Customer[%s,%s] has a account: id is %d, annual interest rate is %.2f%% "
				+ "and the balance is %f.\n", customer.getLastName(),customer.getFirstName(),customer.getAccount().getId(),
				customer.getAccount().getAnnualInterestRate()*100,customer.getAccount().getBalance());
	}
}
