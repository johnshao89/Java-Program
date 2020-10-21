package com.github.johnshao892;

public class Boy {
	private String name;
	private int age;
	
	public Boy() {
		
	}
	
	public Boy(String name) {
		this.name = name;
	}
	
	public Boy(String name,int age) {
		this.name = name;
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void marry(Girl girl) {
		System.out.println("I will marry "+girl.getName());
	}
	
	public void shout() {
		if(this.age>22) {
			System.out.println("You can marry!");
		}else {
			System.out.println("Better wait until older!");
		}
	}
}
