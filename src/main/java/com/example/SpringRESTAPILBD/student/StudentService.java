package com.example.SpringRESTAPILBD.student;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.core.util.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private ArrayList<Student> students;

    private Student maria = new Student(0L, "Maria", "Shapke", 23, new ArrayList<>(List.of("BIOLOGY", "LAW")));
    private Student henry = new Student(1L, "Henry", "Creel", 18, new ArrayList<>(List.of("BIOLOGY", "LAW", "ALGEBRA")));
    private Student thomas = new Student(2L, "Thomas", "Kopan", 20, new ArrayList<>(List.of("BIOLOGY")));
    private Student mateo = new Student(3L, "Mateo", "Trypol", 19, new ArrayList<>(List.of("LAW")));
    private Student ivy = new Student(4L, "Ivy", "Atreos", 26, new ArrayList<>(List.of("ALGEBRA", "LAW")));
    private Student aby = new Student(5L, "Aby", "Root", 22, new ArrayList<>(List.of("ALGEBRA")));
    private Student michael = new Student(6L, "Michael", "Poled", 34, new ArrayList<>(List.of("BIOLOGY")));
    private Student karen = new Student(7L, "Karen", "Workster", 29, new ArrayList<>(List.of("BIOLOGY", "LAW", "ALGEBRA")));
    private Student paulo = new Student(8L, "Paulo", "Truper", 17, new ArrayList<>(List.of("BIOLOGY", "ALGEBRA")));
    private Student kate = new Student(9L, "Kate", "super", 21, new ArrayList<>(List.of("BIOLOGY", "LAW")));

    public List<Student> getAllStudents() {
        return students;
    }

    @Autowired
    public StudentService() {
        students = new ArrayList<>(5);
        students.addAll(List.of(maria, henry, thomas, mateo, ivy, aby, michael, karen, paulo, kate));
    }

    public boolean addStudent(Student student) {
        if (students.contains(student)) {
            System.out.println("Error, student already exists.");
            return false;
        }

        students.add(student);
        return true;
    }

    public boolean editStudent(Long id, Student student) {
        Student studentToUpdate = students.get(id.intValue());
            studentToUpdate.setLastName(student.getLastName());
            studentToUpdate.setAge(student.getAge());
            return true;
    }

    public boolean deleteStudent(Long id) {
        Student studentToDelete = students.get(id.intValue());

        if (students.contains(studentToDelete)) {
            students.remove(studentToDelete);
            return true;
        }

        System.out.println("Wrong id");
        return false;
    }

    public Student getStudent(Long id) {
        Student student = students.get(id.intValue());

        if (students.contains(student)) {
            return student;
        }

        System.out.println("Wrong id");
        return null;
    }
}
