package com.example.soa.esb;

import com.example.soa.model.Task;
import com.example.soa.model.TaskWithUser;
import com.example.soa.model.User;
import com.example.soa.services.task.TaskService;
import com.example.soa.services.user.UserService;
import org.springframework.stereotype.Service;

/**
 * OrchestrationService.java
 * <p>
 * Description: Centralizes the orchestration of business processes.
 *
 *  The service remain simple and focused on a single responsibility
 *  Business workflows are defined in one place, making them easier to control and govern
 *
 * @author aleja
 * @since 12/02/2026
 */

@Service
public class OrchestrationService {
    private final UserService userService;
    private final TaskService taskService;

    public OrchestrationService(UserService userService, TaskService taskService) {
        this.userService = userService;
        this.taskService = taskService;
    }

    public TaskWithUser getTaskWithUser(Long taskId){

        ///Get task information
        Task task = this.taskService.getTaskById(taskId);

        ///Get user information related to the task
        User user = this.userService.getUserbyId(task.getUserId());

        ///Orchestrate the response
        return new TaskWithUser(task,user);
    }

    public void createUserWithTask(User user, Task task) {
        userService.createUser(user);
        taskService.createTask(task);
    }
}
