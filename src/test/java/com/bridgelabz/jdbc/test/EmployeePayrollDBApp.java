package com.bridgelabz.jdbc.test;

import java.sql.Connection;
import java.util.ArrayList;
import com.bridgelabz.jdbc.config.Config;
import com.bridgelabz.jdbc.customexception.PayrollServiceDBException;
import com.bridgelabz.jdbc.entity.EmployeePayroll;
import com.bridgelabz.jdbc.entity.EmployeePayrollList;
import com.bridgelabz.jdbc.services.StatementServices;
import com.bridgelabz.jdbc.utility.updateDBServices;

public class EmployeePayrollDBApp {

	static final String URL = "jdbc:mysql://localhost:3306/payroll_service";
	static final String USER_NAME = "root";
	static final String PASSWORD = "mani5321";

	public static void main(String[] args) {

		Config config = Config.getConfig();
		updateDBServices input = new updateDBServices();
		EmployeePayroll Payroll;
		ArrayList<EmployeePayroll> payrollList = EmployeePayrollList.getEmployeePayrolls();

		/*
		 * just for checking driver Driver driver = config.getDrivers();
		 * System.out.println(driver);
		 */

		Connection con = null;

		try {
			con = config.getConnection(URL, USER_NAME, PASSWORD);
			if (con != null) {
				System.out.println("\nConnection is successfull!!!!!!!\n");
			}
		} catch (PayrollServiceDBException e) {
			System.out.println("\nConnection failed!!!!!!!\n");
			e.printStackTrace();
		}

		ArrayList<EmployeePayroll> employeePayrolls;
		StatementServices services = StatementServices.getStatementInstance();
		employeePayrolls = services.readPayrollData(con);

		for (EmployeePayroll employeePayroll : employeePayrolls) {
			System.out.println(employeePayroll);
		}
		
		System.out.println("\n");
		employeePayrolls = input.update(con);	
		System.out.println("\n");
		System.out.println(services.checkUpdate(con, "Terrisa"));
		
	}

}
