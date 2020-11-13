package com.github.johnshao89.service;

import org.junit.Test;

import com.github.johnshao89.domain.Employee;

public class NameListTest {
	@Test
	public void test() {
		NameListService service = new NameListService();
		Employee[] group = service.getEmployeeList();
		for(Employee e: group) {
			System.out.println(e.toString());
		}
	}
}
