package com.ienglish.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 表單回應的內容
 */
@Entity
@Table(name="Form")
@Data
public class FormContent {
    @Id
    private Long form_id;

    private String token;

    @Column(length = 20, nullable = false)
    private String first_name;

    @Column(length = 20, nullable = false)
    private String last_name;

    // 電話號碼
    @Column(length = 16, nullable = false)
    private String msisdn;

    // email address
    @Column(length = 20)
    private String email;

    private String content;
}
