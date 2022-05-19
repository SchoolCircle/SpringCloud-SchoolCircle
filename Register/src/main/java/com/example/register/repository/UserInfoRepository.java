package com.example.register.repository;

import com.example.register.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
    List<UserInfo> findUserInfosByUid(Integer uid);

    List<UserInfo> findUserInfosByEmail(String email);
}