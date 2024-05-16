package com.midzia.rest.service;

import com.midzia.rest.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();

    Course getCourseById(int id);

    Course getCourseByName(String name);

    void saveCourse(Course course);

    void deleteCourse(int id);

    void deleteCourse(String name);
}
