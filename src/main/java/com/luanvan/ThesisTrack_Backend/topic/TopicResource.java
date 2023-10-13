package com.luanvan.ThesisTrack_Backend.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
// import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
// import org.springframework.web.client.HttpStatusCodeException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/topics")
public class TopicResource {

    @Autowired
    private TopicService topicService;

    @GetMapping
    public ResponseEntity<List<Topic>> getAllTopics() {
        List<Topic> topics = topicService.getAllTopics();
        return ResponseEntity.ok(topics);
    }

     @GetMapping("/teacher/{teacherId}")
     public ResponseEntity<List<Topic>> getTopicsByTeacher(@PathVariable Integer teacherId) {
         List<Topic> topics = topicService.getAllTopics();
         return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(topics);
     }

     @PostMapping
     public ResponseEntity<Topic> addTopic(@RequestBody Topic topic) {
         topicService.saveTopic (topic);
         return ResponseEntity.status(HttpStatus.CREATED).build();
     }

     @DeleteMapping("/{topicId}")
     public ResponseEntity<Void> deleteTopic(@PathVariable Integer topicId) {
         topicService.deleteTopic(topicId);
         return ResponseEntity.noContent().build();
     }

}
