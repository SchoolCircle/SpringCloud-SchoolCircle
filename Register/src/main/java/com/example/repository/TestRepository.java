package com.example.repository;

import com.example.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TestRepository extends JpaRepository<Test, Integer> {

}
