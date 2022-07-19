package com.example.SpringRESTAPILBD.teacher;

import com.example.SpringRESTAPILBD.student.Student;
import com.example.SpringRESTAPILBD.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {
    private ArrayList<Teacher> teachers;
    private StudentService studentService;

    private Teacher megan = new Teacher(0L, "Megan", "Fox", "LAW");
    private Teacher bob = new Teacher(1L, "Bob", "Builder", "ALGEBRA");
    private Teacher roman = new Teacher(2L, "Roman", "Witularro", "BIOLOGY");

    @Autowired
    public TeacherService(ArrayList<Teacher> teachers, StudentService studentService) {
        this.studentService = studentService;
        this.teachers = teachers;
        teachers.addAll(List.of(megan, bob, roman));
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(ArrayList<Teacher> teachers) {
        this.teachers = teachers;
    }

    public boolean addTeacher(Teacher teacher) {
        if (teachers.contains(teacher)) {
            System.out.println("Error, teacher already exists.");
            return false;
        }

        teachers.add(teacher);
        return true;
    }

    public boolean deleteTeacher(Long id) {
        Teacher teacherToDelete = teachers.get(id.intValue());

        if (teachers.contains(teacherToDelete)) {
            teachers.remove(teacherToDelete);
            return true;
        }

        System.out.println("Wrong id");
        return false;
    }

    public Teacher getTeacher(Long id) {
        Teacher teacher = teachers.get(id.intValue());

        if (teachers.contains(teacher)) {
            return teacher;
        }

        System.out.println("Wrong id");
        return null;
    }

    public List<Student> getTeacherClass(Long id) {
        if (teachers.isEmpty()) {
            return null;
        }

        List<Student> students = studentService.getAllStudents();
        List<Student> result = new ArrayList<>();

        for (Student student : students) {
            if (student.getSubjectList().contains(teachers.get(id.intValue()).getSubjectName())) {
                result.add(student);
            }
        }

        return result;
    }

    public void deleteStudentFromClassByTeacherId(Long teacherId, Long studentId) {
        List<Student> students = getTeacherClass(teacherId);
        students.get(students.indexOf(studentService.getStudent(studentId))).getSubjectList().
                remove(teachers.get(teacherId.intValue()).getSubjectName());
    }
}
