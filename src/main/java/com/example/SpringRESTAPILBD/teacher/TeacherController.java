package com.example.SpringRESTAPILBD.teacher;

import com.example.SpringRESTAPILBD.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/teacher")
public class TeacherController {
    private TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    public void addTeacher(@RequestBody Teacher teacher) {
        teacherService.addTeacher(teacher);
    }

    @DeleteMapping(path = "{id}")
    public void deleteTeacher(@PathVariable("id") Long id) {
        teacherService.deleteTeacher(id);
    }

    @GetMapping(path = "/all")
    public List<Teacher> getAllTeachers() {
        return teacherService.getTeachers();
    }

    @GetMapping(path = "{id}")
    public Teacher getTeacher(@PathVariable("id") Long id) {
        return teacherService.getTeacher(id);
    }

    @GetMapping(path = "{id}/class")
    public List<Student> getTeacherClass(@PathVariable("id") Long id) {
        return teacherService.getTeacherClass(id);
    }

    @DeleteMapping(path = "{teacherId}/class/{studentId}")
    public void deleteStudentFromClassByTeacherId(@PathVariable("teacherId") Long teacherId, @PathVariable("studentId") Long studentId) {
        teacherService.deleteStudentFromClassByTeacherId(teacherId, studentId);
    }
}
