package com.wissnhub.api.domain.topic;

import java.time.LocalDateTime;

public record TopicListingDTO(
        Long id,
        String title,
        String message,
        LocalDateTime creationDate
) {
    public TopicListingDTO(Topic topic) {
        this(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getCreationDate());
    }
}
