package com.wissnhub.api.domain.topic.validations.creation;

import com.wissnhub.api.domain.TopicValidationException;
import com.wissnhub.api.domain.topic.TopicCreationDTO;
import org.springframework.stereotype.Component;

@Component
public class ValidationAllFieldsAreMandatory implements ValidationManager {

    @Override
    public void validate(TopicCreationDTO topicCreationData) {
        if (topicCreationData.userId() == null) {
            throw new TopicValidationException("All fields are mandatory");
        }
        if (topicCreationData.message() == null) {
            throw new TopicValidationException("All fields are mandatory");
        }
        if (topicCreationData.title() == null) {
            throw new TopicValidationException("All fields are mandatory");
        }
        if (topicCreationData.courseId() == null) {
            throw new TopicValidationException("All fields are mandatory");
        }
    }
}
