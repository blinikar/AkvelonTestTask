package com.blinikar.akvelon.API.tasks;

import com.blinikar.akvelon.TaskStatuses;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {

    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    String description;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    int priority;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    TaskStatuses status;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    Long projectId;
}