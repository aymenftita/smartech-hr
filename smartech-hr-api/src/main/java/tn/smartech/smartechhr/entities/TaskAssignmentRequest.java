package tn.smartech.smartechhr.entities;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class TaskAssignmentRequest {
    private Long operatorId;
    private LocalDate weekStart;
    private List<TaskItem> tasks;

    @Data
    public static class TaskItem {
        private String title;
        private String description;
        private int estimatedDays;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getEstimatedDays() {
            return estimatedDays;
        }

        public void setEstimatedDays(int estimatedDays) {
            this.estimatedDays = estimatedDays;
        }
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public LocalDate getWeekStart() {
        return weekStart;
    }

    public void setWeekStart(LocalDate weekStart) {
        this.weekStart = weekStart;
    }

    public List<TaskItem> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskItem> tasks) {
        this.tasks = tasks;
    }
}
