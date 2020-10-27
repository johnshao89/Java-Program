package com.github.johnshao89.bean;

public class Customer {
	private String name;
	private char sex;
	private int age;
	private String phone;
	private String email;
	
	public Customer() {
		
	}
	
	public Customer(String name, char sex, int age, String phone, String email) {
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.phone = phone;
		this.email = email;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setSex(char sex) {
		this.sex = sex;
	}
	
	public char getSex() {
		return this.sex;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public void setEmail(String Email) {
		this.email = Email;
	}
	
	public String getEmail() {
		return this.email;
	}
}
