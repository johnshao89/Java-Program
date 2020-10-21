package com.github.johnshao89;

public class AnimalTest {
	public static void main(String[] args) {
		Animal animal = new Animal();
		
	}
}

class Animal{
	String name;
	int age;
	private int legs;
	
	public void setLegs(int l) {
		if(l>=0) {
			legs = l;
		}
	}
	
	public int getAge() {
		return age;
	}
	
}
