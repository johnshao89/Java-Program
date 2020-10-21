package com.github.johnshao89;

public class PersonTest {
	public static void main(String[] args) {
		Person person = new Person();
		person.setAge(50);
		person.getAge();
		Person p1 = new Person("Tom",21);
		System.out.println(p1.getName());
		
	}
}

class Person{
	private int age;
	private String name;
	
	public Person() {
		age = 18;
	}
	
	public Person(String n, int a) {
		name =n;
		age = a;
	}
	
	public void setAge(int a) {
		if(a>=0) {
			age =a;
		}else {
			System.out.println("Invalid input");
		}
	}
	
	public int getAge() {
		System.out.println(age);
		return age;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public String getName() {
		return name;
	}
}
