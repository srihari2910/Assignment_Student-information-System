package com.hexaware.studentins.main;
import com.hexaware.studentins.beans.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;
import com.hexaware.studentins.services.*;



public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StudentService studentService = new StudentServiceImpl();
        CourseService courseService = new CourseServiceImpl();
        TeacherService teacherService = new TeacherServiceImpl();
        PaymentService paymentService = new PaymentServiceImpl();
        EnrollmentService enrollmentService = new EnrollmentServiceImpl();

        Student student = null;
        Course course = null;
        Teacher teacher = null;

        int choice;
        do {
            System.out.println("\n--- SIS Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Add Teacher");
            System.out.println("4. Enroll Student in Course");
            System.out.println("5. Make Payment");
            System.out.println("6. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("ID: "); int sid = sc.nextInt(); sc.nextLine();
                    System.out.print("First: "); String fn = sc.nextLine();
                    System.out.print("Last: "); String ln = sc.nextLine();
                    System.out.print("DOB (yyyy-mm-dd): "); LocalDate dob = LocalDate.parse(sc.nextLine());
                    System.out.print("Email: "); String email = sc.nextLine();
                    System.out.print("Phone: "); String phone = sc.nextLine();
                    student = new Student(sid, fn, ln, dob, email, phone);
                    System.out.println(studentService.createStudent(sid, fn, ln, email, phone, dob)
                            ? "Student added" : "Failed");
                    break;

                case 2:
                    System.out.print("ID: "); int cid = sc.nextInt(); sc.nextLine();
                    System.out.print("Name: "); String cname = sc.nextLine();
                    System.out.print("Code: "); String ccode = sc.nextLine();
                    course = new Course(cid, cname, ccode);
                    System.out.println(courseService.createCourse(cid, cname, ccode)
                            ? "Course added" : "Failed");
                    break;

                case 3:
                    System.out.print("ID: "); int tid = sc.nextInt(); sc.nextLine();
                    System.out.print("First: "); String tfn = sc.nextLine();
                    System.out.print("Last: "); String tln = sc.nextLine();
                    System.out.print("Email: "); String temail = sc.nextLine();
                    teacher = new Teacher(tid, tfn, tln, temail);
                    System.out.println(teacherService.createTeacher(tid, tfn, tln, temail)
                            ? "Teacher added" : "Failed");
                    break;

                case 4:
                    if (student != null && course != null) {
                        System.out.print("Enrollment ID: ");
                        int eid = sc.nextInt(); sc.nextLine();
                        System.out.println(enrollmentService.enrollStudent(eid, student, course)
                                ? "Enrolled" : "Failed");
                    } else {
                        System.out.println("Create student and course first.");
                    }
                    break;

                case 5:
                    if (student != null) {
                        System.out.print("Payment ID: "); int pid = sc.nextInt();
                        System.out.print("Amount: "); BigDecimal amt = sc.nextBigDecimal(); sc.nextLine();
                        System.out.println(paymentService.makePayment(pid, amt, student)
                                ? "Payment done" : "Failed");
                    } else {
                        System.out.println("Create student first.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting.");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 6);

        sc.close();
    }
}











