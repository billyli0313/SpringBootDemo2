package com.example.springbootdemo2.controller;

import com.example.springbootdemo2.entity.Student;
import com.example.springbootdemo2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class StudentController  {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String start(){
        return "Welcome to Student Profile System!";
    }
/*Dependency Injection*/
    @Autowired
    private StudentService service;
/*Show all the students*/
    @GetMapping(value = "/students")
    public List<Student> listAllStudents(){
        return  service.listAllStudents();
    }
/*Show the student by ID*/
    @GetMapping(value = "/student/{id}")
    public String getStudentById(@PathVariable(value = "id")String id){
        return service.getStudentById(id).toString();
    }
/*Create a new student using parameter*/
    @PostMapping(value = "/create/student")
    public String createStudent(@RequestParam(value = "id")String id,@RequestParam(value = "name")String name,
                              @RequestParam(value = "age")int age,@RequestParam(value = "address")String address){
        Student student = new Student(id,name);
        student.setAge(age);
        student.setAddress(address);
        return service.createStudent(student);
    }
/*Update the student's information*/
    @PutMapping(value = "/update/student")
    public String updateStudent(@RequestParam(value = "id")String id,@RequestParam(value = "name")String name,
                              @RequestParam(value = "age")int age,@RequestParam(value = "address")String address){
        if(!service.idExist(id)){
            return "No such student id: " + id + " found";
        }
        Student student = service.getById(id);
        student.setName(name);
        student.setAge(age);
        student.setAddress(address);
        return service.updateStudent(student);
    }
/*Delete the student's information*/
    @DeleteMapping(value = "/delete/student")
    public String deleteStudent(@RequestParam(value = "id")String id){
        if(!service.idExist(id)){
            return "No such student id: " + id + " found";
        }
        Student student = service.getById(id);
        return service.deleteStudent(student);
    }
/*Create a new student using @RequestBody*/
    @PostMapping(value = "create/new/student")
    public String createNewStudent(@RequestBody Student student){
        return service.createStudent(student);
    }
/*Show the student by ID using @ResponseBody*/
    @GetMapping(value = "student/new/{id}")
    @ResponseBody
    public String getNewStudent(@PathVariable(value = "id")String id){
        return service.getStudentById(id).toString();
    }
}
