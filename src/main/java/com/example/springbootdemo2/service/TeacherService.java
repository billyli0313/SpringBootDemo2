package com.example.springbootdemo2.service;

import com.example.springbootdemo2.entity.Student;
import com.example.springbootdemo2.entity.Teacher;
import com.example.springbootdemo2.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TeacherService {
    /*Dependency Injection*/
    @Autowired
    private TeacherRepository teacherRepository;
/*Get the teacher by ID*/
    public Teacher getTeacherById(String id){
        return teacherRepository.getTeacher(id);
    }
/*Save the teacher information*/
    public String saveTeacher(Teacher teacher){
        if(teacherRepository.saveTeacher(teacher)){
            return "Successfully created!";
        }
        return teacher.getId() + " already exists!";
    }
/*Add a student ID to the teacher*/
    public void addStudent(Teacher teacher, Student student){
        teacherRepository.addStudent(teacher,student);
    }
    public void removeStudent(Teacher teacher, Student student){
        teacherRepository.removeStudent(teacher,student);
    }
}
