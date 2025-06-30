package com.hexaware.studentins.services;

import com.hexaware.studentins.beans.Payment;
import com.hexaware.studentins.beans.Student;
import com.hexaware.studentins.dao.PaymentDAO;
import com.hexaware.studentins.dao.PaymentDAOImpl;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentServiceImpl implements PaymentService {
    private final PaymentDAO dao = new PaymentDAOImpl();

    public boolean makePayment(int id, BigDecimal amount, Student student) {
        try {
            Payment p = new Payment(id, student, amount, LocalDateTime.now());
            return dao.addPayment(p);
        } catch (Exception e) {
            System.out.println("Error making payment: " + e.getMessage());
            return false;
        }
    }
}
