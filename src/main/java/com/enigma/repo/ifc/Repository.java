package com.enigma.repo.ifc;

import jakarta.persistence.EntityManager;

import java.util.function.Consumer;

public abstract class Repository {
    public EntityManager em;

    public Repository(EntityManager em) {
        this.em = em;
    }

    protected void inTransaction(Consumer<EntityManager> consumer) {
        try {
            em.getTransaction().begin();
            consumer.accept(em);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        } finally {
            em.close();
        }
    }
}
