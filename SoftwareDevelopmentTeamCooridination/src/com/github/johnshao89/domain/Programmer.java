package com.github.johnshao89.domain;

public class Programmer extends Employee {
	private int memberId;
	private Status status = Status.FREE;
	private Equipment equipment;
	
	public Programmer(int id, String name, int age, double salary, Equipment equipment) {
		super(id,name,age,salary);
		this.equipment = equipment;
	}
	
	public int getMemberId() {
		return memberId;
	}
	
	public void setMemberId(int id) {
		memberId = id;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status; 
	}
	
	public Equipment getEquipment() {
		return equipment;
	}
	
	public void setEquipment(Equipment e) {
		equipment = e;
	}
	
	@Override
	public String toString() {
		return getDetail()+"\t程序员\t"+status.getName()+"\t\t\t"+equipment.getDescription();
	}
	
	public String getTeamDetail() {
		return getMemberId()+"\\"+getId()+"\t" + getName() + "\t" + getAge() +"\t" +getSalary()+"\t程序员";
	}
}
