package com.ienglish.model;

import lombok.Data;

import java.io.Serializable;


@Data
public class PersonalInfo implements Serializable {
    private String first_name;
    private String last_name;
    private String msisdn;
    private String email;
    private String form_type;
}
