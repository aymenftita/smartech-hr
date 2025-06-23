package tn.smartech.smartechhr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.smartech.smartechhr.entities.Response;

@Repository
public interface ResponseRepository extends JpaRepository<Response, Long> {
}
