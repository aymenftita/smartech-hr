package tn.smartech.smartechhr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.smartech.smartechhr.entities.Answer;
import tn.smartech.smartechhr.services.AnswerService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/answer")
@CrossOrigin
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @GetMapping
    public List<Answer> getAll() {
        return answerService.getAll();
    }

    @GetMapping("/{id}")
    public Answer getById(@PathVariable Long id) {
        return answerService.getById(id);
    }

    @PostMapping
    public Answer create(@RequestBody Answer answer) {
        return answerService.create(answer);
    }

    @PutMapping("/{id}")
    public Answer update(@PathVariable Long id, @RequestBody Answer answer) {
        return answerService.update(id, answer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        answerService.delete(id);
    }
}

