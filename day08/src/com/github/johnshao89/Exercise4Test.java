package com.github.johnshao89;

public class Exercise4Test {
	public static void main(String[] args) {
		Student[] students = new Student[20];
		for(int i=0;i<students.length;i++) {
			students[i] = new Student();
			students[i].number =i+1;
			students[i].state = (int)(Math.random()*13);
			students[i].score = (int)(Math.random()*101);
			if(students[i].state ==3) {
				System.out.println(String.format("Student %d grade 3 score %d", students[i].number,students[i].score));
			}
		}
		
		for(int i=0;i<students.length-1;i++) {
			for(int j =0;j<students.length-1-i;j++) {
				if(students[j].score>students[j+1].score) {
					int temp = students[j].score;
					students[j].score = students[j+1].score;
					students[j+1].score = temp;
				}
			}
		}
		
		for(int i=0;i<students.length-1;i++) {
			System.out.println(students[i].score);
		}
	}
}


class Student{
	/**
	 * number is ranging from 1 to 20
	 */
	int number;
	
	/**
	 * grade is ranging from 1 to 12
	 */
	int state;
	
	/**
	 * score is ranging from 0 to 100
	 */
	int score;
}