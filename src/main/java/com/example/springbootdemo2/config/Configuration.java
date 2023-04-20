package com.example.springbootdemo2.config;

import com.example.springbootdemo2.entity.Teacher;
import com.example.springbootdemo2.repository.StudentRepository;
import com.example.springbootdemo2.repository.TeacherRepository;
import com.example.springbootdemo2.service.SignupService;
import com.example.springbootdemo2.service.StudentService;
import com.example.springbootdemo2.service.TeacherService;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
/*Inversion of Control*/
public class Configuration {
    @Bean
    public StudentService buildStudentService(){
        return new StudentService();
    }
    @Bean
    public TeacherService buildTeacherService(){
        return new TeacherService();
    }
    @Bean
    public SignupService buildSignupService(){
        return new SignupService();
    }
    @Bean
    public StudentRepository buildStudentRepository(){
        return new StudentRepository();
    }
    @Bean
    public TeacherRepository buildTeacherRepository(){
        return new TeacherRepository();
    }
}
