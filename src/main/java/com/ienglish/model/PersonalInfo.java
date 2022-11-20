package com.ienglish.model;

import lombok.Data;

import java.io.Serializable;


@Data
public class PersonalInfo implements Serializable {
    private String name;
    private String msisdn;
    private String email;
}
