package com.hexaware.studentins.beans;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Payment {
    private int paymentId;
    private Student student;
    private BigDecimal paymentAmount;
    private LocalDateTime paymentDate;

    public Payment(int paymentId, Student student, BigDecimal paymentAmount, LocalDateTime paymentDate) {
        this.paymentId = paymentId;
        this.student = student;
        this.paymentAmount = paymentAmount;
        this.paymentDate = paymentDate;
    }

    public int getPaymentId() { return paymentId; }
    public Student getStudent() { return student; }
    public BigDecimal getPaymentAmount() { return paymentAmount; }
    public LocalDateTime getPaymentDate() { return paymentDate; }
}
