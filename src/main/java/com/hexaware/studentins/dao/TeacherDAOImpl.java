package com.hexaware.studentins.dao;

import com.hexaware.studentins.beans.Teacher;
import com.hexaware.studentins.util.DBConnUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TeacherDAOImpl implements TeacherDAO {
    @Override
    public boolean addTeacher(Teacher t) {
        Connection con = DBConnUtil.getConnection();
        if (con == null) {
            System.out.println("DB connection failed.");
            return false;
        }

        String sql = "INSERT INTO Teachers(teacher_id, first_name, last_name, email) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, t.getTeacherId());
            ps.setString(2, t.getFirstName());
            ps.setString(3, t.getLastName());
            ps.setString(4, t.getEmail());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("addTeacher Error: " + e.getMessage());
            return false;
        }
    }
}
