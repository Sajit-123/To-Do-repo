package com.ToDoManager.ToDoManagerApp.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;


@Entity
@Data
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column(name = "user_id")
    private int id;

    @NotEmpty
    @Column(nullable = false)
    private String firstName;
    private String lastName;

    @NotEmpty
    @Column(nullable = false,unique=true)
    @Email(message = "{errors.invalid_email}")
    private String email;

    private String password;

    private Date dob;
    public Users(Users user) {
        
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.dob = user.getDob();
    }

    public Users(){

    }
}
