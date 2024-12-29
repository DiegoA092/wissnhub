package com.wissnhub.api.domain.topic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    Page<Topic> findByActiveTrue(Pageable pagination);

    boolean existsByTitleAndMessageAndActiveIsTrue(String title, String message);
}