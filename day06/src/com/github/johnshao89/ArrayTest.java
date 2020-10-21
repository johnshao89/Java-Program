package com.github.johnshao89;
import java.util.Scanner;


public class ArrayTest {
	public static void main(String[] args) {
		int[] studentScores = new int[5];
		Scanner scanner = new Scanner(System.in);
		int max =0;
		for(int i=0;i<studentScores.length;i++) {
			studentScores[i]= scanner.nextInt(); 
			if(studentScores[i]>max) {
				max = studentScores[i];
			}
		}
		System.out.println("The highest score is "+max);
		for(int i=0;i<studentScores.length;i++) {
			char grade;
			if(studentScores[i]>=max-30) {
				grade ='A';
			}else if(studentScores[i]>=max-20) {
				grade = 'B';
			}
			else if(studentScores[i]>max-10) {
				grade = 'C';
			}else {
				grade = 'D';
			}
			System.out.println(String.format("Student %d score is %d grade is %c", i,studentScores[i],grade));
		}
				
	}
}
