package com.ienglish.service;

import com.ienglish.domain.TokenHistory;
import com.ienglish.domain.TokenInfo;
import com.ienglish.model.PersonalInfo;
import com.ienglish.model.TokenVO;
import com.ienglish.repository.TokenHistoryRepository;
import com.ienglish.repository.TokenRepository;
import com.ienglish.utils.LogUtils;
import com.ienglish.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TokenService {
    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private TokenHistoryRepository tokenHistoryRepository;
    @Autowired
    private TokenUtils tokenUtils;

    public Optional<TokenInfo> getTokenInfoByToken(String token){
        Optional<TokenInfo> tokenOpt = tokenRepository.findByToken(token);
        return tokenOpt;
    }

    public List<TokenInfo> getAllRecord(){
        List<TokenInfo> tokenReserveList =  tokenRepository.findAll();
        return tokenReserveList;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public String createTokenInfo (PersonalInfo info){
        Date today = new Date();
        TokenInfo token = new TokenInfo();
        token.setFirst_name(info.getFirst_name());
        token.setLast_name(info.getLast_name());
        token.setToken_type(info.getForm_type());
        token.setEmail(info.getEmail());
        token.setToken(tokenUtils.generateToken());
        token.setExiaryDate(new Date(today.getTime() + 2 * 60 * 60 * 24));
        token = tokenRepository.save(token);


        TokenHistory history = new TokenHistory();
        history.setToken(token.getToken());
        history.setStatus((short) 0);
        history.setToken_type(info.getForm_type());
        history.setTokenInfo(token);
        tokenHistoryRepository.save(history);
        return token.getToken();
    }

    public List<TokenHistory> findTokenHistory(){
        return tokenHistoryRepository.findAll();
    }

    public TokenVO findLatestHistoryByToken(String token){
        Optional<TokenHistory> historyOpt =  tokenHistoryRepository.findByTokenOrderByStatusTimeStampDesc(token);
        TokenVO tokenVO = new TokenVO();
        tokenVO.setTokenType(historyOpt.map(h->h.getToken_type()).orElse(""));
        tokenVO.setToken(historyOpt.map(h->h.getToken()).orElse(""));
        tokenVO.setExpiaryDate(historyOpt.map(h->h.getStatusTimeStamp()).orElse(null));
        tokenVO.setState(historyOpt.map(TokenHistory::getStatus).orElse((short)3));
        tokenVO.setFirst_name(historyOpt.map(h->h.getTokenInfo()).map(info->info.getFirst_name()).orElse(""));
        tokenVO.setLast_name(historyOpt.map(h->h.getTokenInfo()).map(info->info.getLast_name()).orElse(""));
        return tokenVO;
    }
}
