package com.enigma.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "m_group_project")
public class GroupProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long projectId;
    @Column(name = "project_name", nullable = false, length = 50)
    private String projectName;
    @ManyToMany(mappedBy = "groupProjects")
    private List<Student> students = new ArrayList<>();

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "GroupProject{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", students=" + students +
                '}';
    }
}
