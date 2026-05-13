package com.guessball.entity;

import lombok.Data;
import java.time.OffsetDateTime;

@Data
public class User {
    private Long id;
    private String username;
    private String email;
    private String passwordHash;
    private Integer totalPoints;
    private Integer exactHits;
    private Integer resultHits;
    private OffsetDateTime createdAt;
}
