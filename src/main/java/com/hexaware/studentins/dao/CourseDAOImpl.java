package com.hexaware.studentins.dao;

import com.hexaware.studentins.beans.Course;
import com.hexaware.studentins.util.DBConnUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CourseDAOImpl implements CourseDAO {
    @Override
    public boolean addCourse(Course c) {
        Connection con = DBConnUtil.getConnection();
        if (con == null) {
            System.out.println("DB connection failed.");
            return false;
        }

        String sql = "INSERT INTO Courses(course_id, course_name, course_code) VALUES (?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, c.getCourseId());
            ps.setString(2, c.getCourseName());
            ps.setString(3, c.getCourseCode());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("addCourse Error: " + e.getMessage());
            return false;
        }
    }
}
