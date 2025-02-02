package com.example.service;

import com.example.model.Task;
import com.example.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepo taskRepo;

    public List<Task> getTasksByUserId(Long userId) {
        return taskRepo.findByUserId(userId);
    }

    public Task createTask(Task task) {
        return taskRepo.save(task);
    }

    public void deleteTask(Long taskId) {
        taskRepo.deleteById(taskId);
    }
}
