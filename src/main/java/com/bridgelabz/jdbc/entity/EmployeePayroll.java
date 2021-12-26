package com.bridgelabz.jdbc.entity;

import java.sql.Date;

public class EmployeePayroll {

	private int id;
	private String name;
	private String gender;
	private int phoneNumber;
	private String address;
	private String department;
	private double basicPay;
	private double deductions;
	private double taxablePay;
	private double incomeTax;
	private double netPay;
	private Date date;

	public EmployeePayroll(int id, String name, String gender, int phoneNumber, String address, String department,
			double basicPay, double deductions, double taxablePay, double incomeTax, double netPay, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.department = department;
		this.basicPay = basicPay;
		this.deductions = deductions;
		this.taxablePay = taxablePay;
		this.incomeTax = incomeTax;
		this.netPay = netPay;
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "EmployeePayroll [id=" + id + ", name=" + name + ", gender=" + gender + ", phoneNumber=" + phoneNumber
				+ ", address=" + address + ", department=" + department + ", basicPay=" + basicPay + ", deductions="
				+ deductions + ", taxablePay=" + taxablePay + ", incomeTax=" + incomeTax + ", netPay=" + netPay
				+ ", date=" + date + "]";
	}

}
