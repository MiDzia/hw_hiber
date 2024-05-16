package com.midzia.rest.controller;

import com.midzia.rest.entity.Group;
import com.midzia.rest.service.GroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
public class GroupController {

    GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public List<Group> showAllGroups() {
        return groupService.getAllGroups();
    }

    @GetMapping("/{id}")
    public Group showGroupById(@PathVariable int id) {
        return groupService.getGroupById(id);
    }

    @GetMapping("/name/{name}")
    public Group showGroupByName(@PathVariable String name) {
        return groupService.getGroupByName(name);
    }

    @PostMapping
    public Group addNewGroup(@RequestBody Group group) {
        groupService.saveGroup(group);
        return group;
    }

    @PutMapping
    public Group updateGroup(@RequestBody Group group) {
        groupService.saveGroup(group);
        return group;
    }

    @DeleteMapping("/{id}")
    public void deleteGroup(@PathVariable int id) {
        groupService.deleteGroup(id);
    }

    @DeleteMapping("/name/{name}")
    public void deleteGroup(@PathVariable String name) {
        Group group = groupService.getGroupByName(name);
        groupService.deleteGroup(group.getId());
    }
}
