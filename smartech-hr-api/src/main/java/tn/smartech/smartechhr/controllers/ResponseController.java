package tn.smartech.smartechhr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.smartech.smartechhr.entities.Response;
import tn.smartech.smartechhr.services.ResponseService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/response")
@CrossOrigin
public class ResponseController {

    @Autowired
    private ResponseService responseService;

    @GetMapping
    public List<Response> getAll() {
        return responseService.getAll();
    }

    @GetMapping("/{id}")
    public Response getById(@PathVariable Long id) {
        return responseService.getById(id);
    }

    @PostMapping
    public Response create(@RequestBody Response response) {
        return responseService.create(response);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        responseService.delete(id);
    }
}

