package com.enigma.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_credential")
public class UserCredential {
    @Id
    @Column(name = "username")
    private String username;
    @Column(nullable = false)
    private String password;
    @OneToOne(mappedBy = "userCredential")
    Student student;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
