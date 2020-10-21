package com.github.johnshao89;

import java.util.Arrays;

public class ArrayTest1 {
	public static void main(String[] args) {
		int[] arr1 = new int[] {1,2,3,4};
		int[] arr2 = new int[] {1,3,3,4};
		boolean isEqual = Arrays.equals(arr1, arr2);
		System.out.println(isEqual);
		Arrays.fill(arr1, 10);
		System.out.println(Arrays.toString(arr1));
		
	}
}
