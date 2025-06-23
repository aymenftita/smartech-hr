package tn.smartech.smartechhr.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.smartech.smartechhr.entities.TaskAssignmentRequest;
import tn.smartech.smartechhr.services.TaskService;

import java.time.LocalDate;


@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    @Autowired
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/assign")
    public ResponseEntity<String> assignTasks(@RequestBody TaskAssignmentRequest request) {
        taskService.assignTasks(request);
        return ResponseEntity.ok("Tasks assigned successfully.");
    }

    /*@GetMapping("/operator/{operatorId}/week")
    public ResponseEntity<List<Task>> getTasksForWeek(
            @PathVariable Long operatorId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate weekStart) {

        return ResponseEntity.ok(taskService.getTasksForOperatorWeek(operatorId, weekStart));
    }*/

    @PutMapping("/{taskId}/done")
    public ResponseEntity<String> markTaskDone(@PathVariable Long taskId) {
        taskService.markTaskDone(taskId);
        return ResponseEntity.ok("Task marked as done.");
    }

    @PostMapping("/reassign")
    public ResponseEntity<String> reassignTasks(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate weekStart) {
        taskService.reassignReportedTasks(weekStart);
        return ResponseEntity.ok("Unfinished tasks reassigned to next week.");
    }
}

