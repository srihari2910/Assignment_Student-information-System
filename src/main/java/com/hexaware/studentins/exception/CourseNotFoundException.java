package com.hexaware.studentins.exception;

public class CourseNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
    public CourseNotFoundException(String CourseNotFound) {
        super(CourseNotFound);
    }
}
