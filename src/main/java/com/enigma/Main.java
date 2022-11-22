package com.enigma;

import com.enigma.model.Student;
import com.enigma.repo.student.StudentRepo;
import com.enigma.service.Factory;
import com.enigma.utils.Gender;
import com.enigma.utils.GenerateDate;
import jakarta.persistence.*;

public class Main {
    public static void main(String[] args) {
        EntityManager em = Factory.connect();

        Student student1 = new Student();
        student1.setFirstName("Siti");
        student1.setLastName("Sofiah");
        student1.setGender(Gender.FEMALE);
        student1.setBirthDate(GenerateDate.generate("2002-04-02"));
        student1.setMajor("Design");

        StudentRepo sRepo = new StudentRepo(em);
        sRepo.create(student1);
    }


}