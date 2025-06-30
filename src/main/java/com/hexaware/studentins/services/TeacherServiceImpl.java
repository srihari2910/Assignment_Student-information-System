package com.hexaware.studentins.services;

import com.hexaware.studentins.beans.Teacher;
import com.hexaware.studentins.dao.TeacherDAO;
import com.hexaware.studentins.dao.TeacherDAOImpl;

public class TeacherServiceImpl implements TeacherService {
    private final TeacherDAO dao = new TeacherDAOImpl();

    public boolean createTeacher(int id, String fn, String ln, String email) {
        try {
            Teacher t = new Teacher(id, fn, ln, email);
            return dao.addTeacher(t);
        } catch (Exception e) {
            System.out.println("Error creating teacher: " + e.getMessage());
            return false;
        }
    }
}
