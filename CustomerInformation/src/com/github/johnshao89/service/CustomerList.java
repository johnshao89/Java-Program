package com.github.johnshao89.service;

import com.github.johnshao89.bean.Customer;

public class CustomerList {
	private Customer[] customers;
	private int totalCustomers;
	
	public CustomerList() {
		
	}
	
	public CustomerList(int capacity) {
		customers = new Customer[capacity];
	}
	
	/**
	 * 
	* @Description Add a new customer to the customerList. If the customerList is full, return false
	* @author johnshao89
	* @date Oct. 27, 202011:44:40 a.m.
	* @param 
	* @return boolean
	 */
	public boolean addCustomer(Customer cust) {
		boolean isSuccess = true;
		if(totalCustomers>=customers.length) {
			isSuccess = false;
		}else {
			customers[totalCustomers++] = cust;
		}
		return isSuccess;
	}
	
	/**
	 * 
	* @Description Delete the customer according to index. Moving later customer before
	* @author johnshao89
	* @date Oct. 27, 20201:54:54 p.m.
	* @param 
	* @return boolean
	 */
	public boolean deleteCustomer(int index) {
		boolean isSuccess = true;
		if(index<=0 || index >totalCustomers) {
			isSuccess = false;
		}else {
			isSuccess = true;
			for(int i = index-1;i<totalCustomers-1;i++) {
				customers[i]=customers[i+1];
			}
		}
		customers[totalCustomers-1]=null;
		totalCustomers--;
		return isSuccess;
	}
	
	public boolean modifyCustomer(int index, Customer newCustomer) {
		boolean isSuccess = false;
		if(index<=0 || index>totalCustomers) {
			//System.out.println("Could not find customer!");
			return isSuccess;
		}else {
			customers[index-1] = newCustomer;
			isSuccess = true;
		}
		return isSuccess;
	}
	
	
	public Customer[] getAllCustomers() {
		return customers;
	}
	
	public int getTotal() {
		return totalCustomers;
	}
	
	public Customer getSingleCustomer(int index) {
		return customers[index-1];
	}
	
	
	
}
