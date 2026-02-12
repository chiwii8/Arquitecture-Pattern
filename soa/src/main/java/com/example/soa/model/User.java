package com.example.soa.model;

import jakarta.persistence.*;

/**
 * User.java
 * <p>
 * Description: Basic class for user
 *
 * @author aleja
 * @since 12/02/2026
 */

@Entity
@Table(name = "users")
public class User {

    private long id;

    private String name;
    private String email;

    public User() {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
