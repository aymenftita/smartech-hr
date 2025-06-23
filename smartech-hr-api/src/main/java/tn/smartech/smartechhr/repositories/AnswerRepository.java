package tn.smartech.smartechhr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.smartech.smartechhr.entities.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
