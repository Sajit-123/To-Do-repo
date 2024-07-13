package com.ToDoManager.ToDoManagerApp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ToDoManager.ToDoManagerApp.model.Users;

public interface UserRepository extends JpaRepository<Users,Integer>{
    Optional<Users> findUserByEmail(String email);
}
