package com.midzia.rest.dao;

import com.midzia.rest.entity.Course;

import java.util.List;

public interface CourseDao {
    List<Course> getAllCourses();

    void saveCourse(Course course);

    Course getCourseById(int id);

    void deleteCourse(int id);

    Course getCourseByName(String name);
}
