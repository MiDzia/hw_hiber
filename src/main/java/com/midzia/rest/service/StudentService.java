package com.midzia.rest.service;

import com.midzia.rest.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent();

    void saveStudent(Student student);

    Student getStudentById(int id);

    void deleteStudent(int id);

    List<Student> getStudentByName(String name);

}
