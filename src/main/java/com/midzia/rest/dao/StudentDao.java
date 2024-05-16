package com.midzia.rest.dao;

import com.midzia.rest.entity.Student;

import java.util.List;

public interface StudentDao {
    List<Student> getAllStudent();

    void saveStudent(Student student);

    Student getStudentById(int id);

    void deleteStudent(int id);

    List<Student> getStudentByName(String name);
}
