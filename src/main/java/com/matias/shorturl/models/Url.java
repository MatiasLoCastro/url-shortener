package com.matias.shorturl.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table(name = "url")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Url {

    @Id
    private Long id;

    private String originalUrl;
    private String shortCode;

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

}
