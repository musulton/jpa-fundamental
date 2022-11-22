package com.enigma;

import com.enigma.model.Major;
import com.enigma.model.Student;
import com.enigma.model.UserCredential;
import com.enigma.repo.auth.AuthRepo;
import com.enigma.repo.ifc.IAuth;
import com.enigma.repo.ifc.IStudent;
import com.enigma.repo.major.IMajor;
import com.enigma.repo.major.MajorRepo;
import com.enigma.repo.student.StudentRepo;
import com.enigma.service.Factory;
import com.enigma.utils.Gender;
import com.enigma.utils.GenerateDate;
import jakarta.persistence.*;

public class Main {
    public static void main(String[] args) {
        EntityManager em = Factory.connect();
        IStudent studentRepo = new StudentRepo(em);
        IMajor majorRepo = new MajorRepo(em);

        Major major = new Major();
        major.setMajorName("Informatics");
        majorRepo.create(major);

        UserCredential userCredential = new UserCredential();
        userCredential.setUsername("musulton");
        userCredential.setPassword("indonesia");

        Student student = new Student();
        student.setFirstName("Siti");
        student.setLastName("Sofiah");
        student.setGender(Gender.FEMALE);
        student.setBirthDate(GenerateDate.generate("2002-04-02"));

        student.setUserCredential(userCredential);
        userCredential.setStudent(student);

        student.setMajor(major);

        studentRepo.create(student);
        System.out.println(student);
    }

}