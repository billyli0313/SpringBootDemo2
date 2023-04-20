package com.example.springbootdemo2.service;

import com.example.springbootdemo2.entity.Student;
import com.example.springbootdemo2.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;

public class SignupService {
/*Dependency Injection*/
    @Autowired
    private TeacherService teacherService ;
/*Dependency Injection*/
    @Autowired
    private StudentService studentService ;

    public String signupTeacherAndStudent(String studentId,String teacherId){
        Student student = studentService.getById(studentId);
        Teacher teacher = teacherService.getTeacherById(teacherId);

        if(teacher != null && student != null){
            if(student.getTeacherId() != null){
                return "The student has the teacher: " + student.getTeacherId() + " , cannot sign up again!";
            }
/*Create the connection between student and teacher*/
            student.setTeacherId(teacherId);
            studentService.updateStudent(student);
            teacherService.addStudent(teacher,student);
            return "Connect successfully!";
        }else if(student == null){
            return "The student does not exist！";
        }else {
            return "The teacher does not exist！";
        }
    }
    public String updateSignup(String studentId,String teacherId){
        Student student = studentService.getById(studentId);
        Teacher teacher = teacherService.getTeacherById(teacherId);
        if(teacher != null && student != null){
/*Clean up previous connection*/
            if(student.getTeacherId() != null){
                Teacher previousTeacher = teacherService.getTeacherById(student.getTeacherId());
                previousTeacher.removeStudent(student);
            }
/*Build up new connection*/
            student.setTeacherId(teacherId);
            studentService.updateStudent(student);
            teacherService.addStudent(teacher,student);
            return "Update connection successfully!";
        }else if(student == null){
            return "The student does not exist！";
        }else {
            return "The teacher does not exist！";
        }
    }
    public String deleteSignup(String studentId){
        Student student = studentService.getById(studentId);
        if(student != null) {
            if (student.getTeacherId() != null){
/*Clean up the connection*/
                Teacher teacher = teacherService.getTeacherById(student.getTeacherId());
                teacherService.removeStudent(teacher,student);
                student.setTeacherId(null);
                studentService.updateStudent(student);
                return "Delete connection successfully!";
            }else{
                return "The student has no teacher yet!";
            }
        }else{
            return "The student does not exist！";
        }
    }
}
