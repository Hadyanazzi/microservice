package com.test.controllers;

import com.test.controllers.transform.AuthDTOAssembler;
import com.test.dto.request.AuthenticationRequestDto;
import com.test.dto.request.RegisterRequestDto;
import com.test.services.AuthService;
import com.test.shareddomain.message.MessageUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
    private AuthService authService;
    private MessageUtils messageUtils;

    @Autowired
    public AuthController(@Lazy AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<Object> registerUser( @RequestBody RegisterRequestDto registerRequestDto){
        return ResponseEntity.ok(
                messageUtils.successDto(authService.register(AuthDTOAssembler.toRegisterUserCommand(registerRequestDto))));
    }

    @PostMapping("/login")
    public ResponseEntity<Object> createAuthToken(@RequestBody AuthenticationRequestDto requestDto){
        return ResponseEntity.ok(
                messageUtils.successDto(authService.authenticate(AuthDTOAssembler.toLoginRequestCommand(requestDto))));
    }
}