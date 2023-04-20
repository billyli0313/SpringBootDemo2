package com.example.springbootdemo2.controller;

import com.example.springbootdemo2.entity.Student;
import com.example.springbootdemo2.entity.Teacher;
import com.example.springbootdemo2.service.SignupService;
import com.example.springbootdemo2.service.StudentService;
import com.example.springbootdemo2.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class SignUpController {
/*Dependency Injection*/
    @Autowired
    private SignupService signupService ;

/*Sign up connection*/
    @PostMapping(value = "/signup")
    public String signUpTeacherAndStudent(@RequestParam(value = "studentId")String studentId,
                              @RequestParam(value = "teacherId")String teacherId){
        return signupService.signupTeacherAndStudent(studentId,teacherId);
    }
/*Update connection*/
    @PutMapping(value = "/update/signup")
    public String updateSignup(@RequestParam(value = "studentId")String studentId,
                             @RequestParam(value = "teacherId")String teacherId) {
        return signupService.updateSignup(studentId,teacherId);
    }
/*Delete connection*/
    @DeleteMapping(value = "delete/signup")
    public String deleteSignup(@RequestParam(value = "studentId")String studentId){
        return signupService.deleteSignup(studentId);
    }
}
