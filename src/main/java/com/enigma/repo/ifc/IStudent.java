package com.enigma.repo.ifc;

import com.enigma.model.Student;

import java.util.List;

public interface IStudent {
    void create(Student student);
    Student findOne(long id);
    List<Student> findAll(int page, int pageSize);
    void update(Student student);
}
