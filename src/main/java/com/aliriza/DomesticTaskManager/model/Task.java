package com.aliriza.DomesticTaskManager.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.SEQUENCE;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table
public class Task {

    @Id
    @SequenceGenerator(
            name = "task_sequence",
            sequenceName = "task_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "task_sequence"
    )

    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    private int GlobalId;

    @Column(
            name = "task_id",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private int TaskId;
    @Column(
            name = "title",
            nullable = false,
            columnDefinition = "TEXT"

    )
    private String title;
    @Column(
            name = "description",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String description;
    @Column(
            name = "start_date",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private LocalDateTime startDate;
    @Column(
            name = "stop_date",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private LocalDateTime stopDate;
    @Column(
            name = "type",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private Type type;
    @Column(
            name = "status",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private Status status;

    public Task(Long id,
                String title,
                String description,
                LocalDateTime stopDate,
                Type type,
                Status status){
        this.id = id;
        this.TaskId = ++GlobalId;
        this.title = title;
        this.description = description;
        this.stopDate = stopDate;
        this.type = type;
        this.status = status;
        this.startDate = LocalDateTime.now();
    }

}
