package com.enigma.repo.major;

import com.enigma.model.Major;
import com.enigma.repo.ifc.Repository;
import jakarta.persistence.EntityManager;

public class MajorRepo extends Repository implements IMajor {
    public MajorRepo(EntityManager em) {
        super(em);
    }

    @Override
    public void create(Major major) {
        inTransaction((em) -> {
            em.persist(major);
        });
    }

    @Override
    public Major findOne(long id) {
        return em.find(Major.class, id);
    }
}
