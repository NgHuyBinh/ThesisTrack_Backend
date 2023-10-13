package com.luanvan.ThesisTrack_Backend.teachingschedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luanvan.ThesisTrack_Backend.subject.Subject;
import com.luanvan.ThesisTrack_Backend.teacher.Teacher;

import java.util.List;

@Repository
public interface TeachingScheduleRepository extends JpaRepository<TeachingSchedule, Integer> {

    List<TeachingSchedule> findByTeacher(Teacher teacher);

    List<TeachingSchedule> findBySubject(Subject subject);
}
