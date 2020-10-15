package com.github.johnshao89;

public class FamilyAccount {
	boolean isFlag = true;
	String detail = "";
	int balance=1000;
	public static void main(String[] args) {
		FamilyAccount account = new FamilyAccount();
		account.go();
	}
	
	private void go() {
		while(isFlag) {
			showMenu();
			char choice = CustomScan.getSelectedMenu();
			switch (choice) {
			case '1':
				//function1
				showDetail();
				break;
			case '2':
				//function2
				recordIncome();
				break;
			case '3':
				//function3
				recordExpense();
				break;
			case '4':
				char quitChoice = CustomScan.getQuitConfirm();
				isFlag = quitChoice=='y'? true:false;
				break;
			}
		}
		System.out.println("程序结束");
	}
	
	//show menu
	private void showMenu() {
		System.out.println("\n-----------------家庭收支记账软件-----------------\n");
		System.out.println("                   1 收支明细                      ");
		System.out.println("                   2 登记收入                      ");
		System.out.println("                   3 登记支出                      ");
		System.out.println("                   4 退  出                      \n");
		System.out.print("                   请选择(1-4):");				
	}
	
	//function1 when select '1'
	private void showDetail() {
		System.out.println("\n-----------------当前收支明细记录-----------------\n");
		System.out.println("收支			账户金额			收支金额			说明");
		System.out.println(detail);
		System.out.println();
	}
	
	//function2 when select '2'
	private void recordIncome() {
		System.out.print("本次收入金额：");
		int income = CustomScan.getKeyboardNumber();
		System.out.print("\n本次收入说明：");
		String sourceString = CustomScan.getKeyboardString();
		detail +=String.format("收入			%d			%d			%s\n", balance,income+balance,sourceString);
	}
	
	private void recordExpense() {
		System.out.print("本次支出金额:");
		int expense = CustomScan.getKeyboardNumber();
		System.out.println("\n本次支出说明：");
		String sourceString = CustomScan.getKeyboardString();
		detail +=String.format("支出		%d		%d		%s\n", balance,balance-expense,sourceString);
	}
}
