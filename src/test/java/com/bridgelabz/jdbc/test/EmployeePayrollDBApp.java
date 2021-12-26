package com.bridgelabz.jdbc.test;

import java.sql.Connection;
import com.bridgelabz.jdbc.config.Config;
import com.bridgelabz.jdbc.customexception.PayrollServiceDBException;

public class EmployeePayrollDBApp {

	static final String URL = "jdbc:mysql://localhost:3306/payroll_service";
	static final String USER_NAME = "root";
	static final String PASSWORD = "mani5321";

	public static void main(String[] args) {

		Config config = Config.getConfig();

		/*
		 * just for checking driver 
		 * Driver driver = config.getDrivers();
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
	}

}
