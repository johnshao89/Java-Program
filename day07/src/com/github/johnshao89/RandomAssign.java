package com.github.johnshao89;

public class RandomAssign {
	public static void main(String[] args) {
		int [] arr = new int[10];
		boolean isDuplicate = false;
		for(int i=0;i<arr.length;i++) {
			int random;
			while(true) {
				random = (int)((Math.random()*30)+1);
				for(int j=0;j<i;j++) {
					if(arr[j]==random) {
						isDuplicate=true;
						break;
					}
				}
				if(isDuplicate==false) {
					break;
				}
			}
			arr[i]=random;
		}
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
}
