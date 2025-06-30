package com.hexaware.studentins.services;

import com.hexaware.studentins.beans.Student;
import com.hexaware.studentins.beans.Course;

public interface EnrollmentService {
    boolean enrollStudent(int id, Student student, Course course);
}
