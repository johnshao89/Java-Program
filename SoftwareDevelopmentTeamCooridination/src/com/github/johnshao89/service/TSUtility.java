package com.github.johnshao89.service;

import java.util.Scanner;

public class TSUtility {
	private static Scanner scanner = new Scanner(System.in);
	
	public static char readMenuSelection() {
		char choice;
		while(true) {
			String line = readKeyBoard(1,false);
			choice = line.charAt(0);
			if(choice!='1' && choice!='2' && choice!='3' && choice!='4') {
				System.out.println("非法输入，请输入1-4：");
			}else {
				break;
			}
		}
		return choice;
	}
	
	public static char readExitConfirmation() {
		char choice;
		while(true) {
			String line = readKeyBoard(1,false);
			choice = line.toUpperCase().charAt(0);
			if(choice!='N' && choice!='Y') {
				System.out.println("非法输入，请选择<Y/N>");
			}else {
				break;
			}
		}
		return choice;
	}
	
	public static int readInt() {
		int choice;
		while(true) {
			String line = readKeyBoard(3,false);
			try {
				choice = Integer.parseInt(line);
				return choice;
			}catch(NumberFormatException e) {
				System.out.println("非法输入，请输入整数：");
			}
		}
	}
	
	public static String readContinue() {
		return readKeyBoard(100,true);
	}
	
	private static String readKeyBoard(int limit, boolean returnBlank) {
		String line = null;
		while(scanner.hasNextLine()) {
			line = scanner.nextLine();
			if(line.length()>limit) {
				System.out.println("超过允许字符的最大长度,请重新输入：");
			}
			if(returnBlank) {
				return line;
			}else {
				if(line.length()==0) {
					System.out.println("输入不能为空，请重新输入：");
				}else {
					break;
				}
			}
		}
		return line;
	}
}
