package com.ToDoManager.ToDoManagerApp.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;


import com.ToDoManager.ToDoManagerApp.model.Tasks;
import com.ToDoManager.ToDoManagerApp.model.Users;



public interface TaskRepository extends JpaRepository<Tasks,Integer> {
    List<Tasks> getAllTaskByfkUserId(Users user);

}
