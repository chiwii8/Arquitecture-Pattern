package com.example.soa.controller;

import com.example.soa.esb.OrchestrationService;
import com.example.soa.model.Task;
import com.example.soa.model.TaskWithUser;
import com.example.soa.model.User;
import org.springframework.web.bind.annotation.*;

/**
 * SoaController.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 12/02/2026
 */

@RestController
@RequestMapping("/soa")
public class SoaController {
    private final OrchestrationService orchestrationService;

    public SoaController(OrchestrationService orchestrationService) {
        this.orchestrationService = orchestrationService;
    }

    @GetMapping("/task/{id}")
    public TaskWithUser getTaskWithUser(@PathVariable long id){
        return this.orchestrationService.getTaskWithUser(id);
    }

    @PostMapping("/users-with-task")
    public void createUserWithTask(@RequestBody User user,
                                   @RequestParam String taskTitle) {

        Task task = new Task(taskTitle,false,user.getId());

        this.orchestrationService.createUserWithTask(user, task);
    }
}
