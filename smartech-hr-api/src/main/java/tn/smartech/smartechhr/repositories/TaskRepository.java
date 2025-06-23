package tn.smartech.smartechhr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.smartech.smartechhr.entities.Task;
import tn.smartech.smartechhr.entities.WeeklyScore;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByWeekStartAndIsDoneFalse(LocalDate weekStart);

    List<Task> findByOperatorIdAndWeekStart(Long operatorId, LocalDate weekStart);

}
