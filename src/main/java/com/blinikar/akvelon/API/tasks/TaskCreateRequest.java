package com.blinikar.akvelon.API.tasks;

import com.blinikar.akvelon.TaskStatuses;

public class TaskCreateRequest {

    private String name;
    private String description;
    private int priority;
    private TaskStatuses status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public TaskStatuses getStatus () {
        return status;
    }

    public void setStatus (TaskStatuses status) {
        this.status = status;
    }
}