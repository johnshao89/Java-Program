package com.github.johnshao892;

public class BoyAndGirlTest {
	public static void main(String[] args) {
		Boy boy = new Boy("Tom",22);
		Girl girl = new Girl("Mary",22);
		boy.marry(girl);
		girl.marry(boy);
	}
}
