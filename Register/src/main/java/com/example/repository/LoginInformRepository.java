package com.example.repository;

import com.example.entity.LoginInform;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginInformRepository extends JpaRepository<LoginInform, Integer> {
}