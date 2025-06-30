package com.hexaware.studentins.exception;

public class StudentNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
    public StudentNotFoundException(String StudentNotFound) {
        super(StudentNotFound);
    }
}
