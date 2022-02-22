package com.blinikar.akvelon.API.projects;

import com.blinikar.akvelon.API.tasks.TaskDTO;
import com.blinikar.akvelon.DatabaseException;
import com.blinikar.akvelon.database.projects.Project;
import com.blinikar.akvelon.database.projects.ProjectService;
import com.blinikar.akvelon.database.tasks.Task;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService projectService;
    private final ModelMapper modelMapper;

    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";

    public ProjectController(ProjectService projectService, ModelMapper modelMapper) {
        this.projectService = projectService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/getAll")
    public List<ProjectDTO> getAll() {
        List<ProjectDTO> projectDTOs = new ArrayList<>();
        List<Project> projects = projectService.findAll();

        projects.forEach((Project project) -> projectDTOs.add(modelMapper.map(project, ProjectDTO.class)));

        return projectDTOs;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDTO> get(@PathVariable("id") Long id) {
        if (projectService.findById(id) != null) {
            return ResponseEntity.ok(modelMapper.map(projectService.findById(id), ProjectDTO.class));
        } else return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/getTasks")
    public ResponseEntity<List<TaskDTO>> getTasks(@PathVariable("id") Long id) {
        if (projectService.findById(id) != null) {
            Project project = projectService.findById(id);
            List<Task> tasks = project.getTasks();
            List<TaskDTO> taskDTOs = new ArrayList<>();

            tasks.forEach((Task t) -> taskDTOs.add(modelMapper.map(t, TaskDTO.class)));

            return ResponseEntity.ok(taskDTOs);
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/push")
    public ResponseEntity<ProjectDTO> createNew(@RequestBody ProjectDTO projectDto) {
        projectService.pushProject(modelMapper.map(projectDto, Project.class));
        return ResponseEntity.ok(projectDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        try {
            projectService.removeProject(id);
        } catch (DatabaseException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(SUCCESS_STATUS);
    }
}
