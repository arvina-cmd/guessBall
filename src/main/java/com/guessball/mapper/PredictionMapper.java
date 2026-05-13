package com.guessball.mapper;

import com.guessball.entity.Prediction;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface PredictionMapper {
    Prediction findByUserIdAndMatchId(@Param("userId") Long userId, @Param("matchId") Long matchId);
    List<Prediction> findByUserId(Long userId);
    List<Prediction> findUnsettledByMatchId(Long matchId);
    int countSettledByMatchId(Long matchId);
    boolean existsByUserIdAndMatchId(@Param("userId") Long userId, @Param("matchId") Long matchId);
    int insert(Prediction prediction);
    int settle(@Param("id") Long id, @Param("pointsEarned") int pointsEarned);
}
