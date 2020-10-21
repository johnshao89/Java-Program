package com.github.johnshao89.practice2;

public class Bank {
	private Customer[] customers;
	private int numberOfCustomer;
	
	public Bank() {
		customers = new Customer[100];
	}
	
	public void addCustomer(String last, String first) {
		Customer newCustomer = new Customer(first, last);
		customers[numberOfCustomer] = newCustomer;
		numberOfCustomer++;
	}
	
	public int getNumOfCustomers() {
		return this.numberOfCustomer;
	}
	
	public Customer getCustomer(int index) {
		return customers[index];
	}
}
