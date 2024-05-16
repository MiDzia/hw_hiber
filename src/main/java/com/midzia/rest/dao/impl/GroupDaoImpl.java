package com.midzia.rest.dao.impl;

import com.midzia.rest.dao.GroupDao;
import com.midzia.rest.entity.Group;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class GroupDaoImpl implements GroupDao {

    private final SessionFactory sessionFactory;

    public GroupDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Group> getAllGroup() {
        Session session = sessionFactory.getCurrentSession();
        Query<Group> query = session.createQuery("FROM Group", Group.class);
        List<Group> groups = query.getResultList();
        return groups;
    }

    @Override
    public Group getGroupById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.find(Group.class, id);
    }

    @Override
    public void saveGroup(Group group) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(group);

    }

    @Override
    public void deleteGroup(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("DELETE FROM Group g WHERE g.id = :groupId")
                .setParameter("groupId", id).executeUpdate();
    }

    @Override
    public Group getGroupByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Group> query = session.createQuery("FROM Group g where g.name= :groupName", Group.class)
                .setParameter("groupName", name);
        return query.getSingleResult();
    }
}
