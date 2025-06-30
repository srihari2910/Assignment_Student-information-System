package com.hexaware.studentins.dao;

import com.hexaware.studentins.beans.Payment;
import com.hexaware.studentins.util.DBConnUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

public class PaymentDAOImpl implements PaymentDAO {
    @Override
    public boolean addPayment(Payment p) {
        Connection con = DBConnUtil.getConnection();
        if (con == null) {
            System.out.println("DB connection failed.");
            return false;
        }

        String sql = "INSERT INTO Payments(payment_id, student_id, amount, payment_date) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, p.getPaymentId());
            ps.setInt(2, p.getStudent().getStudentId());
            ps.setBigDecimal(3, p.getPaymentAmount());
            ps.setTimestamp(4, Timestamp.valueOf(p.getPaymentDate()));
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("addPayment Error: " + e.getMessage());
            return false;
        }
    }
}
