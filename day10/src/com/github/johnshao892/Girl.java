package com.github.johnshao892;

public class Girl {
	private String name;
	private int age;
	
	public Girl() {
		
	}
	
	public Girl(String name) {
		this.name = name;
	}
	
	public Girl(String name, int age) {
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
	
	public void marry(Boy boy) {
		System.out.println("I want to marry "+ boy.getName());//this line from the girl
		System.out.println("I will mary "+ this.getName()+ " too!");//this line is reply from the boy
	}
	
	public int compare(Girl girl) {
		if(this.getAge()>girl.getAge()) {
			return 1;
		}else if(this.getAge()==girl.getAge()) {
			return 0;
		}else {
			return -1;
		}
	}
}
