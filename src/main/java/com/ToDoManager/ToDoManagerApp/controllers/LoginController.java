package com.ToDoManager.ToDoManagerApp.controllers;



import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ToDoManager.ToDoManagerApp.model.Users;
import com.ToDoManager.ToDoManagerApp.repositories.UserRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;


@Controller
public class LoginController {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public LoginController(UserRepository userRepository,BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @GetMapping("/")
    public String home(){
        return "index";
    }
    
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String registerGet(){
        return "register";
    }

    @PostMapping("/register")
    public String registrationPosat(@ModelAttribute("user") Users user,HttpServletRequest httpServletRequest) throws ServletException{
        String password = user.getPassword();
        user.setPassword(bCryptPasswordEncoder.encode(password));
        userRepository.save(user);
        httpServletRequest.login(user.getEmail(), password);
        return "redirect:/ToDoPage";
    }





}
