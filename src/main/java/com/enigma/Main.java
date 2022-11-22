package com.enigma;

import com.enigma.model.GroupProject;
import com.enigma.model.Major;
import com.enigma.model.Student;
import com.enigma.model.UserCredential;
import com.enigma.repo.groupproject.GroupProjectRepo;
import com.enigma.repo.ifc.IGroupProject;
import com.enigma.repo.ifc.IStudent;
import com.enigma.repo.ifc.IMajor;
import com.enigma.repo.major.MajorRepo;
import com.enigma.repo.student.StudentRepo;
import com.enigma.service.Factory;
import com.enigma.utils.Gender;
import com.enigma.utils.GenerateDate;
import jakarta.persistence.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManager em = Factory.connect();
        IStudent studentRepo = new StudentRepo(em);
        IMajor majorRepo = new MajorRepo(em);
        IGroupProject groupRepo = new GroupProjectRepo(em);

        GroupProject groupProject = groupRepo.findOne(1);
        Major major = majorRepo.findOne(1);

        UserCredential userCredential = new UserCredential();
        userCredential.setUsername("sofiah");
        userCredential.setPassword("indonesia");

        Student student = new Student();
        student.setFirstName("Muhammad");
        student.setLastName("Sulton");
        student.setGender(Gender.MALE);
        student.setBirthDate(GenerateDate.generate("1995-07-25"));

        student.getGroupProjects().add(groupProject);

        student.setUserCredential(userCredential);
        userCredential.setStudent(student);

        student.setMajor(major);

        studentRepo.create(student);

        GroupProject otherProject = new GroupProject();
        otherProject.setProjectName("Sales Pintar");
        groupRepo.create(otherProject);

        List<Student> student2 = studentRepo.findAll(1,2);
        for (Student s: student2) {
            System.out.println(s);
        }

        List<GroupProject> groupProjects = groupRepo.findAll(1, 2);
        for (GroupProject g: groupProjects) {
            System.out.println(g);
        }
    }

}