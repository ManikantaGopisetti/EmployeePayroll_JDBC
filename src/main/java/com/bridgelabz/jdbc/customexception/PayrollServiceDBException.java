package com.bridgelabz.jdbc.customexception;

public class PayrollServiceDBException extends Exception {

	private static final long serialVersionUID = 1L;

	public ExceptionType type;

	public PayrollServiceDBException(String message, ExceptionType type) {
		super(message);
		this.type = type;
	}

}
