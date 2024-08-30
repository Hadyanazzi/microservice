package com.test.repositories;

import com.test.entities.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Integer> {
//    List<Token> findByUserIdAndExpiredAndRevoked(Long userId, Boolean isExpired, Boolean isRevoked);

    Optional<Token> findByToken(String token);
}
