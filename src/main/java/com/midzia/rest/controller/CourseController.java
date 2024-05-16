package com.midzia.rest.controller;

import com.midzia.rest.entity.Course;
import com.midzia.rest.entity.Student;
import com.midzia.rest.service.CourseService;
import com.midzia.rest.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    CourseService courseService;

    StudentService studentService;

    public CourseController(CourseService courseService, StudentService studentService) {
        this.courseService = courseService;
        this.studentService = studentService;
    }

    @GetMapping
    public List<Course> showAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        return courses;
    }

    @GetMapping("/{id}")
    public Course showCourse(@PathVariable int id) {
        return courseService.getCourseById(id);
    }

    @GetMapping("/name/{name}")
    public Course showCourseByName(@PathVariable String name) {
        return courseService.getCourseByName(name);
    }

    @PostMapping
    public void addNewCourse(@RequestBody Course course) {
        courseService.saveCourse(course);
    }

    @PutMapping
    public void updateCourse(@RequestBody Course course) {
        courseService.saveCourse(course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
    }

    @DeleteMapping("/name/{name}")
    public void deleteCourse(@PathVariable String name) {
        courseService.deleteCourse(name);
    }

    @PutMapping("/name/{courseName}/students/{studentId}")
    public void addStudentToCourse(@PathVariable("courseName") String courseName,
                                   @PathVariable("studentId") int studentId) {
        Student student = studentService.getStudentById(studentId);
        Course course = courseService.getCourseByName(courseName);
        student.addCourseToStudent(course);
        studentService.saveStudent(student);
    }

    @DeleteMapping("/name/{courseName}/students/{studentId}")
    public void deleteStudentFromCourse(@PathVariable("courseName") String courseName,
                                        @PathVariable("studentId") int studentId) {
        Student student = studentService.getStudentById(studentId);
        Course course = courseService.getCourseByName(courseName);
        course.deleteStudentFromCourse(student);
        courseService.saveCourse(course);
    }
}
