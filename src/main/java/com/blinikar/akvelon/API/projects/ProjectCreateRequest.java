package com.blinikar.akvelon.API.projects;

import com.blinikar.akvelon.ProjectStatuses;

public class ProjectCreateRequest {

    private String name;
    private int startDate;
    private int completionDate;
    private int priority;
    private ProjectStatuses status;

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
