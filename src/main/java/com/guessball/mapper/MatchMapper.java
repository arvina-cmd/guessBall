package com.guessball.mapper;

import com.guessball.entity.Match;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface MatchMapper {
    Match findById(Long id);
    Match findByExternalIdAndCompetition(@Param("externalId") Integer externalId,
                                         @Param("competition") String competition);
    List<Match> findByCompetition(String competition);
    List<Match> findTodayMatches();
    List<Match> findActiveMatches();
    int upsert(Match match);
}
