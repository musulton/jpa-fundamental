package com.enigma.repo.auth;

import com.enigma.model.UserCredential;
import com.enigma.repo.ifc.IAuth;
import com.enigma.repo.ifc.Repository;
import jakarta.persistence.EntityManager;

public class AuthRepo extends Repository implements IAuth {
    public AuthRepo(EntityManager em) {
        super(em);
    }

    @Override
    public void create(UserCredential userCredential) {
        inTransaction(em -> {
            em.persist(userCredential);
        });
    }

    @Override
    public UserCredential findOne(String id) {
        return em.find(UserCredential.class, id);
    }
}
