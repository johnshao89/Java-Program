package com.github.johnshao89;

public class CircleTest {
	public static void main(String[] args) {
		Circle circle = new Circle();
		circle.diameter = 2;
		circle.calculateArea();
		System.out.println(circle.getArea());
	}
}


class Circle{
	private double area;
	public double diameter;
	
	public void calculateArea() {
		area = 3.14*diameter*diameter;
	}
	
	public double getArea() {
		return area;
	}
}