package com.luanvan.ThesisTrack_Backend.week;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeekRepository extends JpaRepository<Week, Integer> {
    
}
// import org.springframework.data.jpa.repository.JpaRepository;

// public interface WeekRepository extends JpaRepository<WeekEntity, Long> {
//     // Custom query methods if needed
// }
