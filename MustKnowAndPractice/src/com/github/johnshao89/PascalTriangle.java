package com.github.johnshao89;

public class PascalTriangle {
	public static void main(String[] args) {
		Triangle tra = new Triangle(10);
		tra.print();
	}
}

class Triangle{
	private int line;
	private int[][] arr;
	
	public Triangle(int line) {
		this.line = line;
		this.arr = new int[this.line][];
	}
	
	public void setLine(int line) {
		this.line = line;
	}
	
	public void print() {
		for(int i=0;i<line;i++) {
			arr[i] = new int[i+1];
			arr[i][0] = arr[i][i]=1;
			if(i>1) {
				for(int j=1;j<arr[i].length-1;j++) {
					arr[i][j] = arr[i-1][j-1]+arr[i-1][j];
				}
			}
		}
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
