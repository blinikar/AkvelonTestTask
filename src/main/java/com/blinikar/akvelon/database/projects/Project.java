package com.blinikar.akvelon.database.projects;

import com.blinikar.akvelon.ProjectStatuses;

import javax.persistence.*;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;
    @Column
    private int startDate;
    @Column
    private int completionDate;
    @Column
    private int priority;
    @Column
    private ProjectStatuses status;

    public Project() {
    }

    public Project(Long id, String name, int startDate, int completionDate, int priority, ProjectStatuses status) {

        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.completionDate = completionDate;
        this.priority = priority;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public int getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(int completionDate) {
        this.completionDate = completionDate;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public ProjectStatuses getStatus() {
        return status;
    }

    public void setStatus(ProjectStatuses status) {
        this.status = status;
    }
}
