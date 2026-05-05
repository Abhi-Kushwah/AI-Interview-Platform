
package com.aiinterview.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.HashMap;
import java.util.Map;

@Service
public class AIService {

    public String analyze(String text) {

        String url = "http://localhost:5000/analyze/resume";

        RestTemplate restTemplate = new RestTemplate();

        // ✅ JSON body banao
        Map<String, String> body = new HashMap<>();
        body.put("text", text);

        // ✅ Headers set karo
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // ✅ Request entity
        HttpEntity<Map<String, String>> request = new HttpEntity<>(body, headers);

        // ✅ API call
        return restTemplate.postForObject(url, request, String.class);
    }
}