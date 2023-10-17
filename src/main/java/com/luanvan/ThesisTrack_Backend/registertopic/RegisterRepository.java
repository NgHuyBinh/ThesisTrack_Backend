package com.luanvan.ThesisTrack_Backend.registertopic;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luanvan.ThesisTrack_Backend.topic.Topic;

@Repository
public interface RegisterRepository extends JpaRepository<RegisterTopic, Integer> {
    Optional<RegisterTopic> findByStudentIdAndSemesterId(Integer studentId, Integer semesterId);

    Optional<RegisterTopic> findByTopicIdAndSemesterId(Integer topicId, Integer semesterId);
}
