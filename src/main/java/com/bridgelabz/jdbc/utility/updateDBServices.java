package com.bridgelabz.jdbc.utility;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;
import com.bridgelabz.jdbc.entity.EmployeePayroll;
import com.bridgelabz.jdbc.services.StatementServices;

public class updateDBServices {

	public ArrayList<EmployeePayroll> update(Connection con) {
		Scanner sc = new Scanner(System.in);
		StatementServices services = StatementServices.getStatementInstance();
		System.out.println("Choose option to Update using:\n 1.Name\n 2.Exit ");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			System.out.print("Enter name : ");
			String name = sc.next();
			System.out.println("Choose option to update :\n 1.Salary\n 2.Exit ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.print("Enter Salary to be updated: :");
				double salary = sc.nextDouble();
				return services.updateSalary(con, name, salary);
			case 2:
				return null;
			default:
				System.out.print("Choose valid option: ");
				break;
			}
		
		default:
			System.out.print("Choose valid option: ");
			break;

		}
		return null;
	}

}
