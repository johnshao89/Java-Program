package com.github.johnshao89;

public class IntegerToHex {
	public static void main(String[] args) {
		int num=60;
		int factor = 15;//Ox1111;
		int i1 = num&factor;
		char c1 = (i1>9)?(char)(i1-10+'A'):(char)(i1+'0');
		int i2 = (num>>>4)&factor;
		char c2 = (i2>9)?(char)(i2-10+'A'):(char)(i2+'0');
		System.out.println(c2+""+c1);
	}
	
}
