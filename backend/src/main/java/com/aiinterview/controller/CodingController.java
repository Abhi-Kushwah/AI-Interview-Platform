package com.aiinterview.controller;

import com.aiinterview.service.CodingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/code")
public class CodingController {

    @Autowired
    private CodingService service;

    @PostMapping("/run")
    public String run(@RequestBody String code) {
        return service.runCode(code);
    }
}
