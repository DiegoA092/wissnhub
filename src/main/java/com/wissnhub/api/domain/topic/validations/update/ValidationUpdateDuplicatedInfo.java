package com.wissnhub.api.domain.topic.validations.update;

import com.wissnhub.api.domain.TopicValidationException;
import com.wissnhub.api.domain.topic.TopicRepository;
import com.wissnhub.api.domain.topic.TopicUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidationUpdateDuplicatedInfo implements ValidationUpdateManager{

    @Autowired
    private TopicRepository topicRepository;

    @Override
    public void validate(TopicUpdateDTO topicUpdateData) {
        var topicWithSameTitleAndMessage = topicRepository.existsByTitleAndMessageAndActiveIsTrue(topicUpdateData.title(), topicUpdateData.message());
        if (topicWithSameTitleAndMessage) {
            throw new TopicValidationException("Title and message must be updated");
        }
    }
}
