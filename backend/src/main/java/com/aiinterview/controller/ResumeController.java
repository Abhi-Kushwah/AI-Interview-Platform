

package com.aiinterview.controller;

import com.aiinterview.service.AIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/resume")
@CrossOrigin(origins = "*") // frontend connect ke liye (React etc.)
public class ResumeController {

    @Autowired
    private AIService service;

    @PostMapping("/analyze")
    public String analyze(@RequestBody Map<String, String> body) {

        // Input extract karo
        String text = body.get("text");

        // Safety check
        if (text == null || text.isEmpty()) {
            return "❌ Text is missing";
        }

        // Service call
        return service.analyze(text);
    }
}