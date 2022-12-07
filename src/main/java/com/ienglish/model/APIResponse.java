package com.ienglish.model;

import lombok.Data;

@Data
/**
 * API Response : API 回應的格式
 */
public class APIResponse {
    private boolean success;
    /**
     * Data Payload
     */
    private Object data;
    /**
     * 狀態碼
     */
    private short statusCode;
    /**
     * 狀態說明
     */
    private String message;
}
