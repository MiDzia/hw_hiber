package com.midzia.rest.dao.impl;

import com.midzia.rest.dao.CourseDao;
import com.midzia.rest.entity.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CourseDaoImpl implements CourseDao {

    private final SessionFactory sessionFactory;

    public CourseDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Course> getAllCourses() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Course c", Course.class).getResultList();

    }

    @Override
    public void saveCourse(Course course) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(course);
    }

    @Override
    public Course getCourseById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Course.class, id);
    }

    @Override
    public void deleteCourse(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("DELETE FROM Course WHERE id = :courseId")
                .setParameter("courseId", id)
                .executeUpdate();
    }

    @Override
    public Course getCourseByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Course> query = session.createQuery("FROM Course c where c.name= :courseName", Course.class)
                .setParameter("courseName", name);
        return query.getSingleResult();
    }
}
