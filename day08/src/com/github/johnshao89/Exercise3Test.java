package com.github.johnshao89;

public class Exercise3Test {
	public static void main(String[] args) {
		Exercise3 exer = new Exercise3();
		exer.printMatrix();
	}
}

class Exercise3{
	int line=10;
	int columns=8;
	
	public void printMatrix() {
		for(int i=0;i<line;i++) {
			for(int j=0;j<columns;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	
	public int getArea() {
		return line*columns;
	}
}