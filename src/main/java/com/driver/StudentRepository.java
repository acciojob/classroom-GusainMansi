package com.driver;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.servlet.ServletOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;



public class StudentRepository {
  private  HashMap<String,Student> students;
   private HashMap<String,Teacher> teachers;
   private HashMap<String , List<String>> pairTeacherStudent;

    public StudentRepository(HashMap<String, Student> students, HashMap<String, Teacher> teachers, HashMap<String, List<String>> pairTeacherStudent) {
        this.students = new HashMap<>();
        this.teachers = new HashMap<>() ;
        this.pairTeacherStudent =new HashMap<String, List<String>>() ;
    }
    public void addStudent(Student stud){
        students.put(stud.getName(),stud);
    }
    public void addTeacher(Teacher teacher){
        teachers.put(teacher.getName(),teacher);
    }
    public void addTeacherStudent(String student,String teacher){
        if(students.containsKey(student)&& teachers.containsKey(teacher)){
            students.put(student,students.get(student));
            teachers.put(teacher,teachers.get(teacher));
            List<String>currentStudents=new ArrayList<String>();
            if(pairTeacherStudent.containsKey(teacher))
                currentStudents=pairTeacherStudent.get(teacher);
            currentStudents.add(student);
            pairTeacherStudent.put(teacher,currentStudents);
        }

    }
    public Student findStudent(String student){
        return students.get(student);
    }
    public Teacher findTeacher(String teacher){
        return teachers.get(teacher);
    }
    public List<String> findStudentsfromTeachers(String teacher){
        List<String>studentList=new ArrayList<>();
        if(pairTeacherStudent.containsKey(teacher))
            studentList=pairTeacherStudent.get(teacher);
        return studentList;
    }
    public List<String> findAllStudents(){

        return new ArrayList<>(students.keySet());
    }
    public void deleteTeacher(String teacher){
        List<String > stu=new ArrayList<>();
        if(pairTeacherStudent.containsKey(teacher)){
            stu=pairTeacherStudent.get(teacher);
        }
        pairTeacherStudent.remove(teacher);
        for(String s: stu){
            if(students.containsValue(s))
                students.remove(s);
        }
        if(teachers.containsKey(teacher))
            teachers.remove(teacher);
    }
    public void deleteAllTeachers(){
        HashSet<String> studentSet=new HashSet<String>();
        for(String teacher:pairTeacherStudent.keySet()){
            for(String student:pairTeacherStudent.get(teacher))
                studentSet.add(student);
        }

       for(String student: studentSet){
    if(students.containsKey(student))
        students.remove(students);
    }}
}
