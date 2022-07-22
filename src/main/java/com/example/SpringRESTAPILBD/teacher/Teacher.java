package com.example.SpringRESTAPILBD.teacher;

public class Teacher {
    private Long id;
    private String firstName;
    private String lastName;
    private String subjectName; // suggestion: maybe subjectName will be better with Enum?

    public Teacher(Long id, String firstName, String lastName, String subjectName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        if (subjectName.equals("ALGEBRA") || subjectName.equals("LAW") || subjectName.equals("BIOLOGY"))
            this.subjectName = subjectName;
        else
            this.subjectName = null;
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

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
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
