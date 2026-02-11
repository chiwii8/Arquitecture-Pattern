package com.example.task_service.controller;

import com.example.task_service.client.UserServiceClient;
import com.example.task_service.dto.UserDto;
import com.example.task_service.model.Task;
import com.example.task_service.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TaskController.java
 * <p>
 * Description: Controller of the Task model
 *
 * @author aleja
 * @since 11/02/2026
 */

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTasks(){
        return this.taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable long id){
        return this.taskService.getTask(id);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task){
        return this.taskService.addTask(task);
    }

    @GetMapping("/{id}/completed")
    public Task completeTask(@PathVariable long id){
        return this.taskService.completeTask(id);
    }

    @GetMapping("/users")
    public List<UserDto> getUsers(){
        return taskService.getUsersFromUserService();
    }


}
