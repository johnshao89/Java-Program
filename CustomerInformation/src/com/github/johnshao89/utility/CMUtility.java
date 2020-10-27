package com.github.johnshao89.utility;

import java.util.Scanner;

public class CMUtility {
	private static Scanner scanner = new Scanner(System.in);
	
	/**
	 * 
	* @Description Read 1-5 from the main menu
	* @author johnshao89
	* @date Oct. 27, 20209:23:26 a.m.
	* @param 
	* @return char
	 */
	public static char readMenuSelection() {
		char choice;
		while(true) {
			String line = readKeyBoard(1,false);
			choice = line.charAt(0);
			if(choice!='1' && choice !='2' && choice !='3' && choice!='4' && choice!='5') {
				System.out.print("Please make a selection between 1-5");
				continue;
			}else {
				break;
			}
		}
		return choice;
	}
	
	/**
	 * 
	* @Description Read the <Y/N> for exit confirmation
	* @author johnshao89
	* @date Oct. 27, 20209:26:16 a.m.
	* @param 
	* @return char
	 */
	public static char readConfirmation() {
		char choice;
		while(true) {
			String line = readKeyBoard(1,false);
			choice = line.toUpperCase().charAt(0);
			if(choice!='Y' && choice !='N') {
				System.out.print("Invalid input. Please enter <Y/N>: ");
				continue;
			}else {
				break;
			}
		}
		return choice;
	}
	
	/**
	 * 
	* @Description Read a single character for the sex
	* @author johnshao89
	* @date Oct. 27, 20209:28:45 a.m.
	* @param 
	* @return char
	 */
	public static char readChar() {
		return readKeyBoard(1,false).charAt(0);
	}
	
	/**
	 * 
	* @Description Read a single character for the sex modification. If empty char, return default value
	* @author johnshao89
	* @date Oct. 27, 20209:30:41 a.m.
	* @param 
	* @return char
	 */
	public static char readChar(char defaultSex) {
		String line = readKeyBoard(1,true);
		if(line.equals("")) {
			return defaultSex;
		}else {
			return line.charAt(0);
		}
	}
	
	/**
	 * 
	* @Description Read the age
	* @author johnshao89
	* @date Oct. 27, 20209:37:21 a.m.
	* @param 
	* @return int
	 */
	public static int readInt() {
		int retVal;
		String line;
		while(true) {
			line = readKeyBoard(2,false);
			try {
				retVal = Integer.parseInt(line);
				break;
			}catch(Exception e) {
				System.out.print("Invalid input. Please only enter numbers: ");
				continue;
			}
		}
		return retVal;
	}
	
	/**
	 * 
	* @Description Read age change for the client. If input is empty, return default age
	* @author johnshao89
	* @date Oct. 27, 20209:43:36 a.m.
	* @param 
	* @return int
	 */
	public static int readInt(int defaultAge) {
		int retVal;
		String line;
		while(true) {
			line = readKeyBoard(2,true);
			if(line.equals("")){
				return defaultAge;
			}else {
				try {
					retVal = Integer.parseInt(line);
					break;
				}catch(Exception e) {
					System.out.print("Invalid input. Please only enter number: ");
					continue;
				}
			}
		}
		return retVal;
	}
	
	/**
	 * 
	* @Description Read input for name, email, phone
	* @author johnshao89
	* @date Oct. 27, 20209:45:17 a.m.
	* @param 
	* @return String
	 */
	public static String readString() {
		return readKeyBoard(100,false);
	}
	/**
	 * 
	* @Description Read input for modification of name, email, phone. If input is empty, return default string
	* @author johnshao89
	* @date Oct. 27, 20209:47:05 a.m.
	* @param 
	* @return String
	 */
	public static String readString(String defaultString) {
		String line;
		line = readKeyBoard(100,true);
		if(line.equals("")) {
			return defaultString;
		}else {
			return line;
		}
	}
	
	/**
	 * 
	* @Description Basic static method that reads input from the keyboard based on char limits
	* and if blank input can be accepted
	* @author johnshao89
	* @date Oct. 27, 20209:11:36 a.m.
	* @param limit:int, how many characters can be accepted. blankReturn: boolean, if empty string can be accpeted
	* @return String
	 */
	private static String readKeyBoard(int limit, boolean blankReturn) {
		String line ="";
		while(scanner.hasNextLine()) {
			line = scanner.nextLine();
			if(line.length()>limit) {
				System.out.print("The input is over the limit. Please re-enter:");
				continue;
			}
			if(line.equals("")) {
				if(blankReturn ==true) {
					return line;
				}else {
					System.out.print("Input can not be empty!");
					continue;
				}
			}else {
				break;
			}
		}
		return line;
	}
}
