package com.hexaware.studentins.services;

import com.hexaware.studentins.beans.Course;
import com.hexaware.studentins.beans.Enrollment;
import com.hexaware.studentins.beans.Student;
import com.hexaware.studentins.dao.EnrollmentDAO;
import com.hexaware.studentins.dao.EnrollmentDAOImpl;

import java.time.LocalDate;

public class EnrollmentServiceImpl implements EnrollmentService {
    private final EnrollmentDAO dao = new EnrollmentDAOImpl();

    public boolean enrollStudent(int id, Student student, Course course) {
        try {
            Enrollment e = new Enrollment(id, student, course, LocalDate.now());
            return dao.addEnrollment(e);
        } catch (Exception e1) {
            System.out.println("Error enrolling student: " + e1.getMessage());
            return false;
        }
    }
}
