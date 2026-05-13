package com.guessball.entity;

import lombok.Data;
import java.time.OffsetDateTime;

@Data
public class Match {
    private Long id;
    private Integer externalId;
    private String competition;
    private String homeTeamCode;
    private String awayTeamCode;
    private String homeTeamName;
    private String awayTeamName;
    private String homeTeamCrest;
    private String awayTeamCrest;
    private OffsetDateTime matchTime;
    private OffsetDateTime predictDeadline;
    private String stage;
    private String groupName;
    private Integer matchday;
    private Integer homeScore;
    private Integer awayScore;
    private Integer homeScoreEt;
    private Integer awayScoreEt;
    private Integer homeScorePk;
    private Integer awayScorePk;
    private String winner;
    private String status;
    private OffsetDateTime lastSyncedAt;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    /** 是否已经开始（用于截止竞猜判断） */
    public boolean isDeadlinePassed() {
        return OffsetDateTime.now().isAfter(predictDeadline);
    }

    /** 显示用比分字符串，未开始显示 - */
    public String getScoreDisplay() {
        if (homeScore == null || awayScore == null) return "-";
        String base = homeScore + " : " + awayScore;
        if (homeScorePk != null && awayScorePk != null) {
            base += " (PK " + homeScorePk + "-" + awayScorePk + ")";
        } else if (homeScoreEt != null && awayScoreEt != null) {
            base += " (ET)";
        }
        return base;
    }

    /** stage 中文显示 */
    public String getStageName() {
        return switch (stage == null ? "" : stage) {
            case "group"        -> "小组赛";
            case "league"       -> "联赛阶段";
            case "playoff"      -> "资格赛";
            case "round_of_16" -> "十六强";
            case "quarter_final"-> "八强";
            case "semi_final"   -> "半决赛";
            case "third_place"  -> "三四名";
            case "final"        -> "决赛";
            default             -> stage;
        };
    }
}
