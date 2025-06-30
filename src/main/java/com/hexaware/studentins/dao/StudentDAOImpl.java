package com.hexaware.studentins.dao;

import com.hexaware.studentins.beans.Student;
import com.hexaware.studentins.util.DBConnUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public boolean addStudent(Student s) {
        Connection con = DBConnUtil.getConnection();
        if (con == null) {
            System.out.println("DB connection failed.");
            return false;
        }

        String sql = "INSERT INTO Students(student_id, first_name, last_name, date_of_birth, email, phone_number) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, s.getStudentId());
            ps.setString(2, s.getFirstName());
            ps.setString(3, s.getLastName());
            ps.setDate(4, Date.valueOf(s.getDateOfBirth()));
            ps.setString(5, s.getEmail());
            ps.setString(6, s.getPhoneNumber());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("addStudent Error: " + e.getMessage());
            return false;
        }
    }
}
