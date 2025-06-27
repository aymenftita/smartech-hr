package tn.smartech.smartechhr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.smartech.smartechhr.entities.*;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {


}

