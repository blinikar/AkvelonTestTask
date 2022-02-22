package com.blinikar.akvelon.API.projects;

import com.blinikar.akvelon.API.BaseResponse;
import com.blinikar.akvelon.database.projects.Project;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/project")
public class ProjectController {
    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCESS = 100;
    private static final int AUTH_FAILURE = 102;

    @GetMapping("/createNew")
    public BaseResponse createNew(@RequestBody ProjectCreateRequest request) {
        new Project(1000L,
                request.getName(),
                request.getStartDate(),
                request.getCompletionDate(),
                request.getPriority(),
                request.getStatus());
        return new BaseResponse(SUCCESS_STATUS, 1);
    }
}
