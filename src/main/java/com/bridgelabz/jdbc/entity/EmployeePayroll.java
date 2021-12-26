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

	public String getName() {
		return name;
	}

	public double getBasicPay() {
		return basicPay;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBasicPay(double basicPay) {
		this.basicPay = basicPay;
	}

	@Override
	public String toString() {
		return "EmployeePayroll [id=" + id + ", name=" + name + ", gender=" + gender + ", phoneNumber=" + phoneNumber
				+ ", address=" + address + ", department=" + department + ", basicPay=" + basicPay + ", deductions="
				+ deductions + ", taxablePay=" + taxablePay + ", incomeTax=" + incomeTax + ", netPay=" + netPay
				+ ", date=" + date + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeePayroll other = (EmployeePayroll) obj;
		
		return Integer.compare(id, other.id)==0&&name.equals(other.name)&&gender.equals(other.gender)&&
				Integer.compare(phoneNumber, other.phoneNumber)==0&&address.equals(other.address)&&
				department.equals(other.department)&&Double.compare(basicPay, other.basicPay)==0&&
				Double.compare(deductions, other.deductions)==0&&Double.compare(taxablePay, other.taxablePay)==0&&
				Double.compare(incomeTax, other.incomeTax)==0&&Double.compare(netPay, other.netPay)==0&&
				String.valueOf(date).equals(String.valueOf(other.date));
	}

}
