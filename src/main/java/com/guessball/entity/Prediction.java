package com.guessball.entity;

import lombok.Data;
import java.time.OffsetDateTime;

@Data
public class Prediction {
    private Long id;
    private Long userId;
    private Long matchId;
    private Integer predictedHome;
    private Integer predictedAway;
    private Integer pointsEarned;
    private Boolean settled;
    private OffsetDateTime createdAt;
}
