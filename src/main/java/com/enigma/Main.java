package com.enigma;

import com.enigma.model.Student;
import com.enigma.model.UserCredential;
import com.enigma.repo.auth.AuthRepo;
import com.enigma.repo.student.StudentRepo;
import com.enigma.service.Factory;
import com.enigma.utils.Gender;
import com.enigma.utils.GenerateDate;
import jakarta.persistence.*;

public class Main {
    public static void main(String[] args) {
        EntityManager em = Factory.connect();
        StudentRepo studentRepo = new StudentRepo(em);

        UserCredential userCredential = new UserCredential();
        userCredential.setUsername("musulton");
        userCredential.setPassword("indonesia");

        Student student = new Student();
        student.setFirstName("Siti");
        student.setLastName("Sofiah");
        student.setGender(Gender.FEMALE);
        student.setBirthDate(GenerateDate.generate("2002-04-02"));
        student.setMajor("Design");
        student.setUserCredential(userCredential);
        studentRepo.create(student);

    }

}