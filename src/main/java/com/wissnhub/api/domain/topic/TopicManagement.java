package com.wissnhub.api.domain.topic;

import com.wissnhub.api.domain.TopicValidationException;
import com.wissnhub.api.domain.topic.validations.creation.ValidationManager;
import com.wissnhub.api.domain.topic.validations.update.ValidationUpdateManager;
import com.wissnhub.api.domain.user.User;
import com.wissnhub.api.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TopicManagement {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private List<ValidationManager> validations;

    @Autowired
    private List<ValidationUpdateManager> updateValidations;

    public TopicListingDTO create(TopicCreationDTO topicCreationData) {
        var user = getUser(topicCreationData);
        //Exception
        if (user == null) {
            throw new TopicValidationException("Usuario no disponible");
        }
        //Validations
        validations.forEach(v -> v.validate(topicCreationData));

        var topic = new Topic(null, topicCreationData.title(), topicCreationData.message(),
                LocalDateTime.now(), Status.OPEN, user, topicCreationData.courseId());
        topicRepository.save(topic);
        return new TopicListingDTO(topic);
    }

    private User getUser(TopicCreationDTO topicCreationData) {
        if (topicCreationData.userId() == null) {
            throw new TopicValidationException("Introduzca usuario");
        }
       return userRepository.getReferenceById(topicCreationData.userId());
    }


    public Page<TopicListCompleteDTO> listAll(Pageable pagination) {
        return topicRepository.findByActiveTrue(pagination).map(TopicListCompleteDTO::new);
    }

    public TopicListCompleteDTO listById(Long id) {
        Topic topic = topicRepository.getReferenceById(id);
        if (!topic.getActive()) {
            return null;
        }
        return new TopicListCompleteDTO(topic);
    }

    public TopicListCompleteDTO update(Long id, TopicUpdateDTO topicUpdateDTO) {
        updateValidations.forEach(v -> v.validate(topicUpdateDTO));
        Optional<Topic> topic = topicRepository.findById(id);
        if (topic.isPresent()) {
            var topicChange = topicRepository.getReferenceById(id);
            if (!topicChange.getActive()) {
                return null;
            }
            if (topicUpdateDTO.title() != null) {
                topicChange.setTitle(topicUpdateDTO.title());
            }
            if (topicUpdateDTO.message() != null) {
                topicChange.setMessage(topicUpdateDTO.message());
            }
            if (topicUpdateDTO.status() != null) {
                topicChange.setStatus(topicUpdateDTO.status());
            }
            if (topicUpdateDTO.courseId() != null) {
                topicChange.setCourseId(topicUpdateDTO.courseId());
            }
        }
        return new TopicListCompleteDTO(topicRepository.getReferenceById(id));
    }

    public void deactivate(Long id) {
        var topic = topicRepository.getReferenceById(id);
        topic.setActive(false);
        topic.setStatus(Status.ARCHIVED);
    }
}
