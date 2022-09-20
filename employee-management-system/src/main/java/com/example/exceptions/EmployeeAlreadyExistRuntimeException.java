package com.example.exceptions;

public class EmployeeAlreadyExistRuntimeException extends RuntimeException {

	public EmployeeAlreadyExistRuntimeException(String message) {
		super(message);
	}
}
