package com.github.johnshao89.domain;

public class Status {
	private final String TYPE;
	
	private Status(String t) {
		TYPE = t;
	}
	
	public static final Status FREE = new Status("FREE");
	public static final Status BUSY = new Status("BUSY");
	public static final Status VACATION = new Status("VACATION");
	
	public String getName() {
		return TYPE;
	}
	
	public String toString() {
		return TYPE;
	}
}
