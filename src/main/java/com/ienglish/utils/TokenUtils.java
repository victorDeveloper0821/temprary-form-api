package com.ienglish.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface TokenUtils {
    public final static Logger logger = LogManager.getLogger(TokenUtils.class);
    public String generateToken();
}
