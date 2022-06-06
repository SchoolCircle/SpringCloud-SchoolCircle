package com.example.register.repository;

import com.example.register.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsUserByEmail(String email);
    User findUserByEmail(String email);

    boolean existsUserByUid(Integer uid);

//    User findUserByUid(Integer uid);
    User findUserByUid(Integer uid);
}
