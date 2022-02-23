package com.blinikar.akvelon.database.tasks;

import com.blinikar.akvelon.DatabaseException;
import com.blinikar.akvelon.database.projects.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final ProjectService projectService;

    public TaskService(TaskRepository taskRepository, ProjectService projectService) {
        this.taskRepository = taskRepository;
        this.projectService = projectService;
    }

    public void pushTask(Task task) throws DatabaseException {
        projectService.removeTaskFromProject(task);
        projectService.addTaskToProject(task);
        taskRepository.save(task);
    }

    public void removeTask(Long id) throws DatabaseException {
        Task task;
        if (findById(id) != null) task = findById(id);
        else throw new DatabaseException();
        projectService.removeTaskFromProject(task);
        taskRepository.delete(task);
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findById (Long id) {
        if (taskRepository.findById(id).isPresent()) return taskRepository.findById(id).get();

        return null;
    }
}
