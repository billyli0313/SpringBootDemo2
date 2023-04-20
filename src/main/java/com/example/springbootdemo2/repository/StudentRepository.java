package com.example.springbootdemo2.repository;

import com.example.springbootdemo2.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class StudentRepository {

    Map<String, Student> studentStorage = new HashMap<>();
/*Get all the students*/
    public List<Student> listStudents(){
        return  studentStorage.values().stream().collect(Collectors.toList());
    }
/*Get the student by ID*/
    public Student loadStudent (String studentId){
        return studentStorage.getOrDefault(studentId,null);
    }
/*Save the data of student*/
    public boolean saveStudent(Student student){
        String id = student.getId();
        if(!studentStorage.containsKey(id)){
            studentStorage.put(id,student);
            return true;
        }
        return false;
    }
/*Update the data of student*/
    public boolean updateStudent(Student student){
        String id = student.getId();
        if(studentStorage.containsKey(id)){
            studentStorage.put(id,student);
            return true;
        }
        return false;
    }
/*Delete the data of student*/
    public boolean deleteStudent(Student student){
        String id = student.getId();
        if (studentStorage.containsKey(id)){
            studentStorage.remove(id);
            return true;
        }
        return false;
    }
}
