package com.example.repository;

import com.example.entity.UserInform;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInformRepository extends JpaRepository<UserInform, Integer> {
}