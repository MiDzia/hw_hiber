package com.midzia.rest.controller;

import com.midzia.rest.entity.Group;
import com.midzia.rest.entity.Student;
import com.midzia.rest.service.CourseService;
import com.midzia.rest.service.GroupService;
import com.midzia.rest.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    StudentService studentService;

    GroupService groupService;

    CourseService courseService;

    public StudentController(StudentService studentService, GroupService groupService, CourseService courseService) {
        this.studentService = studentService;
        this.groupService = groupService;
        this.courseService = courseService;
    }

    @GetMapping
    public List<Student> showAllStudents() {
        List<Student> students = studentService.getAllStudent();
        return students;
    }

    @GetMapping("/{id}")
    public Student showStudent(@PathVariable int id) {
        Student student = studentService.getStudentById(id);
        return student;
    }

    @GetMapping("/name/{name}")
    public List<Student> showStudentByName(@PathVariable String name) {
        List<Student> students = studentService.getStudentByName(name);
        return students;
    }

    @PostMapping
    public Student addNewStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return student;
    }

    @PutMapping
    public Student updateStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return student;
    }

    @PutMapping("/{studentId}/groups/name/{groupName}")
    public void addStudentToGroup(@PathVariable("studentId") int studentId,
                                  @PathVariable("groupName") String groupName) {
        Student student = studentService.getStudentById(studentId);
        Group group = groupService.getGroupByName(groupName);
        student.setGroup(group);
        studentService.saveStudent(student);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return "Student with id = " + id + " was deleted";
    }

}
