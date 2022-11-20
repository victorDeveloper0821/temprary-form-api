package com.ienglish.domain;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
/**
 * Form 表單 token 產生的 id
 */
@Entity
@Data
public class TokenReserve {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rsv_id", nullable = false)
    private Long rsv_id;

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

    // token 狀態
    @Column(columnDefinition = "SMALLINT")
    @Type(type = "org.hibernate.type.ShortType")
    private Short status;

    // token 字串
    private String token;

    // service type
    @Column(length = 10, nullable = false)
    private String token_type;


}
