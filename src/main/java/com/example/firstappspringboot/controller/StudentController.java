package com.example.firstappspringboot.controller;


import com.example.firstappspringboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import  java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    @GetMapping("/students")
    public ResponseEntity<Student> studJson(){
        return ResponseEntity.ok(new Student(1,"Rayyan",9));
    }

@GetMapping("/studentlist")
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students=new ArrayList<>();
        students.add(new Student(1,"Shabana",32));
        students.add(new Student(2,"Rayyan",8));
        students.add(new Student(3,"Shabna",27));
        return ResponseEntity.ok(students);
    }

    //REST API with @PathVariable
    @GetMapping("{id}/{name}/{age}")
    public ResponseEntity<Student> getStudentPathVariable(@PathVariable("id") int studentId,@PathVariable("name")String nameOf,@PathVariable("age") int ageOf){
        return ResponseEntity.ok(new Student(studentId,nameOf,ageOf));
    }

    //RESTAPI with RequestParam
    @GetMapping("query")
    public ResponseEntity<Student> studentParam(@RequestParam int id,@RequestParam String name,@RequestParam int age){
        return ResponseEntity.ok(new Student(id,name,age));
    }

    //REST api that handles POST Request
    //@PostMapping and @RequestBody
    @PostMapping("create")
    public ResponseEntity<Student> studentCreate(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getName());
        System.out.println(student.getAge());
        return new ResponseEntity<>(student,HttpStatus.CREATED);
    }

    //REST API that handles PUT Request-Upadating existing resource
    //@PutMapping
    @PutMapping("update/{id}")
    public ResponseEntity<Student> studentUpdate(@RequestBody Student student,@PathVariable("id") int studentId){
        System.out.println(student.getName());
        System.out.println(student.getAge());
        return ResponseEntity.ok(student);
    }
    //REST API that handles DELETE request-deleting existing resource
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> studentDelete(@PathVariable("id")int studentId){
        System.out.println(studentId);
        return ResponseEntity.ok("Successfully Deleted");
    }
}
