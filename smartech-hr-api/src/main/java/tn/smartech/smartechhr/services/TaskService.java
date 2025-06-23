package tn.smartech.smartechhr.services;


import org.springframework.stereotype.Service;
import tn.smartech.smartechhr.entities.*;
import tn.smartech.smartechhr.repositories.EmployeeRepository;
import tn.smartech.smartechhr.repositories.TaskRepository;
import tn.smartech.smartechhr.repositories.WeeklyScoreRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service

public class TaskService {

    private final TaskRepository taskRepository;
    private final EmployeeRepository employeeRepository;
    private final WeeklyScoreRepository weeklyScoreRepository;

    public TaskService(TaskRepository taskRepository, EmployeeRepository employeeRepository, WeeklyScoreRepository weeklyScoreRepository) {
        this.taskRepository = taskRepository;
        this.employeeRepository = employeeRepository;
        this.weeklyScoreRepository = weeklyScoreRepository;
    }


    public void assignTasks(TaskAssignmentRequest request) {

        Employee operator = employeeRepository.findById(request.getOperatorId())
                .orElseThrow(() -> new RuntimeException("Operator not found"));

        int totalDays = request.getTasks().stream()
                .mapToInt(TaskAssignmentRequest.TaskItem::getEstimatedDays)
                .sum();

        if (totalDays != 5) {
            throw new IllegalArgumentException("Total estimated days must be exactly 5.");
        }

        for (TaskAssignmentRequest.TaskItem item : request.getTasks()) {
            Task task = new Task();
            task.setTitle(item.getTitle());
            task.setDescription(item.getDescription());
            task.setEstimatedDays(item.getEstimatedDays());
            task.setOperator(operator);
            task.setWeekStart(request.getWeekStart());
            taskRepository.save(task);
        }
    }

    /*public Optional<WeeklyScore> getTasksForOperatorWeek(Long operatorId, LocalDate weekStart) {
        return taskRepository.findByOperatorIdAndWeekStart(operatorId, weekStart);
    }*/

    public void markTaskDone(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setDone(true);
        task.setUpdatedAt(LocalDateTime.now());
        taskRepository.save(task);
    }

    public void reassignReportedTasks(LocalDate weekStart) {
        List<Task> reported = taskRepository.findAllByWeekStartAndIsDoneFalse(weekStart);

        for (Task oldTask : reported) {
            oldTask.setReported(true);
            taskRepository.save(oldTask);

            Task newTask = new Task();
            newTask.setTitle(oldTask.getTitle());
            newTask.setDescription(oldTask.getDescription());
            newTask.setEstimatedDays(oldTask.getEstimatedDays());
            newTask.setOperator(oldTask.getOperator());
            newTask.setWeekStart(weekStart.plusWeeks(1));
            taskRepository.save(newTask);
        }
    }


    /*public void calculateWeeklyScores(LocalDate weekStart) {
        List<Employee> operators = employeeRepository.findAllByRole(RoleType.OPERATOR);

        for (Employee operator : operators) {
            Integer score = taskRepository.getWeeklyScore(operator.getId(), weekStart);
            WeeklyScore weeklyScore = new WeeklyScore();
            weeklyScore.setOperator(operator);
            weeklyScore.setWeekStart(weekStart);
            weeklyScore.setScore(score != null ? score : 0);
            weeklyScoreRepository.save(weeklyScore);
        }
    }*/

}

