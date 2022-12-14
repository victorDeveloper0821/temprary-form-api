package com.ienglish.utils.impl;

import com.ienglish.utils.TokenUtils;
import org.springframework.stereotype.Component;

@Component
public class GeneralTokenUtils implements TokenUtils {
    @Override
    public String generateToken() {
        logger.info("testing here");
        return null;
    }
}
