package com.driver;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student std){
        studentRepository.addStudent(std);
    }

    public void addTeacher(Teacher d){
        studentRepository.addTeacher(d);
    }

    public void createMovieDirectorPair(String student, String teacher){
        studentRepository.addTeacherStudent(student, teacher);
    }

    public Student findMovie(String studentName){
        return studentRepository.findStudent(studentName);
    }

    public Teacher findTeacher(String TeacherName){
        return studentRepository.findTeacher(TeacherName);
    }

    public List<String> findStudentsFromTeachers(String teacher){
        return studentRepository.findStudentsfromTeachers(teacher);
    }

    public List<String> findAllStudents(){
        return studentRepository.findAllStudents();
    }

    public void deleteTeacher(String teacher){
        studentRepository.deleteTeacher(teacher);
    }

    public void deleteAllTeachers(){
        studentRepository.deleteAllTeachers();
    }
}
