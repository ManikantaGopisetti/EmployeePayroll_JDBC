package com.bridgelabz.jdbc.test;

import java.sql.Connection;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import com.bridgelabz.jdbc.config.Config;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import com.bridgelabz.jdbc.customexception.ExceptionType;
import com.bridgelabz.jdbc.customexception.PayrollServiceDBException;
import com.mysql.cj.jdbc.Driver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PayrollServiceDBTest {

	static Config config;
	static Connection con;
	private static final String URL = "jdbc:mysql://localhost:3306/payroll_service";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "mani5321";

	@Before
	public void firstinstance() {
		config = Config.getConfig();

	}

	@Test
	public void checkDriverClass() {
		Driver driver = config.getDrivers();
		assertEquals("com.mysql.cj.jdbc.Driver", driver.getClass().getName());
	}

	@Test
	public void firstgivenWrongUrl_userName_paswwordShouldThrowPayrollServiceDBException() {
		String wrongUrl = "jdbc:mysql://localhost:3306/payroll_service";
		String wrongUSserName = "rot";
		String wrongPassword = "mani5321";
		try {
			con = config.getConnection(wrongUrl, wrongUSserName, wrongPassword);
		} catch (PayrollServiceDBException e) {
			assertEquals(ExceptionType.INCORRECT_URL_OR_USER_NAME_OR_PASSWORD, e.type);
		}
	}

	@Test
	public void givenCorrectUrl_userName_paswwordShouldGetConnection() {
		try {
			con = config.getConnection(URL, USER_NAME, PASSWORD);
			assertNotNull(con);
		} catch (PayrollServiceDBException e) {
		}
	}

}
