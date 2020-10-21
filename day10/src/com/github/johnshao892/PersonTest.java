package com.github.johnshao892;

public class PersonTest {
	public static void main(String[]args) {
		Person p1 = new Person();
		p1.setAge(1);
		System.out.println(p1.getAge());
		p1.eat();
	}
}


class Person{
	private int age;
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void eat() {
		System.out.println("人吃饭");
		this.study();
	}
	
	public void study() {
		System.out.println("人学习");
	}
}