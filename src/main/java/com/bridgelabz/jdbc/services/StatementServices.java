package com.bridgelabz.jdbc.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.bridgelabz.jdbc.entity.EmployeePayroll;
import com.bridgelabz.jdbc.entity.EmployeePayrollList;

public class StatementServices {

	private static StatementServices statementServices;
	private static final String FETCH = "SELECT id,name,gender,phoneNumber,address,departmentName,basicPay,deductions,taxablepay,incomeTax,netPay,startDate FROM employee_payroll "
			+ "LEFT JOIN payroll_details ON employee_payroll.id = payroll_details.employee_id "
			+ "LEFT outer JOIN employee_department ON employee_payroll.id=employee_department.emp_id "
			+ "LEFT outer JOIN department ON employee_department.dept_id=department.department_id";
	static ArrayList<EmployeePayroll> payrollList;
	static EmployeePayroll payroll;
	Statement statement;

	private StatementServices() {
	}

	public static StatementServices getStatementInstance() {
		if (statementServices == null)
			statementServices = new StatementServices();
		return statementServices;
	}

	public ArrayList<EmployeePayroll> readPayrollData(Connection con) {

		payrollList = EmployeePayrollList.getEmployeePayrolls();
		try {
			statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(FETCH);
			while (resultSet.next()) {
				payroll = new EmployeePayroll(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getInt(4), resultSet.getString(5), resultSet.getString(6), resultSet.getDouble(7),
						resultSet.getDouble(8), resultSet.getDouble(9), resultSet.getDouble(10),
						resultSet.getDouble(11), resultSet.getDate(12));

				payrollList.add(payroll);
			}
			return payrollList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public ArrayList<EmployeePayroll> updateSalary(Connection con, String name, double salary) {

		String query = "UPDATE employee_payroll ep LEFT JOIN payroll_details pd ON ep.id = pd.employee_id set basicPay="
						+ salary + " WHERE name='" + name + "'";
		payrollList = EmployeePayrollList.getEmployeePayrolls();
		try {
			Statement statement = con.createStatement();
			statement.executeUpdate(query);
			for (EmployeePayroll employeePayroll : payrollList) {
				if (employeePayroll.getName().equals(name)) {
					employeePayroll.setBasicPay(salary);
				}
			}
			return payrollList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public double checkUpdate(Connection con, String name) {

		payrollList = EmployeePayrollList.getEmployeePayrolls();
		String query = String.format("SELECT basicPay FROM employee_payroll ep LEFT JOIN payroll_details pd ON ep.id=pd.employee_id WHERE name='%s';",name);
		double updatedsal = 0;
		try {
			statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				updatedsal = resultSet.getDouble(1);
				for (EmployeePayroll employeePayroll : payrollList) {
					if (employeePayroll.getName().equals(name)) {
						return updatedsal;
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updatedsal;
	}

}
