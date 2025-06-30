package com.hexaware.studentins.services;

import com.hexaware.studentins.beans.Student;
import com.hexaware.studentins.dao.StudentDAO;
import com.hexaware.studentins.dao.StudentDAOImpl;

import java.time.LocalDate;

public class StudentServiceImpl implements StudentService {
    private final StudentDAO dao = new StudentDAOImpl();

    public boolean createStudent(int id, String fn, String ln, String email, String phone, LocalDate dob) {
        try {
            Student s = new Student(id, fn, ln, dob, email, phone);
            return dao.addStudent(s);
        } catch (Exception e) {
            System.out.println("Error creating student: " + e.getMessage());
            return false;
        }
    }
}
