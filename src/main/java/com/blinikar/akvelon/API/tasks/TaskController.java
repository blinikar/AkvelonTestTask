package com.blinikar.akvelon.API.tasks;

import com.blinikar.akvelon.DatabaseException;
import com.blinikar.akvelon.database.tasks.Task;
import com.blinikar.akvelon.database.tasks.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;
    private final ModelMapper modelMapper;

    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";

    public TaskController(TaskService taskService, ModelMapper modelMapper) {
        this.taskService = taskService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/getAll")
    public List<TaskDTO> getAll() {
        List<TaskDTO> taskDTOs = new ArrayList<>();
        List<Task> tasks = taskService.findAll();

        tasks.forEach((Task task) -> taskDTOs.add(modelMapper.map(task, TaskDTO.class)));

        return taskDTOs;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> get(@PathVariable("id") Long id) {
        if (taskService.findById(id) != null) {
            return ResponseEntity.ok(modelMapper.map(taskService.findById(id), TaskDTO.class));
        } else return ResponseEntity.notFound().build();
    }

    /**
     * Pushes task into the repository. If task already exist changes it (by id,
     * if ID is null creates new task).
     */
    @PutMapping("/push")
    public ResponseEntity<TaskDTO> createNew(@RequestBody TaskDTO taskDto) {
        Task task = modelMapper.map(taskDto, Task.class);

        try {
            taskService.pushTask(task);
        } catch (DatabaseException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(taskDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        try {
            taskService.removeTask(id);
        } catch (DatabaseException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(SUCCESS_STATUS);
    }
}
