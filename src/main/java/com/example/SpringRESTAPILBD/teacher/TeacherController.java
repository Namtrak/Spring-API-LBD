package com.example.SpringRESTAPILBD.teacher;

import com.example.SpringRESTAPILBD.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    ResponseEntity<String> addTeacher(@RequestBody Teacher teacher) {
        if (teacher.getId() < 0) {
            return ResponseEntity.badRequest().header("Successful:", "false").body("Invalid id");
        }

        teacherService.addTeacher(teacher);
        return ResponseEntity.ok().header("Successful:", "true").body("Teacher added");
    }

    @DeleteMapping(path = "{id}")
    ResponseEntity<String> deleteTeacher(@PathVariable("id") Long id) {
        if (id < 0) {
            return ResponseEntity.badRequest().header("Successful:", "false").body("Invalid id");
        }

        teacherService.deleteTeacher(id);
        return ResponseEntity.ok().header("Successful:", "true").body("Teacher deleted");
    }

    @GetMapping(path = "/all")
    ResponseEntity<List<Teacher>> getAllTeachers() {
        return ResponseEntity.ok().header("Successful:", "true")
                .body(teacherService.getAllTeachers());
    }

    @GetMapping(path = "{id}")
    ResponseEntity<Teacher> getTeacher(@PathVariable("id") Long id) {
        if (id < 0) {
            return ResponseEntity.badRequest().header("Successful:", "false").body(null);
        }

        return ResponseEntity.ok().header("Successful:", "true")
                .body(teacherService.getTeacher(id));
    }

    @GetMapping(path = "{id}/class")
    ResponseEntity<List<Student>> getTeacherClass(@PathVariable("id") Long id) {
        if (id < 0) {
            return ResponseEntity.badRequest().header("Successful:", "false").body(null);
        }

        return ResponseEntity.ok().header("Successful:", "true")
                .body(teacherService.getTeacherClass(id));
    }

    @DeleteMapping(path = "{teacherId}/class/{studentId}")
    ResponseEntity<String> deleteStudentFromClassByTeacherId(@PathVariable("teacherId") Long teacherId, @PathVariable("studentId") Long studentId) {
        if (teacherId < 0 || studentId < 0) {
            return ResponseEntity.badRequest().header("Successful:", "false").body("Invalid teacher or student id");
        }

        teacherService.deleteStudentFromClassByTeacherId(teacherId, studentId);
        return ResponseEntity.ok().header("Successful", "true").body("Student deleted from teacher classes");
    }
}
