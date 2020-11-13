package com.github.johnshao89.service;

import com.github.johnshao89.domain.Architect;
import com.github.johnshao89.domain.Designer;
import com.github.johnshao89.domain.Employee;
import com.github.johnshao89.domain.Equipment;
import com.github.johnshao89.domain.NoteBook;
import com.github.johnshao89.domain.PC;
import com.github.johnshao89.domain.Printer;
import com.github.johnshao89.domain.Programmer;

public class NameListService {
	private Employee[] nameList = new Employee[Data.EMPLOYEES.length];
	
	public NameListService() {
		initiateNameList();
	}
	
	private void initiateNameList() {
		for(int i =0; i<Data.EMPLOYEES.length;i++) {
			int type = Integer.parseInt(Data.EMPLOYEES[i][0]);
			int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
			String name = Data.EMPLOYEES[i][2];
			int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
			double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);
			Equipment equipment=null;
			double bonus;
			int stock;
			switch(type) {
			case Data.EMPLOYEE:
				nameList[i] = new Employee(id, name, age, salary);
				break;
			case Data.PROGRAMMER:
				equipment = getEquipment(i);
				nameList[i] = new Programmer(id, name, age, salary, equipment);
				break;
			case Data.DESIGNER:
				equipment = getEquipment(i);
				bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
				nameList[i] = new Designer(id, name,age, salary, equipment, bonus);
				break;
			case Data.ARCHITECT:
				equipment = getEquipment(i);
				bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
				stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
				nameList[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
				break;
			}
		}
	}
	
	private Equipment getEquipment(int index) {
		Equipment equip = null;
		int type = Integer.parseInt(Data.EQUIPMENTS[index][0]);
		switch(type) {
		case Data.PC:
			equip = new PC(Data.EQUIPMENTS[index][1],Data.EQUIPMENTS[index][2]);
			break;
		case Data.NOTEBOOK:
			equip = new NoteBook(Data.EQUIPMENTS[index][1],Double.parseDouble(Data.EQUIPMENTS[index][2]));
			break;
		case Data.PRINTER:
			equip = new Printer(Data.EQUIPMENTS[index][1],Data.EQUIPMENTS[index][2]);
			break;
		}
		return equip;
	}
	
	public Employee[] getEmployeeList() {
		return nameList;
	}
	
	public Employee getEmployee(int index) throws TeamException {
		for(Employee e: nameList) {
			if(e.getId() == index) {
				return e;
			}
		}
		throw new TeamException("没有找到该员工");
	}
}
