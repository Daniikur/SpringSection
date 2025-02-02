package com.example.repo;

import com.example.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskRepo extends JpaRepository<Task, Long> {
    List<Task> findByUserId(Long userId);
}
