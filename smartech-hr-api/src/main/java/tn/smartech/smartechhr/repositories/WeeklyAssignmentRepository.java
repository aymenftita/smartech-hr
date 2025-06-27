package tn.smartech.smartechhr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.smartech.smartechhr.entities.Employee;
import tn.smartech.smartechhr.entities.WeeklyAssignment;

import java.util.Optional;

public interface WeeklyAssignmentRepository extends JpaRepository<WeeklyAssignment, Long> {

}
