package com.ToDoManager.ToDoManagerApp.model;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    private String task_name;

    private String taskDetail;

    private String Created_On;

    private String Completed_On;

    @ManyToOne(targetEntity = Users.class)
    @JoinColumn(referencedColumnName = "user_id")
    private Users fkUserId;

}
