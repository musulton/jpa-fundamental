package com.enigma.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class GroupProjectKey implements Serializable {
    @Column(name = "student_id")
    long studentId;
    @Column(name = "project_id")
    long projectId;

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return "GroupProjectKey{" +
                "studentId=" + studentId +
                ", projectId=" + projectId +
                '}';
    }
}
