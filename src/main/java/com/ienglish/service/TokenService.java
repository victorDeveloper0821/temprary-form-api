package com.ienglish.service;

import com.ienglish.domain.TokenReserve;
import com.ienglish.repository.TokenHistoryRepository;
import com.ienglish.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TokenService {
    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private TokenHistoryRepository tokenHistoryRepository;

    public TokenReserve getTokenInfoByToken(String token){
        Optional<TokenReserve> tokenOpt = tokenRepository.findByToken(token);
        return tokenOpt.orElse(new TokenReserve());
    }
}
