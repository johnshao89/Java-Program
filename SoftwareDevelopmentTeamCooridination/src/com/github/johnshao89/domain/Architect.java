package com.github.johnshao89.domain;

public class Architect extends Designer {
	private int stock;
	public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus,int stock) {
		super(id, name, age, salary, equipment, bonus);
		this.stock = stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public int getStock() {
		return stock;
	}
	
	@Override
	public String toString() {
		return getDetail()+"\t架构师\t"+getStatus().getName()+"\t"+getBonus()+"\t"+getStock()+"\t"+getEquipment().getDescription();
	}
	
	@Override
	public String getTeamDetail() {
		return getMemberId()+"\\"+getId()+"\t" + getName() + "\t" + getAge() +"\t" +getSalary()+"\t架构师\t"+getBonus()+"\t"+getStock();
	}

}
