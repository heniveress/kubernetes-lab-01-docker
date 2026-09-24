package com.example.coffee_log.controller;

import com.example.coffee_log.dto.BrewRequest;
import com.example.coffee_log.model.Brew;
import com.example.coffee_log.service.BrewService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/brews")
public class BrewController {

    private final BrewService service;

    public BrewController(BrewService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Brew addBrew(@RequestBody BrewRequest request) {
        return service.logBrew(request.capsuleName(), request.size(), request.intensity());
    }

    @GetMapping
    public List<Brew> getAllBrews() {
        return service.getAllBrews();
    }

    @GetMapping("/stats")
    public Map<String, Object> getStats() {
        return service.getStats();
    }
}
