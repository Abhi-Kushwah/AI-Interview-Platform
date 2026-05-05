package com.aiinterview.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int score;
    private String feedback;
}