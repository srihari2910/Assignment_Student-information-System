package com.hexaware.studentins.main;

import com.hexaware.studentins.beans.*;
import com.hexaware.studentins.exception.DuplicateEnrollmentException;
import com.hexaware.studentins.services.StudentService;
import com.hexaware.studentins.services.StudentServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class OOPDemo {
    public static void main(String[] args) {
        System.out.println("=== OOP Feature Demonstration ===");

        // Task 10 & 11: Inheritance and Polymorphism
        Person student = new Student(101, "Hari", "Haran", LocalDate.of(2000, 1, 1), "hari@mail.com", "9876543210");
        Person teacher = new Teacher(201, "Saranya", "Rao", "sara@school.com");

        System.out.println("\n[Task 10] Inheritance & Polymorphism via getInfo():");
        System.out.println("Student Info: " + student.getInfo());
        System.out.println("Teacher Info: " + teacher.getInfo());

        // Task 11: Interface Usage
        StudentService service = new StudentServiceImpl();
        System.out.println("\n[Task 11] Using StudentService interface:");
        boolean added = service.createStudent(123, "Test", "Student", "test@x.com", "8888888888", LocalDate.of(1999, 12, 31));
        System.out.println(added ? "Student added using interface." : " Failed to add student.");

        // Cast back to Student to test enrollments
        Student s = (Student) student;
        Course c1 = new Course(1, "Java Programming", "CS101");
        Course c2 = new Course(2, "Database Systems", "DB201");

        try {
            System.out.println("\n[Task 8] Exception Handling (Duplicate Enrollment):");
            boolean enrolled1 = s.enrollInCourse(c1, 1001, LocalDate.now());
            System.out.println(enrolled1 ? "Enrolled in Java Programming" : "Enrollment failed");

            boolean enrolled2 = s.enrollInCourse(c1, 1002, LocalDate.now());
            System.out.println(enrolled2 ? "Re-enrolled" : "Already enrolled");
        } catch (DuplicateEnrollmentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        // Task 9: Collections
        try {
            s.enrollInCourse(c2, 1003, LocalDate.now());
        } catch (DuplicateEnrollmentException ignored) {}

        System.out.println("\n[Task 9] Collection of Enrollments:");
        List<Enrollment> enrollments = s.getAllEnrollments();
        for (Enrollment e : enrollments) {
            System.out.println("- Enrolled in: " + e.getCourse().getCourseName() +
                               " on " + e.getEnrollmentDate());
        }

        s.makePayment(5001, new BigDecimal("250.00"), LocalDateTime.now());
        s.makePayment(5002, new BigDecimal("300.00"), LocalDateTime.now());

        System.out.println("\n[Task 9] Payment History (List<Payment>):");
        for (Payment p : s.getPaymentHistory()) {
            System.out.println("- Paid ₹" + p.getPaymentAmount() + " on " + p.getPaymentDate());
        }

        System.out.println("\n=== End of OOP Demonstration ===");
    }
}
