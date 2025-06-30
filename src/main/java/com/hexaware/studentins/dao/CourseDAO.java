package com.hexaware.studentins.dao;

import com.hexaware.studentins.beans.Course;

public interface CourseDAO {
    boolean addCourse(Course course) throws Exception;
}
