package com.enigma.repo.student;

import com.enigma.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.function.Consumer;

public class StudentRepo implements IStudentRepo {
    EntityManager em;

    public StudentRepo(EntityManager em) {
        this.em = em;
    }

    private void inTransaction(Consumer<EntityManager> consumer) {
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

    public void create(Student student) {
        inTransaction(em -> {
            em.persist(student);
        });
    }

    public Student findOne(long id) {
        return em.find(Student.class, id);
    }

    /*
    Cara kedua untuk mendapatkan 1 data

    public Student findOne(long id) {
        TypedQuery<Student> typedQuery
                = em.createNamedQuery("Student.findById", Student.class);
        typedQuery.setParameter("id", id);
        return typedQuery.getSingleResult();
    }
     */

    public void update(Student student) {
        inTransaction(em -> {
            em.merge(student);
        });
    }

    public List<Student> findAll(int page, int pageSize) {
        TypedQuery<Student> students = em.createNamedQuery("Student.findAll", Student.class);

        students.setFirstResult((page - 1) * pageSize);
        students.setMaxResults(pageSize);

        return students.getResultList();
    }

    void delete(int id) {
        em.getTransaction().begin();

        Student s = findOne(id);

        em.remove(s);
        em.getTransaction().commit();
    }
}
