package com.hexaware.studentins.beans;

public class Teacher extends Person {
    private int teacherId;

    public Teacher(int teacherId, String firstName, String lastName, String email) {
        super(firstName, lastName, email);
        this.teacherId = teacherId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTeacherId() { return teacherId; }

    @Override
    public String getInfo() {
        return String.format("Teacher[%d] %s, Email: %s", teacherId, getFullName(), email);
    }
}
