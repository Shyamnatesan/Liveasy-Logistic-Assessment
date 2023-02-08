
package com.example.liveeasylogisticassessment.repository;

import com.example.liveeasylogisticassessment.Entity.Loads;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LoadRepository extends JpaRepository<Loads, UUID> {

}

