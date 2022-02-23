package com.blinikar.akvelon.database.projects;

import com.blinikar.akvelon.ProjectStatuses;
import com.blinikar.akvelon.database.tasks.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "projects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;
    @Column
    private Date startDate;
    @Column
    private Date completionDate;
    @Column
    private int priority;
    @Column
    private ProjectStatuses status;

    @OneToMany
    private List<Task> tasks;
}
