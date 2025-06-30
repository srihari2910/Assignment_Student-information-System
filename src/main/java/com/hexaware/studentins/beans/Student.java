package com.hexaware.studentins.beans;

import com.hexaware.studentins.exception.DuplicateEnrollmentException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.math.BigDecimal;

public class Student extends Person {
    private int studentId;
    private LocalDate dateOfBirth;
    private String phoneNumber;

    private final List<Enrollment> enrollments = new ArrayList<>();
    private final List<Payment> payments = new ArrayList<>();

    public Student(int studentId, String firstName, String lastName,
                   LocalDate dateOfBirth, String email, String phoneNumber) {
        super(firstName, lastName, email);
        this.studentId = studentId;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
    }

    public boolean enrollInCourse(Course course, int enrollmentId, LocalDate date)
            throws DuplicateEnrollmentException {
        for (Enrollment e : enrollments) {
            if (e.getCourse().getCourseId() == course.getCourseId()) {
                throw new DuplicateEnrollmentException("Already enrolled in this course!");
            }
        }
        Enrollment enrollment = new Enrollment(enrollmentId, this, course, date);
        enrollments.add(enrollment);
        course.addEnrollment(enrollment);
        return true;
    }

    public boolean makePayment(int paymentId, BigDecimal amount, LocalDateTime paymentDate) {
        Payment payment = new Payment(paymentId, this, amount, paymentDate);
        payments.add(payment);
        return true;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStudentId() { return studentId; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public String getPhoneNumber() { return phoneNumber; }
    public List<Enrollment> getAllEnrollments() { return Collections.unmodifiableList(enrollments); }
    public List<Payment> getPaymentHistory() { return Collections.unmodifiableList(payments); }

    public boolean addEnrollment(Enrollment e) {
        return enrollments.add(e);
    }

    public boolean addPayment(Payment p) {
        return payments.add(p);
    }

    @Override
    public String getInfo() {
        return String.format("Student[%d] %s, DOB: %s, Email: %s, Phone: %s",
                studentId, getFullName(), dateOfBirth, email, phoneNumber);
    }
}
