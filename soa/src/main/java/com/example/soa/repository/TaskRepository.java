package com.example.soa.repository;

import com.example.soa.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * TaskRepository.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 12/02/2026
 */

public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findByUserId(long userId);
}
