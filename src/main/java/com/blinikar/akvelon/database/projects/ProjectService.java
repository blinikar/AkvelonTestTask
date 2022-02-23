package com.blinikar.akvelon.database.projects;

import com.blinikar.akvelon.DatabaseException;
import com.blinikar.akvelon.database.tasks.Task;
import com.blinikar.akvelon.database.tasks.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;

    public ProjectService(ProjectRepository projectRepository, TaskRepository taskRepository) {
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
    }

    public void pushProject(Project project) {
        List<Task> tasks;

        if (project.getId() != null) {
            if (projectRepository.findById(project.getId()).isPresent()) {
                tasks = projectRepository.findById(project.getId()).get().getTasks();
                project.setTasks(tasks);
            }
        }

        projectRepository.save(project);
    }

    public void removeProject(Long id) throws DatabaseException {
        List<Task> tasks;

        if (findById(id) != null) {
            tasks = findById(id).getTasks();

            projectRepository.delete(findById(id));

            taskRepository.deleteAll(tasks);

        } else throw new DatabaseException();
    }

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public Project findById(Long id) {
        if (projectRepository.findById(id).isPresent()) return projectRepository.findById(id).get();

        return null;
    }

    public void addTaskToProject(Task task) throws DatabaseException {
        Project project = findById(task.getProjectId());
        if (project == null) throw new DatabaseException();

        List<Task> tasks = project.getTasks();

        tasks.add(task);
        project.setTasks(tasks);
    }

    public void removeTaskFromProject(Task task) throws DatabaseException {
        Project project = findById(task.getProjectId());
        if (project == null) throw new DatabaseException();

        List<Task> tasks = project.getTasks();

        tasks.remove(task);
        project.setTasks(tasks);
    }
}
