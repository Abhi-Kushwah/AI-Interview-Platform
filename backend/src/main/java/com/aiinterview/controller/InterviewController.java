package com.aiinterview.controller;

import com.aiinterview.model.Interview;
import com.aiinterview.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/interview")
public class InterviewController {

    @Autowired
    private InterviewService service;

    @PostMapping("/create")
    public Interview create(@RequestBody Interview interview) {
        return service.create(interview);
    }
}
