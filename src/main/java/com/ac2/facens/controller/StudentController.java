package com.ac2.facens.controller;

import com.ac2.facens.api.services.StudentService;
import com.ac2.facens.model.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public void addStudent(@RequestParam String name, @RequestParam String birthday) {
        LocalDate birthDate = LocalDate.parse(birthday);
        studentService.addStudent(name, birthDate);
    }

    @GetMapping("/{id}")
    public Optional<StudentModel> getStudent(@PathVariable int id) {
        return studentService.getStudent(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
    }

    @PostMapping("/{studentId}/subjects/{subjectId}")
    public void addSubject(@PathVariable int studentId, @PathVariable int subjectId) {
        //studentService.addSubject(studentId, subjectId);
    }

    @DeleteMapping("/{studentId}/subjects/{subjectId}")
    public void removeSubject(@PathVariable int studentId, @PathVariable int subjectId) {
        studentService.removeSubject(studentId, subjectId);
    }

    @GetMapping("/detailed")
    public List<StudentModel> getAllStudents() {
        return studentService.getAllStudents();
    }
}

