package com.enigma.repo.ifc;

import com.enigma.model.GroupProject;

import java.util.List;

public interface IGroupProject {
    void create(GroupProject groupProject);
    GroupProject findOne(long id);
    List<GroupProject> findAll(int page, int pageSize);
}
