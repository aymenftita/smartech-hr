package tn.smartech.smartechhr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.smartech.smartechhr.entities.Survey;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {
}
