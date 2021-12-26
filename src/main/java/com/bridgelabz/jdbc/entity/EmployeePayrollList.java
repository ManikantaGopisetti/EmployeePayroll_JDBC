package com.bridgelabz.jdbc.entity;

import java.util.ArrayList;

public class EmployeePayrollList {
	private static ArrayList<EmployeePayroll> employeePayrolls = new ArrayList<EmployeePayroll>();

	public static ArrayList<EmployeePayroll> getEmployeePayrolls() {
		return employeePayrolls;
	}
}
