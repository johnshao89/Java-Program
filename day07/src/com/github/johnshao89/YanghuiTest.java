package com.github.johnshao89;

public class YanghuiTest {
	public static void main(String[] args) {
//		方法1：
//		int[][] yanghui = new int[10][];
//		for(int i=0;i<yanghui.length;i++) {
//			yanghui[i] = new int[i+1]; //杨辉三角第i行有i+1个元素
//		}
//		for(int i=0;i<yanghui.length;i++) {
//			for(int j=0;j<i+1;j++) {
//				if(i==0||i==1) {
//					yanghui[i][j]=1;
//				}else if(j==0||j==i) {
//					yanghui[i][j]=1;
//				}else {
//					yanghui[i][j]= yanghui[i-1][j-1]+yanghui[i-1][j]; 
//				}
//			}
//		}
//		for(int i=0;i<yanghui.length;i++) {
//			for(int j=0;j<yanghui[i].length;j++) {
//				System.out.print(yanghui[i][j]+" " );
//			}
//			System.out.println();
//		}
		
		//方法2：
		int[][] yanghui = new int[10][];
		for(int i=0;i<yanghui.length;i++) {
			yanghui[i]=new int[i+1]; 
			yanghui[i][0]=yanghui[i][i]=1;//给首元素和尾元素赋值
			if(i>1) { //从第三行开始
				for(int j=1;j<yanghui[i].length-1;j++) {
					yanghui[i][j]=yanghui[i-1][j-1]+yanghui[i-1][j];
				}
			}
		}
		
		for(int i=0;i<yanghui.length;i++) {
			for(int j=0;j<yanghui[i].length;j++) {
				System.out.print(yanghui[i][j]+"　");
			}
			System.out.println();
		}
		
		
	}
}
