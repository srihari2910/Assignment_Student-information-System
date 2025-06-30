package com.hexaware.studentins.dao;

import com.hexaware.studentins.beans.Enrollment;

public interface EnrollmentDAO {
    boolean addEnrollment(Enrollment e) throws Exception;
}
