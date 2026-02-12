package com.example.soa.model;

import jakarta.persistence.*;

/**
 * Task.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 12/02/2026
 */

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private boolean isComplete;

    @Column(name = "user_id")
    private long userId;

    public Task() {
    }

    public Task(String title, boolean isComplete, long userId) {
        this.title = title;
        this.isComplete = isComplete;
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public long getUserId() {
        return userId;
    }
}
