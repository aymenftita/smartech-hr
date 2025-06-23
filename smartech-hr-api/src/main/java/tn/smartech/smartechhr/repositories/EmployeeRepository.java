package tn.smartech.smartechhr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.smartech.smartechhr.entities.Employee;
import tn.smartech.smartechhr.entities.RoleType;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAllByRole(RoleType role);
}
