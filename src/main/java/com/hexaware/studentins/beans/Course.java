package com.hexaware.studentins.beans;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private int courseId;
    private String courseName;
    private String courseCode;
    private Teacher assignedTeacher;
    private final List<Enrollment> enrollments = new ArrayList<>();

    public Course(int courseId, String courseName, String courseCode) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseCode = courseCode;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setAssignedTeacher(Teacher teacher) {
        this.assignedTeacher = teacher;
    }

    public int getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }
    public String getCourseCode() { return courseCode; }
    public Teacher getAssignedTeacher() { return assignedTeacher; }

    public boolean addEnrollment(Enrollment e) {
        return enrollments.add(e);
    }

    public String getCourseInfo() {
        return String.format("Course[%d] %s (%s)", courseId, courseName, courseCode);
    }
}
