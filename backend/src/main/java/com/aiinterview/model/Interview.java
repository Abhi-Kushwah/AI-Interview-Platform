package com.aiinterview.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role;
    private String status;
}
