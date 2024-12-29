package com.wissnhub.api.domain.topic.validations.update;

import com.wissnhub.api.domain.topic.TopicCreationDTO;
import com.wissnhub.api.domain.topic.TopicUpdateDTO;

public interface ValidationUpdateManager {

    void validate(TopicUpdateDTO topicUpdateData);
}
