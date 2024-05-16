package com.midzia.rest.service.impl;

import com.midzia.rest.dao.GroupDao;
import com.midzia.rest.entity.Group;
import com.midzia.rest.service.GroupService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    GroupDao groupDao;

    public GroupServiceImpl(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @Override
    @Transactional
    public List<Group> getAllGroups() {
        return groupDao.getAllGroup();
    }

    @Override
    @Transactional
    public Group getGroupById(int id) {
        return groupDao.getGroupById(id);
    }

    @Override
    @Transactional
    public Group getGroupByName(String name) {
        return groupDao.getGroupByName(name);
    }

    @Override
    @Transactional
    public void saveGroup(Group group) {
        groupDao.saveGroup(group);
    }

    @Override
    @Transactional
    public void deleteGroup(int id) {
        groupDao.deleteGroup(id);
    }
}
