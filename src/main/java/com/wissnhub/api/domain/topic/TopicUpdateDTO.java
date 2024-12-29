package com.wissnhub.api.domain.topic;

import com.wissnhub.api.domain.user.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

public record TopicUpdateDTO(
        String title,
        String message,
        Status status,
        Integer courseId
) {
}
