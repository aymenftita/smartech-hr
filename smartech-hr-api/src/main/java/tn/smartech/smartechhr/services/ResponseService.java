package tn.smartech.smartechhr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.smartech.smartechhr.entities.Response;
import tn.smartech.smartechhr.repositories.ResponseRepository;
import tn.smartech.smartechhr.repositories.SurveyRepository;

import java.util.List;

@Service
public class ResponseService {

    @Autowired
    private ResponseRepository responseRepository;

    public List<Response> getAll() {
        return responseRepository.findAll();
    }

    public Response getById(Long id) {
        return responseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Response not found"));
    }

    public Response create(Response response) {
        if (response.getAnswers() != null) {
            response.getAnswers().forEach(answer -> answer.setResponse(response));
        }
        return responseRepository.save(response);
    }

    public void delete(Long id) {
        responseRepository.deleteById(id);
    }
}

