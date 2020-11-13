package com.github.johnshao89.domain;

public class Designer extends Programmer {
	private double bonus;
	
	public Designer(int id, String name, int age, double salary, Equipment equipment,double bonus) {
		super(id,name,age,salary,equipment);
		this.bonus = bonus;
	}
	
	public void setBonus(double amt) {
		bonus = amt;
	}
	
	public double getBonus() {
		return bonus;
	}
	
	@Override
	public String toString() {
		return getDetail()+"\t设计师\t"+getStatus().getName()+"\t"+bonus+"\t\t"+getEquipment().getDescription();
	}
	
	@Override
	public String getTeamDetail() {
		return getMemberId()+"\\"+getId()+"\t" + getName() + "\t" + getAge() +"\t" +getSalary()+"\t设计师\t"+getBonus();
	}
}
