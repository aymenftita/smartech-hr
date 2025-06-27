package tn.smartech.smartechhr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.smartech.smartechhr.entities.*;
import tn.smartech.smartechhr.repositories.EmployeeRepository;
import tn.smartech.smartechhr.repositories.TaskRepository;
import tn.smartech.smartechhr.repositories.WeeklyAssignmentRepository;
import tn.smartech.smartechhr.repositories.WeeklyScoreRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;



    public List<Task> getTasks() {
        return taskRepository.findAll();
    }
}