package com.example.demo;


import com.example.demo.dto.TopicDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
@AllArgsConstructor
@NoArgsConstructor
public class TopicController {

    @Autowired

    TopicService topicService;
    @PostMapping("/topic/create")
    public ResponseEntity<Topic> createTopic(@RequestBody Topic topic){
        Topic savedTopic = topicService.createTopic(new TopicDto());
        return ResponseEntity.ok(savedTopic);
    }

    @GetMapping("/topic/all")
    public ResponseEntity<List<Topic>> getAllTopic(){
        List<Topic> topics = topicService.getAllTopics();
        return ResponseEntity.ok(topics);
    }

    @GetMapping("/topic/{assigmentId")
    public ResponseEntity<Topic> findTopicById(@PathVariable Long assigmentId){
        Optional<Topic> topic = topicService.findByTopicId(assigmentId);
        return ResponseEntity.ok(topic.orElseThrow(()->
                new RuntimeException("Topic whit that ID not found ")));
    }

    @DeleteMapping("/assigmentId")
    public ResponseEntity<Void> deleteTopic(@PathVariable Long assigmentId){
        topicService.deleteTopic(assigmentId);
        return ResponseEntity.noContent().build();
    }
}
