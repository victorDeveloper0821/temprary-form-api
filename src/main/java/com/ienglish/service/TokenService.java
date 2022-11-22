package com.ienglish.service;

import com.ienglish.domain.TokenInfo;
import com.ienglish.repository.TokenHistoryRepository;
import com.ienglish.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TokenService {
    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private TokenHistoryRepository tokenHistoryRepository;

    public TokenInfo getTokenInfoByToken(String token){
        Optional<TokenInfo> tokenOpt = tokenRepository.findByToken(token);
        return tokenOpt.orElse(new TokenInfo());
    }

    public List<TokenInfo> getAllRecord(){
        List<TokenInfo> tokenReserveList =  tokenRepository.findAll();
        return tokenReserveList;
    }
}
