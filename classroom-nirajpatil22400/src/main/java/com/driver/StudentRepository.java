package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    // name -> Student
    HashMap<String, Student> studentHashMap = new HashMap<>();

    // name -> Teacher
    HashMap<String, Teacher> teacherHashMap = new HashMap<>();

    // name -> List of name of students
    HashMap<String, List<String>> teacherStudentHashMap = new HashMap<>();

    public void addStudent(Student student){
        studentHashMap.put(student.getName(), student);
    }

    public void addTeacher(Teacher teacher){
        teacherHashMap.put(teacher.getName(), teacher);
    }

    public void addStudentTeacherPair(String studentName, String teacherName){
        List<String> students = teacherStudentHashMap.getOrDefault(teacherName, new ArrayList<>());
        students.add(studentName);
        teacherStudentHashMap.put(teacherName, students);
    }

    public Student getStudentByName(String studentName){
        return studentHashMap.get(studentName);
    }

    public Teacher getTeacherByName(String teacherName){
        return teacherHashMap.get(teacherName);
    }

    public List<String> getStudentsByTeacherName(String teacherName){
        return teacherStudentHashMap.get(teacherName);
    }

    public List<String> getAllStudents(){
        List<String> allStudents = new ArrayList<>();
        allStudents.addAll(studentHashMap.keySet());
        return allStudents;
    }

    public void deleteTeacherByName(String teacherName){
        List<String> students = teacherStudentHashMap.remove(teacherName);
        for(String student: students){
            studentHashMap.remove(student);
        }
        teacherHashMap.remove(teacherName);
    }

    public void deleteAllTeachers(){
        for(String teacherName: teacherHashMap.keySet()){
            deleteTeacherByName(teacherName);
        }
    }

}