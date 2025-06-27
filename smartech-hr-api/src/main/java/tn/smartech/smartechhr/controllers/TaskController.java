package tn.smartech.smartechhr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.smartech.smartechhr.entities.Task;
import tn.smartech.smartechhr.entities.WeeklyScore;
import tn.smartech.smartechhr.repositories.TaskRepository;
import tn.smartech.smartechhr.services.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;



    @GetMapping
    public List<Task> getTasks() {
        return taskService.getTasks();
    }
}