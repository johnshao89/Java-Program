package com.github.johnshao89;

public class Person {
	String name;
	int age;
	/**
	 * sex:1 male
	 * sex:0 female
	 */
	int sex;
	
	
	public void study() {
		System.out.println("studying");
	}
	
	public void showAge() {
		System.out.println(age);
	}
	
	public int addAge(int i) {
		age+=i;
		return age;
	}
}
