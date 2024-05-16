package com.midzia.rest.service.impl;

import com.midzia.rest.dao.CourseDao;
import com.midzia.rest.entity.Course;
import com.midzia.rest.service.CourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    CourseDao courseDao;

    public CourseServiceImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    @Transactional
    public List<Course> getAllCourses() {
        return courseDao.getAllCourses();
    }

    @Override
    @Transactional
    public Course getCourseById(int id) {
        return courseDao.getCourseById(id);
    }

    @Override
    @Transactional
    public Course getCourseByName(String name) {
        return courseDao.getCourseByName(name);
    }

    @Override
    @Transactional
    public void saveCourse(Course course) {
        courseDao.saveCourse(course);
    }

    @Override
    @Transactional
    public void deleteCourse(int id) {
        courseDao.deleteCourse(id);
    }

    @Override
    @Transactional
    public void deleteCourse(String name) {
        Course course = courseDao.getCourseByName(name);
        courseDao.deleteCourse(course.getId());
    }
}
