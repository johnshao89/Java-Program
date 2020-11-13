package com.github.johnshao89.view;

import com.github.johnshao89.domain.Employee;
import com.github.johnshao89.domain.Programmer;
import com.github.johnshao89.service.NameListService;
import com.github.johnshao89.service.TSUtility;
import com.github.johnshao89.service.TeamException;
import com.github.johnshao89.service.TeamListService;

public class TeamView {

	private NameListService nameService;
	private TeamListService teamService;

	public static void main(String[] args) {
		TeamView view = new TeamView();
		view.go();
	}

	public void go() {
		nameService = new NameListService();
		teamService = new TeamListService();
		boolean isContinue = true;
		while (isContinue) {
			showMember();
			char choice = TSUtility.readMenuSelection();
			switch (choice) {
			case '1':
				showTeamList();
				showContinue();
				break;
			case '2':
				addTeamMember();
				//showContinue();
				break;
			case '3':
				deleteTeamMember();
				//showContinue();
				break;
			case '4':
				System.out.println("是否确认退出？Y/N");
				char isExit = TSUtility.readExitConfirmation();
				if(isExit =='Y') {
					isContinue = false;
				}
				break;
			}
		}
	}

	private void showMember() {
		System.out.println("-------------------------------------开发团队调度软件--------------------------------------\n");
		System.out.println("ID     姓名      年龄    工资         职位      状态      奖金        股票     领用设备");
		for (Employee e : nameService.getEmployeeList()) {
			System.out.println(e.toString());
		}
		System.out.println(
				"----------------------------------------------------------------------------------------------");
		System.out.println("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4):");
	}

	private void showTeamList() {
		System.out.println("--------------------团队成员列表---------------------\n");
		if (teamService.getTotal() == 0) {
			System.out.println("暂时没有开发人员");
		} else {
			System.out.println("TDI/ID  姓名    年龄      工资       职位      奖金        股票");
			for (Programmer p : teamService.getAllTeamMember()) {
				System.out.println(p.getTeamDetail());
			}
		}
		System.out.println("-----------------------------------------------------");
	}
	
	private void showContinue() {
		System.out.println("按回车键继续...");
		TSUtility.readContinue();
	}
	
	private void addTeamMember() {
		System.out.println("---------------------添加成员---------------------");
		System.out.print("请输入要添加的员工ID:");
		int id = TSUtility.readInt();
		try {
			Employee memberToAdd = nameService.getEmployee(id);
			teamService.addTeamMember(memberToAdd);
			System.out.println("添加成功");
		} catch (TeamException e) {
			System.out.println("添加失败，原因："+e.getMessage());
		}
		showContinue();
	}
	
	private void deleteTeamMember() {
		System.out.println("---------------------删除成员---------------------");
		System.out.println("请输入要删除员工的TID:");
		int id = TSUtility.readInt();
		System.out.println("确认是否删除(Y/N):");
		if(TSUtility.readExitConfirmation()=='Y') {
			try {
				teamService.deleteTeamMember(id);
				System.out.println("删除成功");
			}catch(TeamException e) {
				System.out.println("删除失败，原因："+e.getMessage());
			}
		}
		showContinue();
	}
}
