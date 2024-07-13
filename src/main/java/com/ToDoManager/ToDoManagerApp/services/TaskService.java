package com.ToDoManager.ToDoManagerApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ToDoManager.ToDoManagerApp.model.Tasks;
import com.ToDoManager.ToDoManagerApp.repositories.TaskRepository;


@Service
public class TaskService {

    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    public void addTask(Tasks tasks){
        taskRepository.save(tasks);
    }

    public List<Tasks> getAllTasks(){
        return taskRepository.findAll();
    }

    public void delTaskById(int id){
        taskRepository.deleteById(id);
    }
    public Optional<Tasks> getTaskById(int id){
        return taskRepository.findById(id);
    }

    // public List<Tasks> getAllTaskByUserId(){
    //     return taskRepository.findAllById();
    // }
}
