package com.ToDoManager.ToDoManagerApp.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ToDoManager.ToDoManagerApp.model.Users;
import com.ToDoManager.ToDoManagerApp.repositories.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<Users> getUserById(int id){
        return userRepository.findById(id);
    }
}
