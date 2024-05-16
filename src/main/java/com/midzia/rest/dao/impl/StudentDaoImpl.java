package com.midzia.rest.dao.impl;

import com.midzia.rest.dao.StudentDao;
import com.midzia.rest.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    private final SessionFactory sessionFactory;

    public StudentDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Student> getAllStudent() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT DISTINCT s FROM Student s LEFT JOIN FETCH s.courses LEFT JOIN FETCH s.group";
        Query<Student> query = session.createQuery(hql, Student.class);
        List<Student> students = query.getResultList();
        return students;
    }

    @Override
    public void saveStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(student);
    }

    @Override
    public Student getStudentById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Student.class, id);
    }

    @Override
    public void deleteStudent(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("DELETE FROM Student WHERE id = :studentId")
                .setParameter("studentId", id)
                .executeUpdate();
    }

    @Override
    public List<Student> getStudentByName(String nameSt) {
        Session session = sessionFactory.getCurrentSession();
        List<Student> students = session.createQuery("FROM Student s where s.name= :studentName")
                .setParameter("studentName", nameSt).getResultList();
        return students;
    }

}
