package com.wissnhub.api.domain.topic.validations.creation;

import com.wissnhub.api.domain.TopicValidationException;
import com.wissnhub.api.domain.topic.TopicCreationDTO;
import com.wissnhub.api.domain.topic.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidationTopicsMustNotBeDuplicated implements ValidationManager {

    @Autowired
    private TopicRepository topicRepository;

    @Override
    public void validate(TopicCreationDTO topicCreationData) {
        var topicWithSameTitleAndMessage = topicRepository.existsByTitleAndMessageAndActiveIsTrue(topicCreationData.title(), topicCreationData.message());
        if (topicWithSameTitleAndMessage) {
            throw new TopicValidationException("This topic has been created already");
        }
    }
}
