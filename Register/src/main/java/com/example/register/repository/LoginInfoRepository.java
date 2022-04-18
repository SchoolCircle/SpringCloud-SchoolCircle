package com.example.register.repository;

import com.example.register.entity.LoginInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginInfoRepository extends JpaRepository<LoginInfo, Integer> {
}