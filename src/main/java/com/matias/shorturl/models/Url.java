package com.matias.shorturl.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "url")
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String originalUrl;

    @Column(unique = true, nullable = false)
    private String shortCode;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

}
