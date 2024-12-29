package com.wissnhub.api.domain.topic.validations.creation;

import com.wissnhub.api.domain.topic.TopicCreationDTO;

public interface ValidationManager {

    void validate(TopicCreationDTO topicCreationData);

}
