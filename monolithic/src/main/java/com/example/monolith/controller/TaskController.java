package com.example.monolith.controller;

import com.example.monolith.model.Task;
import com.example.monolith.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * TaskController.java
 * <p>
 * Description: Controller of the Task model
 *
 * @author aleja
 * @since 10/02/2026
 */

@Controller
public class TaskController {

    private TaskService taskService;


    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    ///Show all the tasks
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("tasks",this.taskService.getAllTasks());
        model.addAttribute("newTask",setnewTask());

        ///Refer to the index.html page of thymeleaf
        return "index";
    }

    ///AddTask
    @PostMapping("/add")
    public String addTask(@ModelAttribute Task task){
        this.taskService.addTask(task);

        //Cause a redirect to the / page
        return "redirect:/";
    }

    @PostMapping("/complete/{id}")
    public String completeTask(@PathVariable long id){
        this.taskService.completeTask(id);

        return "redirect:/";
    }

    ///Set default false value of complete
    private Task setnewTask(){
        Task newtask = new Task();
        newtask.setCompleted(false);
        return newtask;
    }
}
