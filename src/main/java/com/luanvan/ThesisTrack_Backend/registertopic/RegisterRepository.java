package com.luanvan.ThesisTrack_Backend.registertopic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends JpaRepository<RegisterTopic, Integer> {
    
}
