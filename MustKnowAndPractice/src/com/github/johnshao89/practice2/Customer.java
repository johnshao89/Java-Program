package com.github.johnshao89.practice2;

public class Customer {
	private String firstName;
	private String lastName;
	private Account account;
	
	public Customer(String first, String last) {
		this.firstName = first;
		this.lastName = last;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public Account getAccount() {
		return this.account;
	}
	
	public void setAccount(Account acct) {
		this.account = acct;
	}
}
