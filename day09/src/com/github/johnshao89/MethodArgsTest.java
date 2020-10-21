package com.github.johnshao89;

public class MethodArgsTest {
	public static void main(String[] args) {
		MethodArgsTest test = new MethodArgsTest();
		test.show("hello");
		test.show("hello","good morning");
	}
	
	public void show(int i) {
		
	}
	
	public void show(String s) {
		System.out.println("show string");
	}
	
	public void show(String...strings) {
		System.out.println("show (String ...strs");
	}
}

