package com.wissnhub.api.controller;

import com.wissnhub.api.domain.user.User;
import com.wissnhub.api.domain.user.UserAuthenticationDTO;
import com.wissnhub.api.infra.security.DataJWTToken;
import com.wissnhub.api.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity authenticateUser(@RequestBody @Valid UserAuthenticationDTO userAuthenticationDTO) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(userAuthenticationDTO.login(), userAuthenticationDTO.passkey());
        var authenticatedUser = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generarToken((User) authenticatedUser.getPrincipal());
        return ResponseEntity.ok(new DataJWTToken(JWTtoken));
    }
}
