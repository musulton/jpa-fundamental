package com.enigma.repo.groupproject;

import com.enigma.model.GroupProject;
import com.enigma.repo.ifc.IGroupProject;
import com.enigma.repo.ifc.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class GroupProjectRepo extends Repository implements IGroupProject {
    public GroupProjectRepo(EntityManager em) {
        super(em);
    }

    @Override
    public void create(GroupProject groupProject) {
        inTransaction((em) -> {
            em.persist(groupProject);
        });
    }

    @Override
    public GroupProject findOne(long id) {
        return em.find(GroupProject.class, id);
    }

    @Override
    public List<GroupProject> findAll(int page, int pageSize) {
        TypedQuery<GroupProject> groupProjects = em.createQuery("select g from GroupProject g", GroupProject.class);

        groupProjects.setFirstResult((page - 1) * pageSize);
        groupProjects.setMaxResults(pageSize);

        return groupProjects.getResultList();
    }


}
