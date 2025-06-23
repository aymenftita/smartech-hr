package tn.smartech.smartechhr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.smartech.smartechhr.entities.Survey;
import tn.smartech.smartechhr.services.SurveyService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/survey")
@CrossOrigin
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @GetMapping
    public List<Survey> getAll() {
        return surveyService.getAll();
    }

    @GetMapping("/{id}")
    public Survey getById(@PathVariable Long id) {
        return surveyService.getById(id);
    }

    @PostMapping
    public Survey create(@RequestBody Survey survey) {
        return surveyService.create(survey);
    }

    @PutMapping("/{id}")
    public Survey update(@PathVariable Long id, @RequestBody Survey survey) {
        return surveyService.update(id, survey);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        surveyService.delete(id);
    }
}
