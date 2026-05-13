package com.guessball.entity;

import lombok.Data;
import java.time.OffsetDateTime;

@Data
public class GroupStanding {
    private Long id;
    private String competition;
    private String teamCode;
    private String teamName;
    private String teamCrest;
    private String groupName;
    private Integer position;
    private Integer played;
    private Integer won;
    private Integer drawn;
    private Integer lost;
    private Integer goalsFor;
    private Integer goalsAgainst;
    private Integer points;
    private OffsetDateTime updatedAt;

    public int getGoalDifference() {
        if (goalsFor == null || goalsAgainst == null) return 0;
        return goalsFor - goalsAgainst;
    }
}
