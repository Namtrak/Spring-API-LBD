package com.example.SpringRESTAPILBD.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all")
    ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok().header("Successful:", "true")
                .body(studentService.getAllStudents());
    }

    @GetMapping(path = "{id}")
    ResponseEntity<Student> getStudent(@PathVariable("id") Long id) {
        if (id < 0) {
            return ResponseEntity.badRequest().header("Successful:", "false").body(null);
        }

        return ResponseEntity.ok().header("Successful:", "true")
                .body(studentService.getStudent(id));
    }

    @PostMapping
    ResponseEntity<String> addStudent(@RequestBody Student student) {
        if (student.getId() < 0 || student.getAge() < 6) {
            return ResponseEntity.badRequest().header("Successful:", "false").body("Invalid id or age");
        }

        studentService.addStudent(student);
        return ResponseEntity.ok().header("Successful:", "true").body("Student added");
    }

    @PutMapping(path = "{id}")
    ResponseEntity<String> editStudent(@PathVariable("id") Long id, @RequestBody Student student) {
        if (student.getId() < 0 || student.getAge() < 6 || id < 0) {
            return ResponseEntity.badRequest().header("Successful:", "false").body("Invalid id or age");
        }

        studentService.editStudent(id, student);
        return ResponseEntity.ok().header("Successful:", "true").body("Student updated");
    }

    @DeleteMapping(path = "{id}")
    ResponseEntity<String> deleteStudent(@PathVariable("id") Long id) {
        if (id < 0) {
            return ResponseEntity.badRequest().header("Successful:", "false").body("Invalid id or age");
        }

        studentService.deleteStudent(id);
        return ResponseEntity.ok().header("Successful:", "true").body("Student deleted");
    }
}
