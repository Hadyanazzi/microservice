package com.test.services;

import com.test.dto.request.AuthenticationRequestCommand;
import com.test.dto.request.RegisterRequestCommand;
import com.test.dto.response.AuthenticationResponseCommand;
import com.test.dto.response.RegisterLoginResponseDto;
import com.test.entities.Token;
import com.test.entities.User;
import com.test.jwt.JwtUtil;
import com.test.repositories.TokenRepository;
import com.test.repositories.UserRepository;
import com.test.shareddomain.constant.GlobalConstant;
import com.test.shareddomain.dto.response.BusinessFailedException;
import com.test.shareddomain.util.StatusCode;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class AuthService {
    private static final String NOT_FOUND_ERROR_MESSAGE = "global.messages.notfound";
    private final UserService userService;

    @Autowired
    public AuthService(@Lazy UserService userService) {
        this.userService = userService;
    }
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private TokenRepository tokenRepository;


    @Transactional
    public RegisterLoginResponseDto register(RegisterRequestCommand request) {
        if (Boolean.TRUE.equals(userService.existByUsername(request.getUsername())))
            throw new BusinessFailedException(GlobalConstant.Key.USER, "global.messages.duplicate", StatusCode.BAD_REQUEST);

        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        userService.addUser(user);
//        AuthenticationResponseCommand token = jwtService.generateToken(user);
//        saveUserToken(user, token.getAccessToken());

        return new RegisterLoginResponseDto(
                user.getUsername(), user.getPassword());
    }

    public String authenticate(AuthenticationRequestCommand request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        SecurityContextHolder.clearContext();
        return jwtUtil.createToken(userDetails.getUsername());
    }

    public void saveUserToken(User user, String jwtToken) {
        tokenRepository.save(Token.builder()
                .userId(user.getUserId())
                .token(jwtToken)
                .expired(false)
                .revoked(false)
                .build());
    }

//    private void revokeAllUserTokens(User user) {
//        List<Token> validUserTokens = tokenRepository.findByUserIdAndExpiredAndRevoked(user.getUserId(), false, false);
//        if (validUserTokens.isEmpty())
//            return;
//        validUserTokens.forEach(token -> {
//            token.setExpired(true);
//            token.setRevoked(true);
//        });
//        tokenRepository.saveAll(validUserTokens);
//    }
}