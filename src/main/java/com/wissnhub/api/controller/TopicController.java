package com.wissnhub.api.controller;

import com.wissnhub.api.domain.TopicValidationException;
import com.wissnhub.api.domain.topic.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@SecurityRequirement(name = "bearer-key")
public class TopicController {

    @Autowired
    private TopicManagement topicManagement;

    @RequestMapping("/topics/")
    public ResponseEntity missingIdRequest() {
        throw new TopicValidationException("Introduce /ID");
    }

    //CREATE TOPIC
    @PostMapping("/topics")
    @Transactional
    public ResponseEntity<TopicListingDTO> create(@RequestBody @Valid TopicCreationDTO topicCreationData, UriComponentsBuilder uriComponentsBuilder) {
        var topicDetails = topicManagement.create(topicCreationData);
        URI url = uriComponentsBuilder.path("/topics/{id}").buildAndExpand(topicDetails.id()).toUri();
        return ResponseEntity.created(url).body(topicDetails);
    }

    @GetMapping("/topics")
    public ResponseEntity<Page<TopicListCompleteDTO>> listTopics (@PageableDefault(size = 5)Pageable pagination) {
        var topicsList = topicManagement.listAll(pagination);
        return ResponseEntity.ok(topicsList);
    }

    @GetMapping("/topics/{id}")
    public ResponseEntity<TopicListCompleteDTO> listTopic (@PathVariable Long id) {
        if (id == null) {
            throw new TopicValidationException("The 'id' field must be provided in the URI.");
        }
        TopicListCompleteDTO topicDetails = topicManagement.listById(id);
        if (topicDetails == null) {
            throw new TopicValidationException("Topic is not available");
        }
        return ResponseEntity.ok(topicDetails);
    }

    @PutMapping("/topics/{id}")
    @Transactional
    public ResponseEntity<TopicListCompleteDTO> update (@PathVariable Long id, @RequestBody @Valid TopicUpdateDTO topicUpdateDTO) {
        var updatedTopic = topicManagement.update(id, topicUpdateDTO);
        if (updatedTopic == null) {
            throw new TopicValidationException("Topic is not available");
        }
        return ResponseEntity.ok(updatedTopic);
    }

    @DeleteMapping("/topics/{id}")
    @Transactional
    public ResponseEntity deactivate (@PathVariable @NotNull Long id) {
        topicManagement.deactivate(id);
        return ResponseEntity.noContent().build();
    }

}
