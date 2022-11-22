package com.enigma.repo.student;

import com.enigma.model.Student;
import com.enigma.repo.ifc.IStudent;
import com.enigma.repo.ifc.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class StudentRepo extends Repository implements IStudent {
    public StudentRepo(EntityManager em) {
        super(em);
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
