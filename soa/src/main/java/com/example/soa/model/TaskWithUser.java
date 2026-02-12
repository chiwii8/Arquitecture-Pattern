package com.example.soa.model;

/**
 * TaskWithUser.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 12/02/2026
 */

public class TaskWithUser {

    private Task task;
    private User user;


    public TaskWithUser() {
    }

    public TaskWithUser(Task task, User user) {
        this.task = task;
        this.user = user;
    }

    public Task getTask() {
        return task;
    }

    public User getUser() {
        return user;
    }
}
