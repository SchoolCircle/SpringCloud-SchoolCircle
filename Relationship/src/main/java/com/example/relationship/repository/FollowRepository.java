package com.example.relationship.repository;

import com.example.relationship.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowRepository extends JpaRepository<Follow, Integer> {
    List<Follow> findFollowsByFollowed(Integer followed);

    List<Follow> findFollowsByFollowing(Integer following);

    // 判断有无关注信息
    boolean existsFollowsByFollowedAndAndFollowing(Integer followed, Integer following);

    List<Follow> findFollowsByFollowedAndFollowing(Integer followed, Integer following);
}