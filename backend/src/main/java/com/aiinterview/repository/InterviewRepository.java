package com.aiinterview.repository;

import com.aiinterview.model.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewRepository extends JpaRepository<Interview, Long> {
}