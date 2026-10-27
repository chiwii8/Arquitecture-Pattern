package com.example.soa.services.task;

import com.example.soa.model.Task;
import com.example.soa.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TaskService.java
 * <p>
 * Description: Implementation service of the task model.
 *
 * @author aleja
 * @since 12/02/2026
 */

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task getTaskById(long id){
        return this.taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public void createTask(Task task){
        this.taskRepository.save(task);
    }

    public List<Task> getTasksByUser(long userId){
        return this.taskRepository.findByUserId(userId);
    }
}