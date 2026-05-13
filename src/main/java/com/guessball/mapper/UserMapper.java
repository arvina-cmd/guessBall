package com.guessball.mapper;

import com.guessball.entity.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface UserMapper {
    User findByUsername(String username);
    User findByEmail(String email);
    User findById(Long id);
    List<User> findAllOrderByPoints();
    int insert(User user);
    int addPoints(@Param("userId") Long userId,
                  @Param("points") int points,
                  @Param("exactHits") int exactHits,
                  @Param("resultHits") int resultHits);
}
