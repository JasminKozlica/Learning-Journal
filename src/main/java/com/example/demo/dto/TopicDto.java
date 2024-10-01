package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TopicDto {

    private String topicName;

    private Date assigmentDate;

    private Date dueDate;

    private boolean status;
}
