package com.hexaware.studentins.services;

import java.time.LocalDate;

public interface StudentService {
    boolean createStudent(int id, String fn, String ln, String email, String phone, LocalDate dob);
}
