package com.example.relationship.repository;

import com.example.relationship.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsUserByUid(Integer uid);

    List<User> findUsersByUid(Integer uid);
}