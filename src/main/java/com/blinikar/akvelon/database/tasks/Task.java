package com.blinikar.akvelon.database.tasks;

import com.blinikar.akvelon.TaskStatuses;
import com.blinikar.akvelon.database.projects.Project;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;
    @Column
    private String description;
    @Column
    private int priority;
    @Column
    private TaskStatuses status;
    @Column
    private Long projectId;
}
