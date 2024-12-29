package com.wissnhub.api.domain.topic.validations.update;

import com.wissnhub.api.domain.TopicValidationException;
import com.wissnhub.api.domain.topic.TopicUpdateDTO;
import org.springframework.stereotype.Component;

@Component
public class ValidationUpdateAllFieldsMandatory implements ValidationUpdateManager{
    @Override
    public void validate(TopicUpdateDTO topicUpdateData) {
        if (topicUpdateData.status() == null) {
            throw new TopicValidationException("All fields are mandatory");
        }
        if (topicUpdateData.message() == null) {
            throw new TopicValidationException("All fields are mandatory");
        }
        if (topicUpdateData.title() == null) {
            throw new TopicValidationException("All fields are mandatory");
        }
        if (topicUpdateData.courseId() == null) {
            throw new TopicValidationException("All fields are mandatory");
        }
    }
}
