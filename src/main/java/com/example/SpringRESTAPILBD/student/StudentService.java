package com.example.SpringRESTAPILBD.student;

import com.example.SpringRESTAPILBD.student.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private ArrayList<Student> studentList;

    Student maria = new Student(1L, "Maria", "Shapke", 23);
    Student henry = new Student(2L, "Henry", "Creel", 18);
    Student thomas = new Student(3L, "Thomas", "Kopan", 20);
    Student mateo = new Student(4L, "Mateo", "Trypol", 19);
    Student ivy = new Student(5L, "Ivy", "Atreos", 26);

    public List<Student> getAllStudents() {
        return studentList;
    }

    public StudentService() {
        studentList = new ArrayList<>(5);
    }

    public boolean addStudent(Student student) {
        studentList.add(student);
        return true;
    }

    public void editStudent(Long id, String lastName, int age) {
        Student studentToUpdate = studentList.get(id.intValue());
        studentToUpdate.setLastName(lastName);
        studentToUpdate.setAge(age);
    }

    public void deleteStudent(Long id) {
        studentList.remove(id);
    }

    public Student getStudent(Long id) {
        return studentList.get(id.intValue());
    }
}
