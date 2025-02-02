package com.example.controller;

import com.example.model.Task;
import com.example.model.Users;
import com.example.service.TaskService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Task> getTasks(@AuthenticationPrincipal UserDetails user) {
        Users currentUser = userService.getUserByUsername(user.getUsername());
        return taskService.getTasksByUserId(currentUser.getId());
    }

    @PostMapping
    public Task createTask(@RequestBody Task task, @AuthenticationPrincipal UserDetails user) {
        Users currentUser = userService.getUserByUsername(user.getUsername());
        task.setUser(currentUser);
        return taskService.createTask(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
