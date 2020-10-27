package com.github.johnshao89;

import java.util.Scanner;
public class PrimeNumber {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the range of the prime number: ");
		int range = scanner.nextInt();
		boolean isPrime=true;; 
		for(int i=2;i<=range;i++) {
			for(int j =2;j<=Math.sqrt(i);j++ ) {
				if(i % j== 0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime==true) {
				System.out.print(i+" ");
			}
			isPrime = true;
		}
	}
}

/*
 * 思路：首先创建isPrime flag,假设元素是质数 遍历所有的元素，如果遇到能被整除，则假设不成立，isPrime flag变成false
 * 判断flag的值，如果为真，则打印，否则跳过打印 重置flag的值，默认下一个元素是prime
 */


	
