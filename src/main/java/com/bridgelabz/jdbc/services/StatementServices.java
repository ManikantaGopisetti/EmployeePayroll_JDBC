package com.bridgelabz.jdbc.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.bridgelabz.jdbc.entity.EmployeePayroll;
import com.bridgelabz.jdbc.entity.EmployeePayrollList;

public class StatementServices {

	private static final String FETCH = "SELECT id,name,gender,phoneNumber,address,departmentName,basicPay,deductions,taxablepay,incomeTax,netPay,startDate FROM employee_payroll "
			+ "LEFT JOIN payroll_details ON employee_payroll.id = payroll_details.employee_id "
			+ "LEFT outer JOIN employee_department ON employee_payroll.id=employee_department.emp_id "
			+ "LEFT outer JOIN department ON employee_department.dept_id=department.department_id";

	static ArrayList<EmployeePayroll> payrollList;
	static EmployeePayroll payroll;

	public ArrayList<EmployeePayroll> readPayrollData(Connection con) {
		
		payrollList = EmployeePayrollList.getEmployeePayrolls();
		try {
			Statement statement = con.createStatement();
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

}
