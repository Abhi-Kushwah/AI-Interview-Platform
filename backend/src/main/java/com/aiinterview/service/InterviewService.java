package com.aiinterview.service;

import com.aiinterview.model.Interview;
import com.aiinterview.repository.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterviewService {

    @Autowired
    private InterviewRepository repo;

    public Interview create(Interview interview) {
        return repo.save(interview);
    }
}