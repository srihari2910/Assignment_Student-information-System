package com.hexaware.studentins.services;

import com.hexaware.studentins.beans.Student;
import java.math.BigDecimal;

public interface PaymentService {
    boolean makePayment(int id, BigDecimal amount, Student student);
}
