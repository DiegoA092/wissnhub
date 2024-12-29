package com.wissnhub.api.domain.topic;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TopicCreationDTO(
        @NotNull
        Long userId,
        @NotNull
        String title,
        @NotNull
        String message,
        @NotNull
        Integer courseId
) {
}
