package com.example.todo_list.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tasks")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

//    @Column(name = "task_number")
//    private int taskNumber;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(name = "body")
    private String body;

}
