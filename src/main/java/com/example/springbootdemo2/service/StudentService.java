package com.example.springbootdemo2.service;

import com.example.springbootdemo2.entity.Student;
import com.example.springbootdemo2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
public class StudentService {
/*Dependency Injection*/
    @Autowired
    private StudentRepository studentRepository ;
/*Show all the students*/
    public List<Student> listAllStudents(){
        return studentRepository.listStudents();
    }
/*Get the student by ID, return String type*/
    public String getStudentById(String id){
        if(studentRepository.loadStudent(id)==null){
            return "Student id: " + id + " does not exist!";
        }
        return studentRepository.loadStudent(id).toString();
    }
/*Get the student by ID, return Student type*/
    public Student getById(String id){
        return studentRepository.loadStudent(id);
    }
    public boolean idExist(String id){
        if(studentRepository.loadStudent(id)==null){
            return false;
        }
        return true;
    }
/*Create a new student*/
    public String createStudent(Student student){
        if(studentRepository.saveStudent(student)){
            return "Successfully created!";
        }
        return student.getId() + " already exists!";
    }
/*Update the student information*/
    public String updateStudent(Student student){
        if(studentRepository.updateStudent(student)){
            return "Successfully updated!";
        }
        return "Update failed!";
    }
/*Delete the student*/
    public String deleteStudent(Student student){
        if(studentRepository.deleteStudent(student)){
            return "Successfully deleted!";
        }
        return "Failed to delete!";
    }
}
