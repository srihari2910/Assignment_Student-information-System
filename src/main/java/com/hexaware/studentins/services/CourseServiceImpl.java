package com.hexaware.studentins.services;

import com.hexaware.studentins.beans.Course;
import com.hexaware.studentins.dao.CourseDAO;
import com.hexaware.studentins.dao.CourseDAOImpl;

public class CourseServiceImpl implements CourseService {
    private final CourseDAO dao = new CourseDAOImpl();

    public boolean createCourse(int id, String name, String code) {
        try {
            Course c = new Course(id, name, code);
            return dao.addCourse(c);
        } catch (Exception e) {
            System.out.println("Error creating course: " + e.getMessage());
            return false;
        }
    }
}
