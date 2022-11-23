package com.enigma.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "m_group_project")
public class GroupProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private long projectId;
    @Column(name = "project_name", nullable = false, length = 50)
    private String projectName;
    @ManyToMany(mappedBy = "groupProjects")
    private List<GroupProjectWithPoint> projectWithPoints = new ArrayList<>();

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

    @Override
    public String toString() {
        return "GroupProject{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", projectWithPoints=" + projectWithPoints +
                '}';
    }

    public List<GroupProjectWithPoint> getProjectWithPoints() {
        return projectWithPoints;
    }

    public void setProjectWithPoints(List<GroupProjectWithPoint> projectWithPoints) {
        this.projectWithPoints = projectWithPoints;
    }
}
