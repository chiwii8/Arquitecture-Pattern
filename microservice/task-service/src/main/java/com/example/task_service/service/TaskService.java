package com.example.task_service.service;

import com.example.task_service.client.UserServiceClient;
import com.example.task_service.dto.UserDto;
import com.example.task_service.model.Task;
import com.example.task_service.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

/**
 * TaskService.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 11/02/2026
 */

@Service
public class TaskService {
    private TaskRepository taskRepository;
    private final UserServiceClient userClient;

    public TaskService(UserServiceClient userClient, TaskRepository taskRepository) {
        this.userClient = userClient;
        this.taskRepository = taskRepository;
    }

    ///Return all the tasks
    public List<Task> getAllTasks(){
        return this.taskRepository.findAll();
    }

    public Task getTask(long id){

        Optional<Task> optionalTask = this.taskRepository.findById(id);
        return optionalTask.orElseGet(Task::new);
    }

    ///Basic Verification and add a new task
    ///Default value of completed is false
    public Task addTask(Task task){
        Assert.notNull(task.getTitle(),"The title cannot be null");
        Assert.hasText(task.getTitle(),"The title cannot be empty");

        return this.taskRepository.save(task);
    }

    public Task completeTask(long id){
        Optional<Task> optionalTask = this.taskRepository.findById(id);

        if(optionalTask.isPresent()){
            Task task = optionalTask.get();
            task.setCompleted(true);
            return this.taskRepository.save(task);
        }

        return new Task();
    }

    public List<UserDto> getUsersFromUserService(){
        return userClient.getUsers();
    }
}
