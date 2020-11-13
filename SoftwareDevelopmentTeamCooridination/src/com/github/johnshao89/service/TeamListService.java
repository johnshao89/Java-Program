package com.github.johnshao89.service;

import com.github.johnshao89.domain.Architect;
import com.github.johnshao89.domain.Designer;
import com.github.johnshao89.domain.Employee;
import com.github.johnshao89.domain.Programmer;
import com.github.johnshao89.domain.Status;

public class TeamListService {
	private static final int MAX_CAPACITY = 5;
	private static int tId =1;
	private Programmer[] teamList = new Programmer[MAX_CAPACITY];
	private int total = 0;
	
	public void addTeamMember(Employee member) throws TeamException{
		int numberOfProgrammer=0;
		int numberOfDesigner=0;
		int numberOfArchitect=0;
		for(Programmer p: teamList) {
			if(p instanceof Architect) {
				numberOfArchitect++;
			}else if(p instanceof Designer) {
				numberOfDesigner++;
			}else if(p instanceof Programmer) {
				numberOfProgrammer++;
			}
		}
		
		if(!(member instanceof Programmer)) {
			throw new TeamException("该员工不是开发人员");
		}
		
		Programmer newMember = (Programmer)member;
		
		if("VACATION".equals(newMember.getStatus().getName())) {
			throw new TeamException("该员工正在休假");
		}
		
		for(Programmer p: teamList) {
			if(p.getId() == newMember.getId()) {
				throw new TeamException("该员工已经在开发团队中");
			}
		}
		
		if("BUSY".equals(newMember.getStatus().getName())) {
			throw new TeamException("该员工已经加入其他团队");
		}
		
		if(newMember instanceof Architect) {
			if(numberOfArchitect>=1) {
				throw new TeamException("最多一名架构师");
			}else {
				teamList[total++] = newMember;
			}
		}else if(newMember instanceof Designer) {
			if(numberOfDesigner >=2) {
				throw new TeamException("最多两名设计师");
			}else {
				teamList[total++] = newMember;
			}
		}else if(newMember instanceof Programmer) {
			if(numberOfProgrammer >=3) {
				throw new TeamException("最多三名程序员");
			}else {
				teamList[total++] = newMember;
			}
		}
		
		newMember.setMemberId(tId++);
		newMember.setStatus(Status.BUSY);
	}
	
	/**
	 * 
	* @Description Delete the team member according to member Id
	* @author johnshao89
	* @date 12 Nov 202013:09:25
	* @param 
	* @return void
	 */
	public void deleteTeamMember(int index) throws TeamException{
		int n;
		for(n=0;n<total;n++) {
			if(teamList[n].getMemberId() == index) {
				break;
			}
		}
		if(n>=total) {
			throw new TeamException("无法找到该员工");
		}
		for(int i=n;i<total-1;i++) {
			teamList[i] = teamList[i+1];
		}
		teamList[--total]=null;
	}
	
	public Programmer[] getAllTeamMember() {
		Programmer[] returnTeamMember = new Programmer[total];
		for(int i =0;i<total;i++) {
			returnTeamMember[i] = teamList[i];
		}
		return returnTeamMember;
	}
	
	public int getTotal() {
		return total;
	}
	
}
