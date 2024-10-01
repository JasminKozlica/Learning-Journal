package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TopicRepository extends JpaRepository<Topic, Long> {
     Optional<Topic> findByTopicId(Long assigmentId);
     List<Topic> getAllTopics();
}
