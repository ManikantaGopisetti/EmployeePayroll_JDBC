package com.bridgelabz.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Enumeration;
import com.bridgelabz.jdbc.config.Config;
import com.bridgelabz.jdbc.customexception.PayrollServiceDBException;
import com.mysql.cj.jdbc.Driver;

public class EmployeePayrollDBApp {

	static final String URL = "jdbc:mysql://localhost:3306/payroll_service";
	static final String USER_NAME = "root";
	static final String PASSWORD = "mani5321";

	public static void main(String[] args) {

		Config config = Config.getConfig();

		Driver driver = config.getDrivers();

		Connection con;

		try {
			con = config.getConnection(URL, USER_NAME, PASSWORD);
			if (con != null) {
				System.out.println("\nConnection is successfull!!!!!!!");
			}
		} catch (PayrollServiceDBException e) {
			System.out.println("\nConnection failed!!!!!!!\n");
			e.printStackTrace();
		}

	}

}
