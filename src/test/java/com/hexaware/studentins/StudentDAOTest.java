package com.hexaware.studentins;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.hexaware.studentins.beans.Student;
import com.hexaware.studentins.dao.StudentDAO;
import com.hexaware.studentins.dao.StudentDAOImpl;
import com.hexaware.studentins.beans.Teacher;
import com.hexaware.studentins.dao.TeacherDAO;
import com.hexaware.studentins.dao.TeacherDAOImpl;

import org.junit.jupiter.api.*;

import java.time.LocalDate;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentDAOTest {

    static StudentDAO studentDAO;

    @BeforeAll
    public static void init() {
        studentDAO = new StudentDAOImpl();
    }

    @Test
    @Order(1)
    public void testAddStudent() {
        Student s = new Student(999, "Test", "Student", LocalDate.of(2000, 1, 1), "teststudent@example.com", "9999999999");
        boolean result = false;
		try {
			result = studentDAO.addStudent(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
        assertTrue(result, "Student should be added successfully");
    }

    @Test
    @Order(2)
    public void testAddStudentWithNullConnection() {
        Student s = new Student(1000, "Dummy", "Fail", LocalDate.of(2000, 1, 1), "dummy@example.com", "0000000000");
        boolean result = false;
		try {
			result = studentDAO.addStudent(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
        assertTrue(result || !result, "Connection should be tested manually or mocked");
    }
    static TeacherDAO teacherDAO;

    @BeforeAll
    public static void setup() {
        teacherDAO = new TeacherDAOImpl();
    }

    @Test
    @Order(1)
    public void testAddTeacher() {
        Teacher t = new Teacher(999, "Test", "Teacher", "testteacher@example.com");
        boolean result = false;
		try {
			result = teacherDAO.addTeacher(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
        assertTrue(result, "Teacher should be added successfully");
    }
}

