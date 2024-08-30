package com.test.services;


import com.test.entities.User;
import com.test.repositories.TokenRepository;
import com.test.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserService  {
    private static final String NOT_FOUND_ERROR_MESSAGE = "global.messages.notfound";
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private PasswordEncoder passwordEncoder;
    private final TokenRepository tokenRepository;

    @Autowired
    public UserService(UserRepository userRepository, JwtService jwtService, TokenRepository tokenRepository) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.tokenRepository = tokenRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

//    @Transactional
//    public RegisterLoginResponseDto register(RegisterRequestCommand requestDto) {
//        if (Boolean.TRUE.equals(userService.existByUsername(requestDto.getUsername())))
//            throw new BusinessFailedException(GlobalConstant.Key.USER, "global.messages.duplicate", StatusCode.BAD_REQUEST);
//        User user = User.builder()
//                .userId(requestDto.getUserId())
//                .username(requestDto.getUsername())
//                .password(passwordEncoder.encode(requestDto.getPassword()))
//                .build();
//        addUser(user);
//        AuthenticationResponseCommand responseJwt = jwtService.generateToken(user);
//        saveUserToken(user, responseJwt.getAccessToken());
//        return new RegisterLoginResponseDto(user.getUsername(), responseJwt.getAccessToken());
//    }

//    public void saveUserToken(User user, String jwtToken) {
//        tokenRepository.save(Token.builder()
//                .userId(user.getUserId())
//                .token(jwtToken)
//                .expired(false)
//                .revoked(false)
//                .build());
//    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public Boolean existByUsername(String userName) {
        return userRepository.existsByUsername(userName);
    }

//    @Transactional
//    public UserDetails loadUserByUsername(String userName) {
//        User user = userRepository.findByUsername(userName);
//        if (user == null) {
//            throw new BusinessFailedException(GlobalConstant.Key.USER, NOT_FOUND_ERROR_MESSAGE, StatusCode.NOT_FOUND);
//        }
//        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword());
//    }
}