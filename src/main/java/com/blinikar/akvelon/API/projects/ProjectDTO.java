package com.blinikar.akvelon.API.projects;

import com.blinikar.akvelon.ProjectStatuses;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {

    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    Date startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    Date completionDate;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    int priority;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    ProjectStatuses status;
}
