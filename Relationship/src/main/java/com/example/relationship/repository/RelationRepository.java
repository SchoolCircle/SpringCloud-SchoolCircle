package com.example.relationship.repository;

import com.example.relationship.entity.Relation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RelationRepository extends JpaRepository<Relation, Integer> {

    List<Relation> findRelationsByUid1AndAndIsAlive(Integer uid1, Integer isAlive);


}
