package com.github.johnshao89;

public class OverLoadTest {
	public static void main(String[] args) {
		OverLoad overLoad = new OverLoad();
		overLoad.mOL("hello");
		overLoad.mOL(1);
		overLoad.mOL(1,2);
	}
}

class OverLoad{
	public void mOL(int num) {
		System.out.println(num);
	}
	
	public void mOL(int num1, int num2) {
		System.out.println(num1*num1+num2*num2);
	}
	
	public void mOL(String toString) {
		System.out.println(toString);
	}
}