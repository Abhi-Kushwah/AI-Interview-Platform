package com.aiinterview.repository;

import com.aiinterview.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result, Long> {
}