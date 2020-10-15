package com.github.johnshao89;
import java.util.Scanner;

public class CustomScan {
	private static Scanner scanner = new Scanner(System.in);
	
	public static char getSelectedMenu() {
		char retVal;
		while(true) {
			String choiceString = scanner.nextLine();
			retVal = choiceString.charAt(0);
			if(retVal>='1'&&retVal<='4') {
				return retVal;
			}else {
				System.out.print("输入错误，请选择（1-4）：");
			}
		}
	}
	
	public static int getKeyboardNumber() {
		int retVal;
		while(true) {
			String temp = scanner.nextLine(); //如果直接使用scanner.nextInt(),会导致错误，因为上一次输入
			try {
				retVal = Integer.parseInt(temp);
				if(retVal<0) {
					System.out.print("输入错误，请输入正数：");
				}else {
					return retVal;
				}
			}catch(NumberFormatException e) {
				System.out.print("非法输入，请输入正数：");
			}			
		}
	}
	
	public static String getKeyboardString() {
		String retvalString;
		retvalString = scanner.nextLine();
		return retvalString;
	}
	
	public static char getQuitConfirm() {
		char retVal;
		System.out.print("确认是否退出（Y/N):");
		while(true) {
			String tempString = scanner.nextLine().toLowerCase();
			retVal = tempString.charAt(0);
			if(retVal=='n'||retVal=='y') {
				return retVal;
			}else {
				System.out.print("\n输入错误，请选择<Y/N>:");
			}			
		}
	}
}
