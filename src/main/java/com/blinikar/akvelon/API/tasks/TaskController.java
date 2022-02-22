package com.blinikar.akvelon.API.tasks;

import com.blinikar.akvelon.API.BaseResponse;
import com.blinikar.akvelon.database.tasks.Task;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {

    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCESS = 100;
    private static final int AUTH_FAILURE = 102;

    @GetMapping("/createNew")
    public BaseResponse createNew(@RequestBody TaskCreateRequest request) {
        new Task(1000L,
                request.getName(),
                request.getDescription(),
                request.getPriority(),
                request.getStatus());
        return new BaseResponse(SUCCESS_STATUS, 1);
    }
}
