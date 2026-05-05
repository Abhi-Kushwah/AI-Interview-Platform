package com.aiinterview.service;

import org.springframework.stereotype.Service;

@Service
public class CodingService {

    public String runCode(String code) {
        return "Executed: " + code;
    }
}