package com.ToDoManager.ToDoManagerApp.model;

// import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
// import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String task_name;

    private String taskDetail;

    private String Created_On;

    private String Completed_On;

    // @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    // @JoinColumn(name = "users_id", referencedColumnName = "user_id") 
    // private Users users;

}
