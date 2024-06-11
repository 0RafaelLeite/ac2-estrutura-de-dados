package com.ac2.facens.controller;

import com.ac2.facens.api.services.StudentService;
import com.ac2.facens.model.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public void addStudent(@RequestParam int id, @RequestParam String name, @RequestParam String birthday) {
        LocalDate birthDate = LocalDate.from(java.time.LocalDate.parse(birthday).atStartOfDay().atZone(java.time.ZoneId.systemDefault()).toInstant());
        studentService.addStudent(id, name, birthDate);
    }

    @GetMapping("/{id}")
    public StudentModel getStudent(@PathVariable int id) {
        //return studentService.getStudent(id);
        return new StudentModel(null, null);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
    }

    @PostMapping("/{studentId}/subjects")
    public void addSubject(@PathVariable int studentId, @RequestParam int subjectId) {
        studentService.addSubject(studentId, subjectId);
    }

    @DeleteMapping("/{studentId}/subjects/{subjectId}")
    public void removeSubject(@PathVariable int studentId, @PathVariable int subjectId) {
        studentService.removeSubject(studentId, subjectId);
    }
}

