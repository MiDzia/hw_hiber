package com.midzia.rest.dao;

import com.midzia.rest.entity.Group;

import java.util.List;

public interface GroupDao {
    List<Group> getAllGroup();

    Group getGroupById(int id);

    void saveGroup(Group group);

    void deleteGroup(int id);

    Group getGroupByName(String name);

}
