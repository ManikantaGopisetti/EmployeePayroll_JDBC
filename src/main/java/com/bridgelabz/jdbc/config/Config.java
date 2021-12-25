package com.bridgelabz.jdbc.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import com.bridgelabz.jdbc.customexception.ExceptionType;
import com.bridgelabz.jdbc.customexception.PayrollServiceDBException;
import com.mysql.cj.jdbc.Driver;

public class Config {

	private static Config config;
	private Driver driver;
	private Connection connection;

	private Config() {

	}

	public static Config getConfig() {
		if (config == null) {
			config = new Config();
			return config;
		}
		return config;
	}

	public Connection getConnection(String URL, String userName, String password) throws PayrollServiceDBException {
		if (connection == null) {
			try {
				String driverClass=getDrivers().getClass().getName();
				Class.forName(driverClass);
				connection = DriverManager.getConnection(URL, userName, password);
				return connection;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				throw new PayrollServiceDBException(e.getMessage(),
						ExceptionType.INCORRECT_URL_OR_USER_NAME_OR_PASSWORD);
			}
		}
		return connection;
	}

	public Driver getDrivers() {
		if (driver == null) {
			Enumeration<java.sql.Driver> driverList = DriverManager.getDrivers();
			while (driverList.hasMoreElements()) {
				driver = (Driver) driverList.nextElement();
				System.out.println(driver.getClass().getName() + "\n");
			}
			return driver;
		}
		return driver;
	}

}
