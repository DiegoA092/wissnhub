package com.wissnhub.api.domain.user;

public record UserAuthenticationDTO(
        String login,
        String passkey
) {
}
