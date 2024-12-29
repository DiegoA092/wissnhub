package com.wissnhub.api.domain.topic;

import com.wissnhub.api.domain.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public record TopicListCompleteDTO(
        //título, mensaje, fecha de creación, estado, autor y curso
        Long id,
        String title,
        String message,
        LocalDateTime creationDate,
        String user,
        Status status,
        Integer courseId
) {
    public TopicListCompleteDTO(Topic topic) {
        this(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getCreationDate(), topic.getUserId().getUsername() ,topic.getStatus(), topic.getCourseId());
    }
}
