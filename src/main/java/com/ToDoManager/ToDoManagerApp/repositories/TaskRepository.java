package com.ToDoManager.ToDoManagerApp.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.ToDoManager.ToDoManagerApp.model.Tasks;


public interface TaskRepository extends JpaRepository<Tasks,Integer> {
    
}
