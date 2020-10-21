package com.github.johnshao89;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = new int[] {34,5,22,-98,6,-76,0,-3};
		for(int i=0;i<arr.length-1;i++) { 
			for(int j=0;j<arr.length-1-i;j++) {
				if(arr[j]<arr[j+1]) {
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
/*
 * 思路：每次比较相邻的两个元素，如果前一个元素比后一个元素大，则交换两个元素位置，从index0 到index
 * len-2为止完成第一大轮,确定index（len-1)的元素 从第i大轮开始，确定index（len-i）的元素值
 */

