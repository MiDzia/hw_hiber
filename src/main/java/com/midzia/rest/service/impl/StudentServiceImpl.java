package com.midzia.rest.service.impl;

import com.midzia.rest.dao.StudentDao;
import com.midzia.rest.entity.Student;
import com.midzia.rest.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    @Transactional
    public List<Student> getAllStudent() {
        List<Student> students = studentDao.getAllStudent();
        for (Student student : students) {
            student.setGroupName(student.getGroup().getName());
        }
        return students;
    }

    @Override
    @Transactional
    public void saveStudent(Student student) {
        studentDao.saveStudent(student);
    }

    @Override
    @Transactional
    public Student getStudentById(int id) {
        Student student = studentDao.getStudentById(id);
        student.setGroupName(student.getGroup().getName());
        return student;
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        studentDao.deleteStudent(id);
    }

    @Override
    @Transactional
    public List<Student> getStudentByName(String name) {
        List<Student> students = studentDao.getStudentByName(name);
        for (Student student:students){
            student.setGroupName(student.getGroup().getName());
        }
        return students;
    }

}
