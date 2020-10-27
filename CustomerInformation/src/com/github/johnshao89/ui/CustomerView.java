package com.github.johnshao89.ui;

import com.github.johnshao89.bean.Customer;
import com.github.johnshao89.service.CustomerList;
import com.github.johnshao89.utility.CMUtility;

public class CustomerView {
	private CustomerList custList;

	public CustomerView() {
		custList = new CustomerList(100);
	}

	public static void main(String[] args) {
		CustomerView custView = new CustomerView();
		custView.go();
	}

	public void go() {
		boolean isContinue = true;
		while (isContinue) {
			showMenu();
			char menuChoice = CMUtility.readMenuSelection();
			switch (menuChoice) {
			case '1':
				addCustomer();
				break;
			case '2':
				modifyCustomer();
				break;
			case '3':
				deleteCustomer();
				break;
			case '4':
				displayCustomerList();
				break;
			case '5':
				isContinue = false;
				break;
			}
		}
	}

	/**
	 * 
	 * @Description This function shows the main menu
	 * @author johnshao89
	 * @date Oct. 27, 20203:39:52 p.m.
	 * @param
	 * @return void
	 */
	private void showMenu() {
		System.out.println("\n-----------------客户信息管理软件-----------------\n");
		System.out.println("                     1 添 加 客 户\n");
		System.out.println("                     2 修 改 客 户\n");
		System.out.println("                     3 删 除 客 户\n");
		System.out.println("                     4 客 户 列 表\n");
		System.out.println("                     5 退      出\n");
		System.out.println("                     请选择（1-5）： \n");
	}

	/**
	 * 
	 * @Description This function add the customer to the customerlist
	 * @author johnshao89
	 * @date Oct. 27, 20203:40:11 p.m.
	 * @param
	 * @return void
	 */
	private void addCustomer() {
		System.out.println("\n---------------------添加客户---------------------\n");
		System.out.print("姓名： ");
		String name = CMUtility.readString();
		System.out.print("性别： ");
		char sex = CMUtility.readChar();
		System.out.print("年龄： ");
		int age = CMUtility.readInt();
		System.out.print("电话： ");
		String phone = CMUtility.readString();
		System.out.print("邮箱： ");
		String email = CMUtility.readString();
		boolean addition = custList.addCustomer(new Customer(name, sex, age, phone, email));
		if (addition) {
			System.out.println("\n---------------------添加完成---------------------\n");
		} else {
			System.out.println("\n---------------------添加失败---------------------\n");
		}
	}

	/**
	 * 
	 * @Description Modify the customer's information. If empty line is entered,
	 *              keep the information
	 * @author johnshao89
	 * @date Oct. 27, 20203:46:12 p.m.
	 * @param
	 * @return void
	 */
	private void modifyCustomer() {
		System.out.println("\n---------------------修改客户---------------------\n");
		System.out.print("请选择待修改客户编号（-1退出）： ");
		int index = CMUtility.readInt();
		if (index == -1) {
			System.out.println("\n---------------------退出修改---------------------\n");
			return;
		} else if (index <= 0 || index > custList.getTotal()) {
			System.out.print("\n---------------------客户编号不存在---------------------\n");
		} else {
			Customer customerToModify = custList.getSingleCustomer(index);
			String defaultName = customerToModify.getName();
			char defaultSex = customerToModify.getSex();
			int defaultAge = customerToModify.getAge();
			String defaultPhone = customerToModify.getPhone();
			String defaultEmail = customerToModify.getEmail();
			System.out.print("姓名： ");
			String name = CMUtility.readString(defaultName);
			System.out.print("性别： ");
			char sex = CMUtility.readChar(defaultSex);
			System.out.print("年龄： ");
			int age = CMUtility.readInt(defaultAge);
			System.out.print("电话： ");
			String phone = CMUtility.readString(defaultPhone);
			System.out.print("邮箱： ");
			String email = CMUtility.readString(defaultEmail);
			Customer modifiedCustomer = new Customer(name, sex, age, phone, email);
			custList.modifyCustomer(index - 1, modifiedCustomer);
			System.out.println("\n---------------------修改完成---------------------\n");
		}
	}

	public void deleteCustomer() {
		System.out.println("---------------------删除客户---------------------\n");
		System.out.print("请选择待删除客户编号(-1退出): ");
		int index = CMUtility.readInt();
		if (index == -1) {
			System.out.print("---------------------退出删除客户---------------------\n");
			return;
		} else {
			System.out.print("确认是否删除(Y/N): ");
			if (CMUtility.readConfirmation() == 'N') {
				return;
			} else {
				boolean delete = custList.deleteCustomer(index - 1);
				if (delete == false) {
					System.out.print("---------------------删除客户失败---------------------\n");
				} else {
					System.out.print("---------------------删除完成---------------------\n");
				}
			}
		}
	}
	
	public void displayCustomerList() {
		for(int i=1;i<=custList.getTotal();i++) {
			Customer cust = custList.getSingleCustomer(i);
			String name = cust.getName();
			char sex = cust.getSex();
			int age = cust.getAge();
			String phone = cust.getPhone();
			String email = cust.getEmail();
			System.out.println("---------------------------客户列表---------------------------\n");
			System.out.printf("编号\t姓名\t性别\t年龄\t电话\t\t邮箱\t\t\n");
			System.out.printf("%d\t%s\t%c\t%d\t%s\t\t%s\t\t\n", name,sex,age,phone,email);
			System.out.println("-------------------------客户列表完成-------------------------\n");
		}
	}
}
