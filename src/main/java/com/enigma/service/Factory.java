package com.enigma.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Factory {
    private static EntityManagerFactory emf;
    private static final String PERSISTENCE_UNIT_NAME = "Student";

    private static void getEntityManagerFactory() {
        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public static EntityManager connect() {
        if (emf == null) {
            getEntityManagerFactory();
        }

        return emf.createEntityManager();
    }

    public static void shutdown() {
        if (emf != null) {
            emf.close();
        }
    }
}
