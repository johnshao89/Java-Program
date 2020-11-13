package com.github.johnshao89.domain;

public class PC implements Equipment{
	private String brand;
	private String monitor;
	
	public PC(String brand,String monitor) {
		this.brand = brand;
		this.monitor = monitor;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}
	
	public String getMonitor() {
		return monitor;
	}
	
	@Override
	public String getDescription() {
		return brand+"(" + monitor +")";
	}
}
