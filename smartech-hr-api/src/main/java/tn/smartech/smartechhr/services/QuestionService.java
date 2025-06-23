package tn.smartech.smartechhr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.smartech.smartechhr.entities.Question;
import tn.smartech.smartechhr.repositories.QuestionRepository;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    public Question getById(Long id) {
        return questionRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("Question not found"));
    }

    public List<Question> getBySurveyId(Long surveyId) {
        return questionRepository.findBySurveyId(surveyId);
    }

    public Question create(Question question) {
        return questionRepository.save(question);
    }

    public Question update(Long id, Question updated) {
        Question question = getById(id);
        question.setText(updated.getText());
        return questionRepository.save(question);
    }

    public void delete(Long id) {
        questionRepository.deleteById(Math.toIntExact(id));
    }
}
