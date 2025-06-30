package com.hexaware.studentins.dao;

import com.hexaware.studentins.beans.Payment;

public interface PaymentDAO {
    boolean addPayment(Payment p) throws Exception;
}
