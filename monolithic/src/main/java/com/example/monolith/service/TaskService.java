package com.example.monolith.service;

import com.example.monolith.model.Task;
import com.example.monolith.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

/**
 * TaskService.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 10/02/2026
 */

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    ///Return all the tasks
    public List<Task> getAllTasks(){
        List<Task> tasks = this.taskRepository.findAll();
        return tasks;
    }

    public Task getTask(long id){

        Optional<Task> optionalTask = this.taskRepository.findById(id);
        return optionalTask.orElseGet(Task::new);
    }

    ///Basic Verification and add a new task
    ///Default value of completed is false
    public void addTask(Task task){
        Assert.notNull(task.getTitle(),"The title cannot be null");
        Assert.hasText(task.getTitle(),"The title cannot be empty");

        this.taskRepository.save(task);
    }

    public void completeTask(long id){
        Optional<Task> optionalTask = this.taskRepository.findById(id);

        if(optionalTask.isPresent()){
            Task task = optionalTask.get();
            task.setCompleted(true);
            this.taskRepository.save(task);
        }
    }
}
