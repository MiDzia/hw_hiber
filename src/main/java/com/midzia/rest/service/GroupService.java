package com.midzia.rest.service;

import com.midzia.rest.entity.Group;

import java.util.List;

public interface GroupService {

    List<Group> getAllGroups();

    Group getGroupById(int id);

    Group getGroupByName(String name);

    void saveGroup(Group group);

    void deleteGroup(int id);

}
