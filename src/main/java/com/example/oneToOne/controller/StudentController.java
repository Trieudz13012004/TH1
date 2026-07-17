package com.example.oneToOne.controller;

import com.example.oneToOne.entity.Student;
import com.example.oneToOne.service.StudentService;
import com.example.oneToOne.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    //    get all
    @GetMapping()
    public List<Student> getAllStudents(){
        return studentService.getAll();
    }

    //    get by id
    @GetMapping("/{id}")
    public Student getStudentByID(@PathVariable String id){
        return studentService.getStudentByID(Integer.parseInt(id));
    }

    //    create new student
    @PostMapping()
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    //    delete Student by id
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable String id){
        studentService.deleteStudent(Integer.parseInt(id));
    }

    //    update Student by id
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable String id, @RequestBody Student student){
        return studentService.updateStudent(Integer.parseInt(id), student);
    }
}