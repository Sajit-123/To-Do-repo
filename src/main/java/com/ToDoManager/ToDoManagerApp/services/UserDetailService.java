package com.ToDoManager.ToDoManagerApp.services;

import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ToDoManager.ToDoManagerApp.model.Users;
import com.ToDoManager.ToDoManagerApp.repositories.UserRepository;

@Service
public class UserDetailService implements UserDetailsService {

    private UserRepository userRepository;

    
    public UserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Users> user = userRepository.findUserByEmail(email);
        if(user.isPresent()){
            var userObj = user.get();
            return User.builder()
                    .username(userObj.getFirstName())
                    .password(userObj.getPassword())
                    .build();
        }
        else {
            throw new UsernameNotFoundException("no user found");
        }
    }

}
