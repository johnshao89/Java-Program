package com.github.johnshao89;

import java.util.Arrays;

public class NoDuplicateAssign {
	public static void main(String[] args) {
		boolean isDuplicate = false;
		int[] arr = new int[6];
		int random;
		for(int i=0;i<arr.length;i++) {
			while(true) {
				random = (int)(Math.random()*(30-0+1));
				for(int j=0;j<i;j++) {
					if(arr[j]==random) {
						isDuplicate = true;
						break;
					}
				}
				if(isDuplicate == false) {
					arr[i]=random;
					break;
				}
			}
		}	
		System.out.println(Arrays.toString(arr));
	}
		
}


/*
 * 定义一个长度为6的int数组，从0-30中给这个数组赋值，要求数组的每个元素不重复
 * 思路：在给新的元素赋值之前，遍历index【0】到index【i-1】，如果发现有元素和产生的随机数相同，则重新产生随机数
 * 
 */
