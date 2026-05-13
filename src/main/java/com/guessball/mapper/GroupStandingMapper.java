package com.guessball.mapper;

import com.guessball.entity.GroupStanding;
import java.util.List;

public interface GroupStandingMapper {
    List<GroupStanding> findByCompetition(String competition);
    int upsert(GroupStanding standing);
}
