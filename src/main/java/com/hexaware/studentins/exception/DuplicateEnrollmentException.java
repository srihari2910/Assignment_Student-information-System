package com.hexaware.studentins.exception;

public class DuplicateEnrollmentException extends Exception {
	private static final long serialVersionUID = 1L;
    public DuplicateEnrollmentException(String DuplicateEnrollment) {
        super(DuplicateEnrollment);
    }
}
