package com.ienglish.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;
@Data
public class TokenVO {
    private String token;
    private Short state;
    private String tokenType;
    private Date expiaryDate;
    private String first_name;
    private String last_name;

}
