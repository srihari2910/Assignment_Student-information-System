package com.hexaware.studentins.dao;

import com.hexaware.studentins.beans.Enrollment;
import com.hexaware.studentins.util.DBConnUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;

public class EnrollmentDAOImpl implements EnrollmentDAO {
    @Override
    public boolean addEnrollment(Enrollment e) {
        Connection con = DBConnUtil.getConnection();
        if (con == null) {
            System.out.println("DB connection failed.");
            return false;
        }

        String sql = "INSERT INTO Enrollments(enrollment_id, student_id, course_id, enrollment_date) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, e.getEnrollmentId());
            ps.setInt(2, e.getStudent().getStudentId());
            ps.setInt(3, e.getCourse().getCourseId());
            ps.setDate(4, Date.valueOf(e.getEnrollmentDate()));
            return ps.executeUpdate() > 0;
        } catch (Exception ex) {
            System.err.println("addEnrollment Error: " + ex.getMessage());
            return false;
        }
    }
}
