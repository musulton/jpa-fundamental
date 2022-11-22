package com.enigma.repo.student;

import com.enigma.model.Student;

import java.util.List;

public interface IStudentRepo {
    void create(Student student);
    Student findOne(long id);
    List<Student> findAll(int page, int pageSize);
    void update(Student student);
}
