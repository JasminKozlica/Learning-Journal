package com.example.demo;

import com.example.demo.dto.TopicDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public Topic createTopic(TopicDto newTopic){
        Topic topic = Topic.builder()
                .topicName(newTopic.getTopicName())
                .status(newTopic.isStatus())
                .assigmentDate(newTopic.getAssigmentDate())
                .dueDate(newTopic.getDueDate())
                .build();

        return  topicRepository.save(topic);
    }
    public Optional<Topic> findByTopicId(Long assigmentId){
        return topicRepository.findById(assigmentId);
    }

    public List<Topic> getAllTopics(){
        return topicRepository.findAll();
    }

    public void deleteTopic(Long assigmentId){
        try{
            topicRepository.deleteById(assigmentId);
        } catch (Exception e) {
            throw new RuntimeException("not foundTopic whit that ID ");

            }
        }

    }


