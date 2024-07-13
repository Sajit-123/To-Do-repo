package com.ToDoManager.ToDoManagerApp.controllers;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;


import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ToDoManager.ToDoManagerApp.model.Tasks;
import com.ToDoManager.ToDoManagerApp.services.TaskService;





@Controller
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/ToDoPage/addTask")
    public String addTask(Model model){
        model.addAttribute("task", new Tasks());
        return "addTask";
    }
    
    @PostMapping("/ToDoPage/addTask")
    public String addingTasks(@RequestParam("taskName") String taskName,@RequestParam("taskDetails") String taskDetails,Tasks tasks){
        LocalDateTime now = LocalDateTime.now();  
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
        String formatDateTime = now.format(format);  
        tasks.setCreated_On(formatDateTime);
        tasks.setTask_name(taskName);
        tasks.setTaskDetail(taskDetails);
        taskService.addTask(tasks);
        return "redirect:/ToDoPage";
    }



    @GetMapping("/ToDoPage")
    public String loggedIn(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "ToDoPage";
    }

    @GetMapping("/ToDoPage/completed/{id}")
    public String taskCompleted(@PathVariable int id){
        Optional<Tasks> task = taskService.getTaskById(id);
        if(task.isPresent()){
            LocalDateTime now = LocalDateTime.now();  
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
            String formatDateTime = now.format(format);  
            task.get().setCompleted_On(formatDateTime);
            // taskService.delTaskById(id);
            taskService.addTask(task.get());
        } else {
            throw new UsernameNotFoundException(id + "not found");
        }
        return "redirect:/ToDoPage";
    }

    @GetMapping("/ToDoPage/delete/{id}")
    public String deleTask(@PathVariable int id){
        taskService.delTaskById(id);
        return "redirect:/ToDoPage";
    }
    @GetMapping("/ToDoPage/edit/{id}")
    public String editTask(@PathVariable int id,Model model){
        Optional<Tasks> task = taskService.getTaskById(id);
        if(task.isPresent()){
            model.addAttribute("task", task.get());
            return "addTask";
        }
        else{
            return "404";
        }
    }

}
