package com.luanvan.ThesisTrack_Backend.teacher;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends  JpaRepository<Teacher, Integer>{
        Optional<Teacher> findByNumberTeacher(String numberTeacher);
}
