package com.wissnhub.api.domain;

public class TopicValidationException extends RuntimeException {
    public TopicValidationException(String mensaje) {
        super(mensaje);
    }
}
