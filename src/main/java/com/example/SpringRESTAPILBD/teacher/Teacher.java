package com.example.SpringRESTAPILBD.teacher;

public class Teacher {
    private Long id;
    private String firstName;
    private String lastName;
    private Subject subjectName;

    public Teacher(Long id, String firstName, String lastName, Subject subjectName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.subjectName = subjectName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Subject getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(Subject subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", subjectName='" + subjectName + '\'' +
                '}';
    }
}
