package com.hexaware.studentins.exception;

public class TeacherNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
    public TeacherNotFoundException(String TeacherNotFound) {
        super(TeacherNotFound);
    }
}
	