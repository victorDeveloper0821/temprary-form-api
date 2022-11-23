package com.ienglish.service;

import com.ienglish.domain.TokenHistory;
import com.ienglish.domain.TokenInfo;
import com.ienglish.model.PersonalInfo;
import com.ienglish.repository.TokenHistoryRepository;
import com.ienglish.repository.TokenRepository;
import com.ienglish.utils.LogUtils;
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

    public void createTokenInfo (PersonalInfo info){
//        LogUtils.data(LogUtils.LogType.Info,"Service",null);
        TokenInfo token = new TokenInfo();
        token.setFirst_name(info.getFirst_name());
        token.setLast_name(info.getLast_name());
        token.setToken_type(info.getForm_type());
        token.setToken("aadfjkkfjjdnmsmsmsxxxvbhyy");
        token = tokenRepository.save(token);


        TokenHistory history = new TokenHistory();
        history.setToken(token.getToken());
        history.setFirst_name(info.getFirst_name());
        history.setLast_name(info.getLast_name());
        history.setMsisdn(info.getMsisdn());
        history.setEmail(info.getEmail());
        history.setStatus((short) 0);
        history.setToken_type(info.getForm_type());
        history.setTokenInfo(token);
        tokenHistoryRepository.save(history);
    }
}
