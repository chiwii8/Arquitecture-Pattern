package com.example.monolith.repository;

import com.example.monolith.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TaskRepository.java
 * <p>
 * Description: Repository from the Task model, extends from JpaRepository
 *
 * @author aleja
 * @since 10/02/2026
 */

public interface TaskRepository extends JpaRepository<Task, Long> {


}
