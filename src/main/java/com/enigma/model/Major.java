package com.enigma.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "m_major")
public class Major {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "major_id")
    private long majordId;
    @Column(name = "major_name")
    private String majorName;
    @OneToMany(mappedBy = "major")
    private List<Student> studentList;

    public long getMajordId() {
        return majordId;
    }

    public void setMajordId(long majordId) {
        this.majordId = majordId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Major{" +
                "majordId=" + majordId +
                ", majorName='" + majorName + '\'' +
                '}';
    }
}
